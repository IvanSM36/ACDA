package Menu;

import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import SegundoTrimestre.Tema04.T02_ConsultaBDO.Ponente;

public class Main {

	private static int opcion = 0;

	public static void menuPrincipal() {
		Scanner scan = new Scanner(System.in);

		do {
			System.out.println("\n##############################");
			System.out.println("#       Menu Pincipal        #");
			System.out.println("##############################");
			System.out.println("# 1.- Consultas con QBE.     #");
			System.out.println("# 2.- Consultas con SODA.    #");
			System.out.println("# 3.- Consultas con Matisse. #");
			System.out.println("# 0.- Salir.                 #");
			System.out.println("##############################");

			System.out.print("Introduzca una opcion: ");
			opcion = scan.nextInt();

			switch (opcion) {
			case 1:
				menuConsultasQBE();
				break;
			case 2:
				menuConsultasSODA();
				break;
			case 3:
				menuConsultasMatisse();
				break;
			default:
				System.out.println("\nHas salido del programa.");
			}

		} while (opcion != 0);

	}

	public static void menuConsultasQBE() {
		ObjectContainer db = Db4oEmbedded.openFile("ponentes.db4o");
		Scanner scan = new Scanner(System.in);
		String id;
		String email;

		do {
			System.out.println("\n##############################");
			System.out.println("#     Menu Consultas QBE     #");
			System.out.println("##############################");
			System.out.println("# 1.- Mostrar datos.         #");
			System.out.println("# 2.- Insertar datos.        #");
			System.out.println("# 3.- Modificar datos.       #");
			System.out.println("# 4.- Borrar datos.          #");
			System.out.println("# 0.- Salir.                 #");
			System.out.println("##############################");

			System.out.print("Introduzca una opcion: ");
			opcion = scan.nextInt();

			switch (opcion) {
			case 1:
				mostrarDatos(db);
				break;
			case 2:
				insertarDatos(db);
				break;
			case 3:
				System.out.print("Introduzca el id  del articulo para modificar: ");
				id = scan.next();
				System.out.print("Introduzca el email para modificar: ");
				email = scan.next();
				actualizarEmailPonente(db, id, email);
				break;
			case 4:
				System.out.print("Introduzca el id para borrar: ");
				id = scan.next();
				borrarDatos(db, id);
				break;
			default:
				db.close();
				menuPrincipal();
			}

		} while (opcion != 0);

	}

	public static void menuConsultasSODA() {
		ObjectContainer db = Db4oEmbedded.openFile("ponentes.db4o");
		Scanner scan = new Scanner(System.in);
		String id;
		String email;

		do {
			System.out.println("\n##############################");
			System.out.println("#     Menu Consultas SODA    #");
			System.out.println("##############################");
			System.out.println("# 1.- Mostrar datos.         #");
			System.out.println("# 2.- Insertar datos.        #");
			System.out.println("# 3.- Modificar datos.       #");
			System.out.println("# 4.- Borrar datos.          #");
			System.out.println("# 0.- Salir.                 #");
			System.out.println("##############################");

			System.out.print("Introduzca una opcion: ");
			opcion = scan.nextInt();

			switch (opcion) {
			case 1:
				mostrarDatos(db);
				break;
			case 2:
				insertarDatos(db);
				break;
			case 3:
				System.out.print("Introduzca el id  del articulo para modificar: ");
				id = scan.next();
				System.out.print("Introduzca el email para modificar: ");
				email = scan.next();
				actualizarEmailPonente(db, id, email);
				break;
			case 4:
				System.out.print("Introduzca el id para borrar: ");
				id = scan.next();
				borrarDatos(db, id);
				break;
			default:
				db.close();
				menuPrincipal();
			}

		} while (opcion != 0);
	}

	public static void menuConsultasMatisse() {
		ObjectContainer db = Db4oEmbedded.openFile("ponentes.db4o");
		Scanner scan = new Scanner(System.in);
		String id;
		String email;

		do {
			System.out.println("\n##############################");
			System.out.println("#   Menu Consultas Matisse   #");
			System.out.println("##############################");
			System.out.println("# 1.- Mostrar datos.         #");
			System.out.println("# 2.- Insertar datos.        #");
			System.out.println("# 3.- Modificar datos.       #");
			System.out.println("# 4.- Borrar datos.          #");
			System.out.println("# 0.- Salir.                 #");
			System.out.println("##############################");

			System.out.print("Introduzca una opcion: ");
			opcion = scan.nextInt();

			switch (opcion) {
			case 1:
				mostrarDatos(db);
				break;
			case 2:
				insertarDatos(db);
				break;
			case 3:
				System.out.print("Introduzca el id  del articulo para modificar: ");
				id = scan.next();
				System.out.print("Introduzca el email para modificar: ");
				email = scan.next();
				actualizarEmailPonente(db, id, email);
				break;
			case 4:
				System.out.print("Introduzca el id para borrar: ");
				id = scan.next();
				borrarDatos(db, id);
				break;
			default:
				db.close();
				menuPrincipal();
			}

		} while (opcion != 0);
	}

	/*
	 * Consulta un objeto mediante su id
	 * 
	 * @param ObjectContainer
	 * 
	 * @return null
	 */
	public static void mostrarDatos(ObjectContainer db) {

		// Obtenemos y mostramos todos los objetos
		Ponente p = new Ponente();
		ObjectSet<Ponente> result = db.queryByExample(p);

		while (result.hasNext()) {
			System.out.println(result.next());
		}

	}

	/*
	 * Metodo que almacena un objeto
	 * 
	 * @param ObjectContainer return null
	 */
	public static void insertarDatos(ObjectContainer db) {
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
			// Si no existe lo guardamos.
			db.store(p);
		}

		db.commit();
	}

	/*
	 * Consulta un objeto con cache 200
	 * 
	 * @param ObjectContainer
	 * 
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
	 * Metodo que actualiza el Email de un objeto buscandolo por su id
	 * 
	 * @param ObjectContainer, String, String
	 * 
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

	/*
	 * Metodo que Borra un objeto por id.
	 * 
	 * @param ObjectContainer, String
	 * 
	 * @return null
	 */
	public static void borrarDatos(ObjectContainer db, String dni) {

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

	public static void main(String[] args) {

		menuPrincipal();

	}

}

/*
 * System.out.println("┌─────────────────────────────────────────────┐");
 * System.out.println("│ 1.- Consultas con QBE                       │");
 * System.out.println("│ 2.- Consultas con SODA                      │");
 * System.out.println("│ 3.- Consultas con Matisse                   │");
 * System.out.println("│ 0.- Salir.                                  │");
 * System.out.println("└─────────────────────────────────────────────┘");
 * 
 */