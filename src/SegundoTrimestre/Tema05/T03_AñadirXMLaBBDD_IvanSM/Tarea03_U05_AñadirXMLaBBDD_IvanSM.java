package SegundoTrimestre.Tema05.T03_AñadirXMLaBBDD_IvanSM;

import java.io.File;
import java.io.IOException;

import com.qizx.api.Collection;
import com.qizx.api.Configuration;
import com.qizx.api.DataModelException;
import com.qizx.api.Library;
import com.qizx.api.LibraryManager;
import com.qizx.api.QizxException;
import com.qizx.api.LibraryMember;

public class Tarea03_U05_AñadirXMLaBBDD_IvanSM {

	// Metodos

	/*
	 * * Método que crea el directorio asociado al grupo de BDs si no existe
	 * 
	 */
	private static LibraryManager obtenerBDManager(File directorioGrupo) throws IOException, QizxException {
		// objeto para gestionar el directorio asociado al grupo de bibliotecas
		// si existe el directorio asociado al grupo, devuelve el manejador
		// LibraryManager asociado
		if (directorioGrupo.exists()) {
			return Configuration.openLibraryGroup(directorioGrupo);
			// si no existe el directorio, intenta crearlo, y devuelve el manejador
			// LibraryManager asociado
		} else {
			if (!directorioGrupo.mkdirs()) {
				throw new IOException("no se puede crear directorio '" + directorioGrupo + "'");
			}
			System.out.println("creando el Grupo de BDs en '" + directorioGrupo + "'...");
			return Configuration.createLibraryGroup(directorioGrupo);
		}
	}

	/*
	 * * Método que obtiene la conexión a una bd XML, y si no existe la crea
	 * 
	 */
	private static Library obtenerBD(LibraryManager bdManager, String bdNombre) throws QizxException {

		// Abre una conexión a la BD XML de nombre bdNombre
		Library bd = bdManager.openLibrary(bdNombre);
		// Si no se ha abierto la BD (porque no existe)
		if (bd == null) {
			System.out.println("Creando BD XML '" + bdNombre + "'...");
			// Crea la BD XML
			bdManager.createLibrary(bdNombre, null);
			// Abre una conexión a la BD creada
			bd = bdManager.openLibrary(bdNombre);
		}
		// devuelve la conexión
		return bd;
	}

