package SegundoTrimestre.Tema04.T06_Matisse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.matisse.MtDatabase;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int opcion;
		
		////////// Menu //////////
		do {
			System.out.println(" ---------------------------------- ");
			System.out.println("| 1.- Visualizar datos de la BBDD. |");
			System.out.println("| 2.- Insertar datos en la BBDD.   |");     
			System.out.println(" ---------------------------------- ");

			System.out.print("Introduzca una opcion: ");
			opcion = scan.nextInt();
			System.out.println();

			// Creo un Switch para llamar a los metodos segun la opcion elegida
			switch (opcion) {

			case 1:
				
				do {
					System.out.println(" ------------------------------- ");
					System.out.println("| 1.- Visualizar tabla Grupo.  |");
					System.out.println("| 2.- Visualizar tabla Alumno. |");     
					System.out.println(" ------------------------------- ");

					System.out.print("Introduzca una opcion: ");
					opcion = scan.nextInt();
					System.out.println();

					// Creo un Switch para llamar a los metodos segun la opcion elegida
					switch (opcion) {

					case 1:			
						System.out.println();
						System.out.println("Datos de la tabla Grupo: ");
						System.out.println();
						Funciones.mostrarGrupos();
						System.out.println();
						break;
					case 2:
						System.out.println();
						System.out.println("Datos de la tabla Alumno: ");
						System.out.println();
						Funciones.mostrarAlumnos();
						System.out.println();			
						break;
					default:
						System.out.println("Has salido del programa");
					}
				} while (opcion != 0);
			
			case 2:
				do {
					System.out.println(" ----------------------------------------- ");
					System.out.println("| 1.- Insertar datos en la tabla Grupo.  |");
					System.out.println("| 2.- Insertar datos en la tabla Alumno. |");     
					System.out.println(" ----------------------------------------- ");

					System.out.print("Introduzca una opcion: ");
					opcion = scan.nextInt();
					System.out.println();

					// Creo un Switch para llamar a los metodos segun la opcion elegida
					switch (opcion) {

					case 1:
						System.out.println();
						System.out.println("Insertar datos en la tabla Grupo");
						System.out.println("--------------------------------");
						System.out.print("Introduzca cveGru: ");
						String cveG = scan.nextLine();
						System.out.print("Introduzca nomG: ");
						String nomG = scan.next();
						Funciones.insertarDatosGrupos(cveG, nomG);
						System.out.println();
						break;
					case 2:
											
						break;
					default:
						System.out.println("Has salido del programa");
					}
				} while (opcion != 0);
				break;

			default:
				System.out.println("Has salido del programa");
			}
		} while (opcion != 0);
	
	}

}
