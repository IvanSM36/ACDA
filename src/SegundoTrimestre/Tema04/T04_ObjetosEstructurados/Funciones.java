package SegundoTrimestre.Tema04.T04_ObjetosEstructurados;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Funciones {

	public static void insertarCharla(ObjectContainer db) {
		Ponente p = new Ponente("49999999-W", "Ivan", "ivan@gmail.com", 200);
		Ponente p2 = new Ponente("48888888-P", "Miguel", "miguel@gmail,com", 200);
		Ponente p3 = new Ponente("47777777-Q", "Dario", "dario@gmail,com", 150);
		Ponente p4 = new Ponente("46666666-S", "Laura", "Laura@gmail,com", 100);

		Charla c = new Charla("Flutter", 3);
		c.setPonente(p);

		Charla c2 = new Charla("Angular", 2);
		c2.setPonente(p2);

		Charla c3 = new Charla("Android", 2);
		c3.setPonente(p3);

		Charla c4 = new Charla("Python", 3);
		c4.setPonente(p4);

		// Consultamos si existe ese objeto
		ObjectSet<Charla> result = db.queryByExample(c);
		ObjectSet<Charla> result2 = db.queryByExample(c2);
		ObjectSet<Charla> result3 = db.queryByExample(c3);
		ObjectSet<Charla> result4 = db.queryByExample(c4);

		// Si existe el objeto
		if (result.hasNext() & result2.hasNext() & result2.hasNext() & result3.hasNext() & result4.hasNext()) {

			// Obtengo el objeto persona
			Charla cBD = result.next();
			Charla cBD2 = result2.next();
			Charla cBD3 = result3.next();
			Charla cBD4 = result4.next();

			// Actualizo el objeto
			result.add(cBD);
			result2.add(cBD2);
			result3.add(cBD3);
			result4.add(cBD4);

			// Guardamos el objeto de nuevo, actualizandolo
			db.store(cBD);
			db.store(cBD2);
			db.store(cBD3);
			db.store(cBD4);

		} else {
			// Si no existe lo guardamos.
			db.store(c);
			db.store(c2);
			db.store(c3);
			db.store(c4);
		}

		db.commit();
	}

	public static void modificarHorasCharlas(ObjectContainer db, String titulo, float duracion) {
		// Creo el objeto con el dni a buscar
		Charla c = new Charla(titulo, 0);

		// Consultamos si existe ese objeto
		ObjectSet<Charla> result = db.queryByExample(c);

		// Si existe el objeto
		if (result.hasNext()) {

			// Obtengo el objeto persona
			Charla cBD = result.next();

			// Actualizo el objeto
			cBD.setDuracion(duracion);

			// Guardamos el objeto de nuevo, actualizandolo
			db.store(cBD);

		} else {
			// Si no existe mostramos un mensaje.
			System.out.println("No existe ninguna charla con ese titulo.");
		}

		db.commit();
	}

	public static void visualizarQBE(ObjectContainer db) {

		// Obtenemos y mostramos todos los objetos
		Charla c = new Charla();
		ObjectSet<Ponente> result = db.queryByExample(c);

		while (result.hasNext()) {
			System.out.println(result.next());
		}
	}

	public static void visualizarSODA(ObjectContainer db) {

		Query query = db.query();

		// Filtra por la clase objetos
		query.constrain(Charla.class);

		// Ejecutamos la consulta y Mostramos los resultados
		ObjectSet result = query.execute();

		while (result.hasNext()) {
			System.out.println(result.next());
		}

	}

	public static void borrarCharlaporTitulo(ObjectContainer db, String titulo) {
		
		Query query = db.query(); // declaración de un objeto query().
		query.constrain(Charla.class);// establece la clase a la que se aplicará la restricción
		query.descend("titulo").constrain(titulo);// establece la restricción de búsqueda
		
		ObjectSet resul = query.execute();// ejecuta consulta con restricción búsqueda
		
		while (resul.hasNext()) { // bucle que recupera los objetos charla y elimina de la BDOO
			Charla c = (Charla) resul.next();
			System.out.println("Eliminando: " + c);
			db.delete(c);
		}
	}

}