	/* *
	 *  Metodo que crea colecciones
	 * 
	 */
	private static void crearColeccion(Library bd, String ruta) {
		// Creamos colecciones
		Collection coleccion;
		try {
			coleccion = bd.getCollection(ruta);
			// Si no existe la coleccion, crea la coleccion.
			if (coleccion == null) {
				System.out.println("Creando coleccion '" + ruta + "'...");
				coleccion = bd.createCollection(ruta);
				bd.commit();
			}
		} catch (DataModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/* *
	 * Metodo que añade un documento
	 * 
	 */
	private static void aniadirDocumento(Library bd,  String rutaDocu, File fichero) {
		
		System.out.println("Importando '" + fichero + "' como documento '" + rutaDocu + "'...");
		// importa a bd, en la posicion indicada por ruta, el documento XML
		// cuyo texto XML esta en fichero			
			try {
				bd.importDocument(rutaDocu, fichero);
				bd.commit();
			} catch (DataModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/* *
	 * Metodo que borra un documento
	 */
	private static void borrarDocumento(Library bd, String borrarDocu) {
		try {
			bd.deleteMember(borrarDocu);
			
			System.out.println("Documento eliminado correctamente.");
			
			bd.commit();
		} catch (DataModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	/* *
	 * Metodo que recorre un array de string con las rutas de las colecciones y las borra todas
	 */
	private static void borrarColeccion(Library bd) {
		String[] coleccionNombre = new String[5];
		String ruta;

		coleccionNombre[0] = "/Instituto_datos/Clases" ; 
		coleccionNombre[1] = "/Instituto_datos/Alumnos" ; 
		coleccionNombre[2] = "/Instituto_datos/Profesores" ; 
		coleccionNombre[3] = "/Instituto_datos/Aulas"; 
		coleccionNombre[4] = "/Instituto_datos"; 		
		
		try {
			// Borra las colecciones especificadas
			for(int i =0; i < coleccionNombre.length; i++ ) {
				ruta = coleccionNombre[i];
				if(bd.deleteMember(ruta)) {
					System.out.println("Borrando colección '" + ruta + "'...");
				}else {
					System.out.println("Colección no encontrada '" + ruta + "' no encontrada");
				}
			}
						
			bd.commit();
		} catch (DataModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	/*
	 * * Método que cierra la conexión a la base de datos
	 * 
	 */
	private static void cerrar(Library bd, LibraryManager bdManager) throws QizxException {
		// Si la base de datos está inmersa en una transacción
		if (bd.isModified()) {
			// deshace los cambios realizados por la transacción
			bd.rollback();
		}
		// cierra la conexión a la base de datos bd
		bd.close();
		// cierra las bases de datos del grupo después de 10000 ms
		bdManager.closeAllLibraries(10000 /* ms */);
	}

	public static void main(String[] args) {
		// ruta del Grupo de bases de datos (Library Group)
		String directorioGrupoRoot = "C:\\Ivan\\2ºDAM\\ACDA\\qizx-fe-4.4p2\\Datos";

		// Nombre de Bilioteca o BD (Library): Instituto
		String bdNombre = "Instituto";

		// Rutas de colecciones
		String rutaClases = "Instituto_datos\\Clases\\";
		String rutaAlumnos = "Instituto_datos\\Alumnos\\";
		String rutaProfesores = "Instituto_datos\\Profesores\\";
		String rutaAulas = "Instituto_datos\\Aulas\\";

		// crea el objeto file directorioGrupo apuntando a esa ruta
		File directorioGrupo = new File(directorioGrupoRoot);

		// obtiene un grupo de bibliotecas
		LibraryManager bdManager;

		try {
			bdManager = obtenerBDManager(directorioGrupo);

			// Conexion a la BD.
			Library bd = obtenerBD(bdManager, bdNombre);
			System.out.println("Conexion establecida con exito.");

			// Creamos las colecciones llamando al metodo			
			crearColeccion(bd, rutaClases);
			crearColeccion(bd, rutaAlumnos);
			crearColeccion(bd, rutaProfesores);
			crearColeccion(bd, rutaAulas);
			
			// Rutas de documentos
			String rutaDocuInstituto = "Instituto_datos\\Instituto_d.xml";
			String rutaDocuClases = "Instituto_datos\\Clases\\Clases.xml";
			String rutaDocuAlumnos = "Instituto_datos\\Alumnos\\Alumnos.xml";
			String rutaDocuProfesores = "Instituto_datos\\Profesores\\AntonioBernal.xml";
			String rutaDocuAulas = "Instituto_datos\\Aulas\\aula1.xml";
			
			//Rutas de ficheros
			File rutaFicheroInstituto = new File("C:\\Ivan\\2ºDAM\\ACDA\\Practica03T05\\Instituto_d.xml");
			File rutaFicheroClases = new File("C:\\Ivan\\2ºDAM\\ACDA\\Practica03T05\\Clases.xml");
			File rutaFicheroAlumnos = new File("C:\\Ivan\\2ºDAM\\ACDA\\Practica03T05\\Alumnos.xml");
			File rutaFicheroProfesores = new File("C:\\Ivan\\2ºDAM\\ACDA\\Practica03T05\\AntonioBernal.xml");
			File rutaFicheroAulas = new File("C:\\Ivan\\2ºDAM\\ACDA\\Practica03T05\\aula1.xml");
			
			// Llamamos al metodo aniadirDocumentos para añadirlos		
			aniadirDocumento(bd, rutaDocuInstituto, rutaFicheroInstituto);
			aniadirDocumento(bd, rutaDocuClases, rutaFicheroClases);
			aniadirDocumento(bd, rutaDocuAlumnos, rutaFicheroAlumnos);
			aniadirDocumento(bd, rutaDocuProfesores, rutaFicheroProfesores);
			aniadirDocumento(bd, rutaDocuAulas, rutaFicheroAulas);
			
			String borrarDocu = "/Instituto_datos/Aulas/aula1.xml";
			
			/////////////// Descomentar para probar  /////////////// 
			// Llamamos al metodo borrarDocumento para borrar un documento especifico		
			// borrarDocumento(bd, borrarDocu); 	
			
			/////////////// Descomentar para probar  /////////////// 
			//Llamamos al metodo borrarColeccion para borrar todas las colecciones
			//borrarColeccion(bd);
			
			// cierra o realiza la desconexión de la BD bd
			cerrar(bd, bdManager);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QizxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
