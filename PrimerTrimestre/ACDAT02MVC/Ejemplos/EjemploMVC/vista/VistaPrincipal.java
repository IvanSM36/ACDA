package vista;

import java.util.Scanner;

public class VistaPrincipal {

private String opcion;
protected static Scanner sc;
public VistaPrincipal(){
			this.opcion = " ";
		}
public void mostrarMenu() {
// Menú principal	
System.out.println("Aplicación BBDD. Elija una opción");
System.out.println("=================================");
System.out.println("Opción 1 .- Personas");
System.out.println("Opción 0 .- Salir");

// Lectura de la opción
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
