package SegundoTrimestre.Tema04.T02_ConsultaBDO;

import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import SegundoTrimestre.Tema04.Apuntes.ActualizarDBO.Persona;

public class Funciones {

	/*
	 * Metodo que almacena un ponente
	 * @param ObjectContainer
	 * return null
	 */
	public static void almacenarPonentes(ObjectContainer db) {
		Scanner sc = new Scanner(System.in);

		// Pedimos los datos
		System.out.print("Introduzca DNI: ");
		String dni = sc.nextLine();
		System.out.print("Introduzca Nombre: ");
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
			result.add(pBD);

			// Guardamos el objeto de nuevo, actualizandolo
			db.store(pBD);

		} else {
			//Si no existe lo guardamos.
			db.store(p);
		}
		
		db.commit();		
	}
	
	/*
	 * Metodo que Borra un ponente por DNI.
	 * @param ObjectContainer, String
	 * @return null
	 */
	public static void borrarPonentePorNif(ObjectContainer db, String dni) {
		
		// Creamos un objeto con el DNI que vamos a buscar.
        Ponente p = new Ponente(dni, null, null, 0);

		// Consultamos si existe ese objeto.
		ObjectSet<Ponente> result = db.queryByExample(p);

		// Si existe el objeto
		if (result.hasNext()) {

			// Obtengo el objeto persona
			Ponente pBD = result.next();
			
			// Borramos el objeto.
			db.delete(pBD);

		} else {
			// Si no existe mostramos un mensaje.
			System.out.println("No existe ningun ponente con el dni introducido.");			
		}		
		
		db.commit();

	}
	
	/*
	 * Consulta un ponente mediante su DNI
	 * @param ObjectContainer
	 * @return null
	 */
	public static void consultarPonentes(ObjectContainer db) {

		// Obtenemos y mostramos todos los objetos
		Ponente p = new Ponente();
		ObjectSet<Ponente> result = db.queryByExample(p);

		while (result.hasNext()) {
			System.out.println(result.next());
		}

	}
	
	/*
	 * Consulta un ponente con cache 200
	 * @param ObjectContainer
	 * @return null
	 */
	public static void consultarPonentes200(ObjectContainer db) {

		// Obtenemos y mostramos todos los objetos
		Ponente p = new Ponente(null, null, null, 200);
		ObjectSet<Ponente> result = db.queryByExample(p);		
		
		while (result.hasNext()) {
			System.out.println(result.next());
		}

	}
	
	/*
	 * Metodo que actualiza el Email de un ponente buscandolo por su DNI
	 * @param ObjectContainer, String, String
	 * @return null
	 */
	public static void actualizarEmailPonente(ObjectContainer db, String dni, String email) {

		// Creo el objeto con el dni a buscar
		Ponente p = new Ponente(dni, null, null, 0);

		// Consultamos si existe ese objeto
		ObjectSet<Ponente> result = db.queryByExample(p);

		// Si existe el objeto
		if (result.hasNext()) {

			// Obtengo el objeto persona
			Ponente pBD = result.next();
			
			// Actualizo el objeto
            pBD.setEmail(email);          

			// Guardamos el objeto de nuevo, actualizandolo
			db.store(pBD);

		} else {
			// Si no existe mostramos un mensaje.
			System.out.println("No existe ningun ponente con el dni introducido.");	
		}
		
		db.commit();
	}


}
