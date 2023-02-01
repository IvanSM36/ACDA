package SegundoTrimestre.Tema04.T04_ObjetosEstructurados;

import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ObjectContainer db = Db4oEmbedded.openFile("charla.db4o");

		int opcion;

		do {
			System.out.println("-----------------------------------------");
			System.out.println("| 1.- Insertar objetos Charlas en la BD. |");
			System.out.println("| 2.- Modificar horas de una charla.     |");
			System.out.println("| 3.- Visualizar todos los objetos       |");
			System.out.println("| 4.- Borra solo charla                  |");
			System.out.println("| 5.- Mostrar ponentes                   |");
			System.out.println("| 0.- Salir                              |");
			System.out.println("-----------------------------------------");

			System.out.print("Introduzca una opcion: ");
			opcion = scan.nextInt();
			System.out.println();

			// Creo un Switch para llamar a los metodos segun la opcion elegida
			switch (opcion) {

			case 1:
				Funciones.insertarCharla(db);
				break;
			case 2:
				System.out.print("Introduzca titulo de la charla: ");
				String titulo = scan.next();
				System.out.print("Introduzca la nueva duracion: ");
				float duracion = scan.nextFloat();
				Funciones.modificarHorasCharlas(db, titulo, duracion);
				break;
			case 3:
				do {
					System.out.println("--------------------------");
					System.out.println("| 1.- Mostrar BBDD QBD.  |");
					System.out.println("| 2.- Mostrar BBDD SODA. |");
					System.out.println("| 0.- Salir.             |");
					System.out.println("--------------------------");

					System.out.print("Introduzca una opcion: ");
					opcion = scan.nextInt();

					// Creo un Switch para llamar a los metodos segun la opcion elegida
					switch (opcion) {

					case 1:
						Funciones.visualizarQBE(db);
						break;
					case 2:
						Funciones.visualizarSODA(db);
						break;

					default:
					}

				} while (opcion != 0);

				break;
			default:
				System.out.println("Has salido del programa");
			}
		} while (opcion != 0);

		db.close();

	}

}
