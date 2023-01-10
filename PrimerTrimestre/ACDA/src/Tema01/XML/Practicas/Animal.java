package Tema01.XML.Practicas;

public class Animal {

	//Atributos
	private String nombre;
	private String raza;
	private String color;
	private String edad;
	
	
	/*
	 * Constructor
	 * 
	 */
	public Animal(String nombre, String raza, String color, String edad) {
		this.nombre = nombre;
		this.raza = raza;
		this.color = color;
		this.edad = edad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getEdad() {
		return edad;
	}


	public void setEdad(String edad) {
		this.edad = edad;
	}


	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", raza=" + raza + ", color=" + color + ", edad=" + edad + "]";
	} 
	
	
}
