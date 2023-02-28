package SegundoTrimestre.Tema05.T05_Xquery_IvanSM;

import java.io.File;

import com.qizx.api.Configuration;
import com.qizx.api.Expression;
import com.qizx.api.Item;
import com.qizx.api.ItemSequence;
import com.qizx.api.Library;
import com.qizx.api.LibraryManager;

public class Main {

	public static void main(String[] args) {
		
		
		String directorioGrupoRoot = "C:\\Ivan\\2ºDAM\\ACDA\\qizx-fe-4.4p2\\Datos"; // ubicacion de carpetas datos";
		// Nombre de Bilioteca o BD (Library)
		String bdNombre = "Cursos";
		// crea el objeto file directorioGrupo apuntando a esa ruta
		File directorioGrupo = new File(directorioGrupoRoot);
		try {
			// apertura de grupo de bibliotecas
			LibraryManager bdManager = Configuration.openLibraryGroup(directorioGrupo);
			// Conexion a la BD.
			Library bd = bdManager.openLibrary(bdNombre);

			System.out.println("Conexion establecida con exito...\n");
			
			String scriptConsulta ="for $profesor in collection(\"cursillos_datos/Profesores\")//profesor where $profesor/nombre = \"Roberto García\" return $profesor";
			//String scriptConsulta ="for $profesor in collection(\"/cursillos_datos/Profesores\")//profesor where $profesor/@id=2 return $profesor";
			//String scriptConsulta ="for $profesor in collection(\"cursillos_datos/Profesores\")//profesor where $profesor/@id=3 and $profesor/dni = 33856315 return $profesor/email";
			//String scriptConsulta ="for $aula in collection(\"/cursillos_datos/Aulas\")//aula where $aula/edificio=\"Edificio Principal\" return <info> <aula>{$aula/nombre/text()}</aula> <puestos>{$aula/puestos/text()}</puestos> </info>";
			
			//String scriptConsulta ="for $empresa in collection(\"/cursillos_datos\")//empresa return insert node <movil>654329867</movil> after doc(\"/cursillos_datos/Empresa.xml\")//empresa/telefono";
			//String scriptConsulta ="for $aula in collection(\"cursillos_datos/Aulas\")//aula return (replace node $aula/puestos with <capacidad> { $aula/puestos/text() }</capacidad>)";
			
			
			Expression exprCompilada = bd.compileExpression(scriptConsulta);
			ItemSequence resultado = exprCompilada.evaluate();
			
			while (resultado.moveToNextItem()) {
				Item resul = resultado.getCurrentItem();
				System.out.println(resul.getString());
			}
			
			// cierra la conexion a la base de datos bd
			bd.close();
			// cierra las bases de datos del grupo despues de 10000 ms
			bdManager.closeAllLibraries(10000 /* ms */);
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
	}

}
