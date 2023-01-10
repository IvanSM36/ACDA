package Vista;

import java.util.Scanner;

public class VistaPrincipal {

	private String opcion;
	protected static Scanner sc;

	public VistaPrincipal() {
		this.opcion = " ";
	}

	public void mostrarMenu() {
// Menú principal	
		System.out.println("=================");
		System.out.println(" Aplicación BBDD ");
		System.out.println("=================");
		System.out.println("1. Personas");
		System.out.println("0. Salir");
		System.out.println();

// Lectura de la opción
		System.out.print("Introduzca una opción: ");
		Scanner sc = VistaPrincipal.getScanner();
		opcion = sc.nextLine();

	}

	public static Scanner getScanner() {
		// Método para usar el scanner como un sigleton
		if (sc == null)
			sc = new Scanner(System.in);

		return sc;
	}

	public String getOpcion() {

		return opcion;
	}
}
