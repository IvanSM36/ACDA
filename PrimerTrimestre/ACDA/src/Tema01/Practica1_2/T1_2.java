package Tema01.Practica1_2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Tema01.XML.Practicas.ZooXML;

public class T1_2 {

	// Metodos

	/*
	 * Metodo que lee el fichero XML
	 * 
	 * @param Path
	 * 
	 * @return ArrayList
	 */
	public static ArrayList<SuperHeroe> leeXML(Path archivo) {
		SuperHeroe heroe = null;
		ArrayList<SuperHeroe> shs = null;

		try {
			// Preparamos el flujo de entrada del XML
			InputStream contenidoXML;
			contenidoXML = Files.newInputStream(archivo);

			// Preparamos el XML en memoria
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			// Parseamos de Files a Document
			Document doc = dBuilder.parse(contenidoXML);

			// Indicamos el nombre de la etiqueta para recorrer su contenido
			NodeList nodoSuperHeroes = doc.getElementsByTagName("superheroe");

			// Inicializamos el arrayList
			shs = new ArrayList<SuperHeroe>();
			// Recorremos con for los nodos repetidos
			for (int i = 0; i < nodoSuperHeroes.getLength(); i++) {
				Node nodo = nodoSuperHeroes.item(i);
				// Extraemosel contenido de las etiquetas
				Element e = (Element) nodo;
				String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();
				String arma = e.getElementsByTagName("arma").item(0).getTextContent();
				String anyo = e.getElementsByTagName("anyo").item(0).getTextContent();

				// Creamos un objeto heroe con los datos recogido
				heroe = new SuperHeroe(nombre, arma, Integer.parseInt(anyo));
				// Argegamos el heroe al Arraylist
				shs.add(heroe);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return shs;
	}

	/*
	 * 
	 * 
	 */
	public static void transXML(Path archivo) {
		// Declaramos el arrayList
		ArrayList<SuperHeroe> heroeXML = null;
		// Llamamos al metodo leeXML para recoger los datos
		heroeXML = leeXML(archivo);
		//
		Path destino = Paths.get("Ficheros/SuperHeroBK.txt");

		// Si no existe el archivo destino, lo crea
		if (!Files.exists(destino)) {
			try {
				Files.createFile(destino);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			// Abrimos flujo de escritura
			BufferedWriter bw = Files.newBufferedWriter(destino);
			// Recorremos el arrayList heroeXML y escribimos los datos en el archivo .txt
			for (int i = 0; i < heroeXML.size(); i++) {
				bw.write(heroeXML.get(i).toString() + "\n");
			}

			// Cerramos el flujo de escritura
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 
	 * 
	 */
	public static void creaXML(SuperHeroe sh) {
		try {
			// Creo una instancia de DocumentBuilderFactory
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        // Creo un documentBuilder
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        // Creo un DOMImplementation
	        DOMImplementation implementation = builder.getDOMImplementation();

	        // Creo un documento con un elemento raiz
	        Document documento = implementation.createDocument(null, "nuevoheroe", null);
	        documento.setXmlVersion("1.0");

	        // Creo los elementos
	        Element superheroes = documento.createElement("superheroes");
	        Element superheroe = documento.createElement("superheroe");

	        // nombre
	        Element nombre = documento.createElement("nombre");
	        Text textNombre = documento.createTextNode(sh.getNombre());
	        nombre.appendChild(textNombre);
	        superheroe.appendChild(nombre);

	        // arma
	        Element arma = documento.createElement("arma");
	        Text textArma = documento.createTextNode(sh.getArma());
	        arma.appendChild(textArma);
	        superheroe.appendChild(arma);

	        // años
	        String anyostext = String.valueOf(sh.getAnyo());
	        Element anyos = documento.createElement("anyos");
	        Text textAnyos = documento.createTextNode(anyostext);//cambiar valor anyo antes de introducir a un int
	        anyos.appendChild(textAnyos);
	        superheroe.appendChild(anyos);

	        // A�ado al elemento superheroes el elemento superheroe
	        superheroes.appendChild(superheroe);

	        // A�ado al root el elemento superheroes
	        documento.getDocumentElement().appendChild(superheroes);

	        // Asocio el source con el Document
	        Source source = new DOMSource(documento);
	        // Creo el Result, indicado que fichero se va a crear
	        Result result = new StreamResult(new File("nuevoheroe.xml"));

	        // Creo un transformer, se crea el fichero XML
	        Transformer transformer = TransformerFactory.newInstance().newTransformer();
	        transformer.transform(source, result);

			} catch (TransformerException tfe) {
		      tfe.printStackTrace();
		    } catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	/*
	 * 
	 */
	public static void main(String[] args) {

		ArrayList<SuperHeroe> heroeXML = null;
		SuperHeroe heroe= new SuperHeroe("","pistola",234);

		Path p1 = Paths.get("Ficheros/Marvel.xml");

		// Extraemos los datos del XML
		heroeXML = leeXML(p1);

		// Creamos un fichero con el contenido del Arraylist
		transXML(p1);

		creaXML(heroe);
	}

}
