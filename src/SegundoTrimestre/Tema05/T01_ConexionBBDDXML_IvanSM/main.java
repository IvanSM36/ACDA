package SegundoTrimestre.Tema05.T01_ConexionBBDDXML_IvanSM;

import java.io.File;

import com.qizx.api.Configuration;
import com.qizx.api.Library;
import com.qizx.api.LibraryManager;

public class main {

	public static void main(String[] args) {

		// main
		// ruta del Grupo de bases de datos (Library Group)
		String directorioGrupoRoot = "C:\\Ivan\\2ºDAM\\ACDA\\qizx-fe-4.4p2\\Datos"; // ubicación de carpetas datos";
		// Nombre de Bilioteca o BD (Library): Alumnos
		String bdNombre = "2DAM";
		// crea el objeto file directorioGrupo apuntando a esa ruta
		File directorioGrupo = new File(directorioGrupoRoot);
		try {
			// apertura de grupo de bibliotecas
			LibraryManager bdManager = Configuration.openLibraryGroup(directorioGrupo);
			// Conexion a la BD.
			Library bd = bdManager.openLibrary(bdNombre);

			System.out.println("Conexion establecida con exito.............");
			// cierra la conexión a la base de datos bd
			bd.close();
			// cierra las bases de datos del grupo después de 10000 ms
			bdManager.closeAllLibraries(10000 /* ms */);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
