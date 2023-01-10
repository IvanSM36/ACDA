/**
 * 
 */
package Tema01.XML.Practicas;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Tema01.XML.xmlDAM;


/**
 * @author IvanSM
 *
 */
public class main {

	////// Metodos //////
	
	/*
	 * Metodo que lee el fichero xml
	 * 
	 * @param Path
	 * @return 
	 */
	public static ZooXML leeXML(Path p1) {
		
		ZooXML xmlZOO = null;
		ArrayList<Animal> zoo = new ArrayList<Animal>();
		
		try {
			InputStream contenidoXML;
			contenidoXML = Files.newInputStream(p1);
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(contenidoXML);

			String zona  = doc.getElementsByTagName("Zona").item(0).getTextContent();
				
			NodeList nodoAnimales = doc.getElementsByTagName("Animal");
			
			System.out.println("Animales en el Zoo");
			System.out.println("------------------\n");
			System.out.println(zona + "\n");
			for (int i = 0; i < nodoAnimales.getLength(); i++) {
				Node nodo = nodoAnimales.item(i);
				Element e = (Element) nodo;
				String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();
				String raza = e.getElementsByTagName("raza").item(0).getTextContent();
				String color = e.getElementsByTagName("color").item(0).getTextContent();
				String edad = e.getElementsByTagName("edad").item(0).getTextContent();
				
				System.out.println("Nombre: " + nombre + "\nRaza: " + raza + "\nColor: " + color + "\nEdad: " + edad +"\n");				
			
				Animal animalitos= new Animal(nombre, raza, color, edad);
				zoo.add(animalitos);
			}
			xmlZOO = new ZooXML(zona, zoo);

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return xmlZOO;	
	}
	
	// System.out.println("Nombre: " + nombre + "\nRaza: " + raza + "\nColor: " + color + "\nEdad: " + edad);

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ZooXML xmlZoo =  null;
		Path p1 = Paths.get("Ficheros/Animales.xml");
		
		//Extraemos los datos del XML
		xmlZoo = leeXML(p1);
		
		
		
	}

}
