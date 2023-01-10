package Tema01.XML;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PruebasXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// anadeEntXML();
		xmlDAM XMLDam = null;
		Path p1 = Paths.get("Ficheros/Alumnos.xml");
		// Extraemos los datos del XML
		XMLDam = leeXML(p1);

		// Añadimos un nuevo alumno a los datos, con sus dos módulos correspondientes.
		/*Modulo[] modulos = new Modulo[100];
		modulos[0] = new Modulo("Acceso a Datos", 9);
		modulos[1] = new Modulo("HLC", 10);
		Alumno a = new Alumno("Antonio", modulos);
		Alumno[] alumnos = XMLDam.getAlumnos();
		alumnos[2] = a;
		// Volvemos a montar el XML
		XMLDam.setAlumnos(alumnos);

		anadeEntXML(XMLDam);*/

	}

	public static void anadeEntXML(xmlDAM XMLDam) {

		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// Elemento Raíz
			Document doc = docBuilder.newDocument();
			Element raizElement = doc.createElement("DAM");
			doc.appendChild(raizElement);

			// Elementos simples
			// ciclo
			Element ciclo = doc.createElement("ciclo");
			ciclo.appendChild(doc.createTextNode(XMLDam.getCiclo()));
			raizElement.appendChild(ciclo);
			// curso
			Element curso = doc.createElement("curso");
			curso.appendChild(doc.createTextNode(String.valueOf(XMLDam.getCurso())));
			raizElement.appendChild(curso);
			// Elemento compuesto Alumnos
			Element alumnos = doc.createElement("alumnos");
			raizElement.appendChild(alumnos);

			Alumno al[] = XMLDam.getAlumnos();

			for (int i = 0; i < 3; i++) {

				// Elementos de alumnos, es decir alumno
				Element alumno = doc.createElement("alumno");
				alumnos.appendChild(alumno);
				// Establecer atributo
				Attr attr = doc.createAttribute("id");
				int ida = i + 1;
				attr.setValue(String.valueOf(ida));
				alumno.setAttributeNode(attr);

				// Elemento nombre
				Element nombre = doc.createElement("nombre");
				nombre.appendChild(doc.createTextNode(al[i].getNombre()));
				alumno.appendChild(nombre);
				// Elemento compuesto módulos
				Element modulos = doc.createElement("modulos");
				alumno.appendChild(modulos);
				Modulo m[] = al[i].getModulos();

				for (int j = 0; j < 2; j++) {
					// Elementos de módulos, es decir modulo
					Element modulo = doc.createElement("modulo");
					modulos.appendChild(modulo);
					// Establecer atributo
					Attr attrM = doc.createAttribute("id");
					int idm = j + 1;
					attrM.setValue(String.valueOf(idm));
					modulo.setAttributeNode(attrM);
					// Elemento nombre
					Element nombrem = doc.createElement("nombre");
					nombrem.appendChild(doc.createTextNode(m[j].getNombre()));
					modulo.appendChild(nombrem);
					// Elemento nota
					Element nota = doc.createElement("nota");
					nota.appendChild(doc.createTextNode(String.valueOf(m[j].getNota())));
					modulo.appendChild(nota);
				}

			}

			// Escribir el contenido al fichero XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("Ficheros/AlumnosBK.xml"));

			transformer.transform(source, result);

			System.out.println("Archivo guardado");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

	public static xmlDAM leeXML(Path p1) {

		xmlDAM XMLDam = null;
		Alumno[] alumnos = new Alumno[100];
		try {
			InputStream contenidoXML;
			contenidoXML = Files.newInputStream(p1);

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(contenidoXML);

			String ciclo = doc.getElementsByTagName("ciclo").item(0).getTextContent();
			String curso = doc.getElementsByTagName("curso").item(0).getTextContent();

			NodeList nodoAlumnos = doc.getElementsByTagName("alumno");

			System.out.println(ciclo + " " + curso);
			for (int i = 0; i < nodoAlumnos.getLength(); i++) {
				Node nodo = nodoAlumnos.item(i);
				Element e = (Element) nodo;
				String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();

				System.out.println(nombre);
				Modulo[] modulos = new Modulo[100];
				NodeList nodoModulos = doc.getElementsByTagName("modulo");
				for (int j = i * 2; j < (i * 2) + 2; j++) {
					Node nodo1 = nodoModulos.item(j % 2);
					Element e1 = (Element) nodo1;
					String nombrem = e1.getElementsByTagName("nombre").item(0).getTextContent();
					String nota = e1.getElementsByTagName("nota").item(0).getTextContent();
					System.out.println(nombrem + " " + nota);
					Modulo m = new Modulo(nombrem, Integer.parseInt(nota));
					modulos[j % 2] = m;

				}
				Alumno al = new Alumno(nombre, modulos);
				alumnos[i] = al;

			}
			XMLDam = new xmlDAM(ciclo, Integer.parseInt(curso), alumnos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return XMLDam;
	}

}
