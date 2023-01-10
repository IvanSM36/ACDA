package Tema01.XML.Practicas;

import java.util.ArrayList;
import java.util.Arrays;

public class ZooXML {

	/*
	 * Atributos
	 */
	private String zona;
	private ArrayList<Animal> animales; 

	/*
	 * Constructores
	 * 
	 * @param zona, Animal
	 * 
	 * @return null
	 */
	public ZooXML(String zona, ArrayList<Animal> animales) {
		this.zona = zona;
		this.animales = animales;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public ArrayList<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(ArrayList<Animal> animales) {
		this.animales = animales;
	}

	@Override
	public String toString() {
		return "ZooXML [zona=" + zona + ", animales=" + animales + "]";
	}

	

}

