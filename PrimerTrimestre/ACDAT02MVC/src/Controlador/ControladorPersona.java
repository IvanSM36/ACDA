package Controlador;

import Vista.VistaPersona;
import Modelo.Conexion;
import Modelo.Persona;
import Modelo.PersonaCRUD;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class ControladorPersona {
	protected static VistaPersona vp;
	protected static PersonaCRUD pc;

	public ControladorPersona() {
		this.vp = new VistaPersona();
		this.pc = new PersonaCRUD(Conexion.conectar());
	}

	/*
	 * Menú secundario. Aquí crearemos un switch con el comportamiento de las
	 * distintas opciones.
	 * 
	 * Llamamos al método para mostrar la opción y nos traemos la opción elegida.
	 */
	public void menu() {

		String opcion = " ";
		vp.mostrarMenu();
		opcion = vp.getOpcion();

		while (!opcion.equals("0")) {

			switch (opcion) {
			case "0":
				//ControladorPrincipal cprin = new ControladorPrincipal();
				//cprin.mostrarMenu();
				break;
			case "1":		
				anyadir(vp.pedirDatosPersona());			
				break;
			case "2":
				modificar(vp.pedirDatosPersona());
				break;
			case "3":
				visualizarTodo();
				break;
			case "4":
				visualizar(vp.pedirDNI());
				break;
			case "5":
				
				borrar(vp.pedirDNI());
				break;
			case "6":
				
				break;
			case "7":
				
				break;
			case "8":
				
				break;
			default:
				System.out.println("Opción errónea");
			}
			// Volvemos a mostrar el menu cuando terminemos una opcion.
			vp.mostrarMenu();
			opcion = vp.getOpcion();
		}

	}
	
	public void anyadir(Persona p) {
		pc.insertar(p);
		//vp.mostrar();

	}
	
	public void modificar(Persona p) {
		pc.modificar(p);
	}

	public void visualizarTodo() {
		vp = new VistaPersona(pc.leer());
		vp.mostrar();
	}
	
	public void visualizar(String DNI) {
		vp = new VistaPersona(pc.leer(DNI));
		vp.mostrar();
	}

	public void borrar(String DNI) {
		this.pc.borrar(DNI);
	}	

}
