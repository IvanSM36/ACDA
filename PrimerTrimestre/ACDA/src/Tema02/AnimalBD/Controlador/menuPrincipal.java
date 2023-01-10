/**
 * 
 */
package Tema02.AnimalBD.Controlador;

import java.util.Scanner;

/**
 * @author IvanSM
 *
 */
public class menuPrincipal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		do {
			System.out.println("Menu acceso a datos");
			System.out.println("-------------------");
			System.out.println("1. Añadir.");
			System.out.println("2. Modificar.");
			System.out.println("3. Seleccionars.");
			System.out.println("4. Borrar.");
			System.out.println("0. Salir.");
			System.out.println();
			
			System.out.print("Elige una opción: ");
			opcion = scan.nextInt();
			
			switch (opcion) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;

			default:
				System.out.println("Error, por favor introduzca una opcion entre 0-4");
				break;
			}
			
			
		} while(opcion != 0);
		
		
		
	}

}
