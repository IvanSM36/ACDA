package SegundoTrimestre.Tema04.T02_ConsultaBDO;

import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class FuncionesCRUD {

	/*
	 * Metodo que almacena un ponente
	 */
	public static void almacenarPonentes(ObjectContainer db) {
		Scanner sc = new Scanner(System.in);

		// Pedimos los datos
		System.out.print("Introduca DNI: ");
		String dni = sc.nextLine();
		System.out.print("Introduca Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Introduzca Email: ");
		String email = sc.nextLine();
		System.out.print("Introduzca cache: ");
		Float cache = sc.nextFloat();

		// Creo el objeto
		Ponente p = new Ponente(dni, nombre, email, cache);

		// Consultamos si existe ese objeto
		ObjectSet<Ponente> result = db.queryByExample(p);

		// Si existe el objeto
		if (result.hasNext()) {

			// Obtengo el objeto persona
			Ponente pBD = result.next();

			// Actualizo el objeto
			result.add(p);

			// Guardamos el objeto de nuevo, actualizandolo
			db.store(p);

		} else {
			// Guardamos el objeto de nuevo.
			db.store(p);
		}

		// Cerramos la clase
		db.close();
		sc.close();

	}

	public static void mostrarConetnido(ObjectContainer db) {

		// Obtenemos y mostramos todos los objetos
		Ponente p = new Ponente();
		ObjectSet<Ponente> result = db.queryByExample(p);

		while (result.hasNext()) {
			System.out.println(result.next());
		}

	}

}
