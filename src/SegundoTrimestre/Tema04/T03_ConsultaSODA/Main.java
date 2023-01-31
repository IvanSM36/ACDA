package SegundoTrimestre.Tema04.T03_ConsultaSODA;

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

		// LLamamos para introducir datos
		// FuncionesCRUD.almacenarPonentes(db);

		// Hacemos consulta con SODA
		System.out.println();
		System.out.println("Metodo consultar Ponentes SODA");
		System.out.println("------------------------------");
		FuncionesCRUD.consultasSODAponentes(db);

		// Hacemos consulta ponentes con cache 200 con SODA
		System.out.println();
		System.out.println("Metodo consultar Ponentes cache 200 SODA");
		System.out.println("----------------------------------------");
		FuncionesCRUD.consultarPonentes200(db);

		// Hacemos consulta ponentes con cache entre 50 y 200 con SODA
		System.out.println();
		System.out.println("Metodo consultar Ponentes entre 50 y 200 SODA");
		System.out.println("----------------------------------------");
		FuncionesCRUD.consultaSODAcacheEntre50_200(db);

		// Hacemos consulta ponentes con cache entre 50 y 200 con SODA
		System.out.println();
		System.out.println("Metodo consultar Ponentes de mayor a menor");
		System.out.println("----------------------------------------");
		FuncionesCRUD.consultaSODAponentesOrdenadosCache(db);

		// Cerramos las conexiones
		db.close();
	}

}
