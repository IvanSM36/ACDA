package SegundoTrimestre.Tema04.T06_Matisse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.matisse.MtDatabase;

public class Funciones {

	// Crea un objeto MtDatabase asociando la cadena de conexion (Host,BD)
	static MtDatabase dbcon = new MtDatabase("localhost", "Escuela");

	

	public static void mostrarGrupos() {
		// Abrir una conexion a la base de objetos
		dbcon.open();	
		
		// Crea la sentencia
		try {
			
			Connection jdbcon = dbcon.getJDBCConnection();

			// Crea la sentencia
			Statement stmt = jdbcon.createStatement();
			
			// Define la consulta SELECT
			String query = "SELECT * FROM Grupo;";

			//Ejecuta la consulta y obtiene un ResulSet
			ResultSet rset = stmt.executeQuery(query);
			
			// No funciona
			// Imprime total de objetos recuperados
			// System.out.println("Total selected: " + ((MtResultSet) rset).getTotalNumObjects());
			// System.out.println("");
			
			// Imprime los nombre de columna
			ResultSetMetaData rsMetaData = rset.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();
			// Obtiene los nombres de columna; indexa las columnas comenzando desde 1
			for (int i = 0; i < numberOfColumns; i++) {
				System.out.print(String.format("%10s", rsMetaData.getColumnName(i + 1)) + " ");
			}
			System.out.println("");
			for (int i = 0; i < numberOfColumns; ++i) {
				System.out.printf("%10s","---------- ");
			}
			
			System.out.println("");
			
			String oID, cveG, nomG ;
			while (rset.next()) { // visualizamos los datos de Grupo
				// Obtiene los valores de la primera y segunda columna
				oID = rset.getString(1);
				cveG = rset.getString(2);
				nomG = rset.getString(3);
				
				// Imprime la fila en curso
				System.out.println(String.format("%10s", oID) + " " + String.format("%10s", cveG) + " " + String.format("%10s", nomG));
			}
			// rset y cierra la conexion a la base de objetos
			rset.close();
			stmt.close();
		} catch (SQLException e) { // control de excepciones
			System.out.println("SQLException: " + e.getMessage());
		} finally {
			if (dbcon.isVersionAccessInProgress()) {
				dbcon.endVersionAccess();
			} else if (dbcon.isTransactionInProgress()) {
				dbcon.rollback();
			}
			dbcon.close(); // cierre conexión
		}

	}
	
	public static void mostrarAlumnos() {
		// Abrir una conexión a la base de objetos
		dbcon.open();	
		
		// Crea la sentencia
		try {
			
			Connection jdbcon = dbcon.getJDBCConnection();

			// Crea la sentencia
			Statement stmt = jdbcon.createStatement();
			
			// Define la consulta SELECT
			String query = "SELECT * FROM Alumno;";

			// Ejecuta la consulta y obtiene un EesulSet
			ResultSet rset = stmt.executeQuery(query);
			
			// No funciona
			// Imprime total de objetos recuperados
			// System.out.println("Total selected: " + ((MtResultSet) rset).getTotalNumObjects());
			// System.out.println("");
			
			// Imprime los nombre de columna
			ResultSetMetaData rsMetaData = rset.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();
			// Obtiene los nombres de columna; indexa las columnas comenzando desde 1
			for (int i = 0; i < numberOfColumns; i++) {
				System.out.print(String.format("%10s", rsMetaData.getColumnName(i + 1)) + " ");
			}
			System.out.println("");
			for (int i = 0; i < numberOfColumns; ++i) {
				System.out.printf("%10s","------- ");
			}
			
			System.out.println("");
			
			String oID, cveA, nomA, cveG ;
			int edaA;
			
			while (rset.next()) { // visualizamos los datos de Grupo
				// Obtiene los valores de la primera y segunda columna
				oID = rset.getString(1);
				cveG = rset.getString(2);
				nomA = rset.getString(3);
				edaA = rset.getInt(4);
				cveG = rset.getString(5);

				// Imprime la fila en curso
				System.out.println(String.format("%10s", oID) + " " + String.format("%10s", cveG) + " " + String.format("%10s", nomA)+ " " + String.format("%10s", edaA) + " " + String.format("%10s", cveG));
			}
			// rset y cierra la conexión a la base de objetos
			rset.close();
			stmt.close();
		} catch (SQLException e) { // control de excepciones
			System.out.println("SQLException: " + e.getMessage());
		} finally {
			if (dbcon.isVersionAccessInProgress()) {
				dbcon.endVersionAccess();
			} else if (dbcon.isTransactionInProgress()) {
				dbcon.rollback();
			}
			dbcon.close(); // cierre conexión
		}

	}
	
	public static void insertarDatosGrupos(String cveGru, String nomGru ) {
		// Abrir una conexión a la base de objetos
		dbcon.open();	
		
		// Crea la sentencia
		try {
			
			Connection jdbcon = dbcon.getJDBCConnection();

			// Crea la sentencia
			Statement stmt = jdbcon.createStatement();
			
			// Define la consulta SELECT
			String query = "INSERT INTO Grupo(cveGru, nomGru) VALUES('"+ cveGru + "', '" + nomGru +"');";
						
			// Ejecuta la consulta y obtiene un EesulSet
			ResultSet rset = stmt.executeQuery(query);
					
			
			//Realizamos commit para realizar los cambios
			dbcon.commit();
			// rset y cierra la conexión a la base de objetos
			rset.close();
			stmt.close();
		} catch (SQLException e) { // control de excepciones
			System.out.println("SQLException: " + e.getMessage());
		} finally {
			if (dbcon.isVersionAccessInProgress()) {
				dbcon.endVersionAccess();
			} else if (dbcon.isTransactionInProgress()) {
				dbcon.rollback();
			}
			dbcon.close(); // cierre conexión
		}

	}
	
	public static void insertarDatosAlumno(String cveAlu, String nomAlu, int edaAlu, String cveGru ) {
		// Abrir una conexión a la base de objetos
		dbcon.open();	
		
		// Crea la sentencia
		try {
			
			Connection jdbcon = dbcon.getJDBCConnection();

			// Crea la sentencia
			Statement stmt = jdbcon.createStatement();
			
			// Define la consulta SELECT
			String query = "INSERT INTO Alumno(cveAlu, nomAlu, edaAlu, cveGru) VALUES('"+ cveAlu + "', '"+ nomAlu + "'," + edaAlu + ", '" + cveGru + "');";
						
			// Ejecuta la consulta y obtiene un EesulSet
			ResultSet rset = stmt.executeQuery(query);
							
			//Realizamos commit para realizar los cambios
			dbcon.commit();
			// rset y cierra la conexión a la base de objetos
			rset.close();
			stmt.close();
		} catch (SQLException e) { // control de excepciones
			System.out.println("SQLException: " + e.getMessage());
		} finally {
			if (dbcon.isVersionAccessInProgress()) {
				dbcon.endVersionAccess();
			} else if (dbcon.isTransactionInProgress()) {
				dbcon.rollback();
			}
			dbcon.close(); // cierre conexión
		}

	}

}
