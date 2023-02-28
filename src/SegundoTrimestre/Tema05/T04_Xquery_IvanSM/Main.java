package SegundoTrimestre.Tema05.T04_Xquery_IvanSM;

import java.io.File;

import com.qizx.api.Configuration;
import com.qizx.api.Expression;
import com.qizx.api.Item;
import com.qizx.api.ItemSequence;
import com.qizx.api.Library;
import com.qizx.api.LibraryManager;

public class Main {

	public static void main(String[] args) {
		
		
		String directorioGrupoRoot = "C:\\Ivan\\2∫DAM\\ACDA\\qizx-fe-4.4p2\\Datos"; // ubicaci√≥n de carpetas datos";
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
			
			String scriptConsulta ="for $curso in collection(\"/cursillos_datos/Cursos\")//curso where $curso/plazas=20 order by $curso/nombre return $curso/nombre";
			//String scriptConsulta ="for $curso in collection(\"/cursillos_datos/Cursos\")//curso where $curso/precio/@cuota=\"mensual\" order by $curso/nombre return $curso/nombre";
			//String scriptConsulta ="for $curso in collection(\"/cursillos_datos/Cursos\")//curso where $curso/aula=2 order by $curso/nombre return $curso/nombre";
			//String scriptConsulta ="for $curso in collection(\"/cursillos_datos/Cursos\")//curso where $curso/aula=2 and $curso/precio < 50 and $curso/precio/@cuota = \"mensual\" order by $curso/nombre return $curso/nombre";
			//String scriptConsulta ="for $empresa in collection(\"/cursillos_datos\")//empresa where $empresa/@id=1 return replace value of node doc(\"/cursillos_datos/Empresa.xml\")//empresa/nombre with \"EmpresaAlfa\";
			//String scriptConsulta ="for $empresa in collection(\"/cursillos_datos\")//empresa where $empresa/@id=1 return insert node <gerente>Pedro Golondrino Verde</gerente>as last into doc(\"/cursillos_datos/Empresa.xml\")//empresa";
			//String scriptConsulta ="for $aula in collection(\"cursillos_datos/Aulas\")//aula return(replace node $aula/edificio with <lugar> { $aula/edificio/text() }</lugar>)";
			//String scriptConsulta ="for $empresa in collection(\"/cursillos_datos\")//empresa where $empresa/@id=1 return delete node $empresa/gerente";
			
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
