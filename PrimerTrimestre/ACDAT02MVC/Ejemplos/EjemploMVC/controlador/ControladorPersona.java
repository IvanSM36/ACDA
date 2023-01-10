package controlador;

import vista.VistaPersona;
import modelo.PersonaCRUD;

import java.util.Scanner;

import modelo.Conexion;
import modelo.Persona;
public class ControladorPersona {
	protected VistaPersona vp;
	protected PersonaCRUD pc;
	protected static Scanner sc;
	public ControladorPersona() {
		this.vp = new VistaPersona();
		this.pc = new PersonaCRUD(Conexion.conectar());
	}


	
	public void menu() {
		
		String opcion = " ";
		vp.mostrarMenu();
		opcion = vp.getOpcion();
		while (!opcion.equals("0")) {
			
			// Aquí montamos crearemos un switch con el 
			// comportamiento de las distintas opciones.
			
			//Llamamos al método para mostrar la opción y nos traemos
			//la opción elegida.
			vp.mostrarMenu();
			opcion = vp.getOpcion();
		}
		
		
	}
	
	public void visualizar(String DNI) {
		this.vp = new VistaPersona(pc.leer(DNI));
		vp.mostrar();
	}
	
	public void anyadir(Persona p) {
		pc.insertar(p);
	}
	public void borrar(String DNI){
		
	}
	public void modificar(Persona p){
		
	}
	public void visualizarTodo(){
		
	}
	
	
	
}



