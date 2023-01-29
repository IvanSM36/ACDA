package SegundoTrimestre.Tema04.T02_ConsultaBDO;

import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String dni = "";
		String email = "";

		// Creamos la conexion
		ObjectContainer db = Db4oEmbedded.openFile("ponentes.db4o");

		/*
		 * * Llamamos al almacenarPonentes
		 * 
		 */
		FuncionesCRUD.almacenarPonentes(db);

		/*
		 * * Llamamos al metodo consultarPonentes
		 * 
		 */
		System.out.println();
		System.out.println("Metodo consultar Ponentes");
		System.out.println("-------------------------");

		FuncionesCRUD.consultarPonentes(db);

		/*
		 * * Llamamos al metodo consultarPonentes200
		 * 
		 */
		System.out.println();
		System.out.println("Metodo consultar Ponentes 200");
		System.out.println("-----------------------------");
		FuncionesCRUD.consultarPonentes200(db);

		/*
		 * * LLamamos al metodo actualizarEmailPonente
		 * 
		 */
		System.out.println();
		System.out.println("Metodo actualizar email del ponente");
		System.out.println("-----------------------------------");
		System.out.print("Introduzca el DNI del ponente a buscar:");
		dni = sc.nextLine();
		System.out.print("Introduzca el nuevo email del ponente:");
		email = sc.nextLine();

		FuncionesCRUD.actualizarEmailPonente(db, dni, email);

		/*
		 * * Llamamos al metodo borrarPonente
		 * 
		 */
		System.out.println();
		System.out.println("Metodo borrar ponente");
		System.out.println("-------------------------");
		System.out.print("Introduzca el DNI del ponente a buscar:");
		dni = sc.nextLine();
		FuncionesCRUD.borrarPonentePorNif(db, dni);

		/*
		 * * Llamamos al metodo consultarPonentes
		 * 
		 */
		System.out.println();
		System.out.println("Metodo consultar Ponentes");
		System.out.println("-------------------------");

		FuncionesCRUD.consultarPonentes(db);
		
		//Cerramos las conexiones
		db.close();
		sc.close();
	}

}
