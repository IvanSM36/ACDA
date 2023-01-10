package vista;


import java.util.ArrayList;
import java.util.Scanner;

import controlador.ControladorPersona;
import modelo.Persona;
public class VistaPersona {
	
	protected ArrayList<Persona> personas; 
	protected String opcion;
	public VistaPersona() {
		this.personas = null;
	}
	public VistaPersona(ArrayList<Persona> pesonas) {
		this.personas = pesonas;
	}
	public VistaPersona(Persona persona) {
		this.personas = new ArrayList<Persona>();
	
		personas.add(persona);
	}
	
	public void mostrar() {
		for (Persona p:personas ) {
			System.out.println(p);
		}
	}
	
	public void mostrarMenu() {
		opcion = " ";
		
			//Aquí mostramos las distintas opciones 
			
			
			//Aquí realizamos la lectura por teclado de la opción
			Scanner sc = VistaPrincipal.getScanner();
			opcion = sc.nextLine();}
	


	public String getOpcion() {
		return opcion;
	}
	public String pedirDNI(){
		
		string DNI= " ";
		//Este método pide por teclado el DNI, para mostrar la persona en concreto
			
		return dni;
	}
	public Persona pedirDatosPersona(){
		
		Persona p;
		//Este método pide por teclado los datos de una persona
		//para modificarla o crearla
			
		return Persona;
	}

	
	

}
