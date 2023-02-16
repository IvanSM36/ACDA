package SegundoTrimestre.Tema05.T01_ConexionBBDDXML_IvanSM;

import java.io.File;
import java.io.IOException;

import com.qizx.api.Configuration;
import com.qizx.api.Library;
import com.qizx.api.LibraryManager;
import com.qizx.api.QizxException;

public class Main2 {

	// Metodos
	// método que crea el directorio asociado al grupo de BDs si no existe
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

	// Método que obtiene la conexión a una bd XML, y si no existe la crea
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

	// método que cierra la conexión a la base de datos
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
		// Nombre de Bilioteca o BD (Library): Alumnos
		String bdNombre = "2DAM";
		// crea el objeto file directorioGrupo apuntando a esa ruta
		File directorioGrupo = new File(directorioGrupoRoot);
		// obtiene un grupo de bibliotecas
		LibraryManager bdManager;
		try {
			bdManager = obtenerBDManager(directorioGrupo);
			// Conexion a la BD.
			Library bd = obtenerBD(bdManager, bdNombre);
			System.out.println("Conexion establecida con exito.............");
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
