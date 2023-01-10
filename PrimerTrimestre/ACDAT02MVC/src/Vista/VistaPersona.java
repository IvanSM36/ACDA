package Vista;

import java.util.ArrayList;
import java.util.Scanner;

import Controlador.ControladorPersona;
import Modelo.Persona;

public class VistaPersona {

	protected ArrayList<Persona> personas;
	protected String opcion;
	protected Scanner sc = VistaPrincipal.getScanner();

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
		for (Persona p : personas) {
			System.out.println(p);
		}
	}

	public void mostrarMenu() {
		opcion = " ";

		// Aqui mostramos las distintas opciones
		System.out.println();
		System.out.println("================================");
		System.out.println("         Tabla Persona");
		System.out.println("================================");
		System.out.println("--------------------------------");
		System.out.println("| 1. Añadir.                   |");
		System.out.println("| 2. Modificar.                |");
		System.out.println("| 3. Mostrar todo.             |");
		System.out.println("| 4. Mostrar por ID.           |");
		System.out.println("| 5. Borrar.                   |");
		System.out.println("| 6. Ejecutar procedimiento.   |");
		System.out.println("| 7. Ejecutar funcion.         |");
		System.out.println("| 8. Ejecutar transaccion.     |");
		System.out.println("| 0. Volver al menu principal. |");
		System.out.println("--------------------------------");
		System.out.println();

		System.out.print("Elige una opción: ");
		// Aqui realizamos la lectura por teclado de la opci�n
		opcion = sc.nextLine();
		System.out.println("");
	}

	public String getOpcion() {
		return opcion;
	}

	public String pedirDNI() {

		// Este metodo pide por teclado el DNI, para mostrar la persona en concreto
		System.out.print("Introduzca DNI: ");
		String dni = sc.nextLine();
		
		return dni;
	}

	public Persona pedirDatosPersona() {
		
		// Este metodo pide por teclado los datos de una persona.
		System.out.print("Introduzca dni: ");
		String dni = sc.nextLine();
		System.out.print("Introduzca nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Introduzca edad: ");
		int edad = sc.nextInt();
		
		// Creamos el objeto
		Persona p = new Persona(dni, nombre, edad);		

		return p;
	}

}
