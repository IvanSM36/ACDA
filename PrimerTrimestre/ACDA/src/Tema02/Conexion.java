package Tema02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	protected static String driver = "oracle.jdbc.driver.OracleDriver";
	protected static String user = "JAVAP";
	protected static String pass = "JAVAP";
	protected static String url = "jdbc:oracle:thin:@localhost:1521";
	Connection conexion = null;

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", user, pass);
			if (!con.isClosed()) {
				System.out.println("Conexión establecida.");

				Statement st = con.createStatement();
				String sqla = "CREATE TABLE DEPARTAMENTO (NombreDepartamento VARCHAR2(20))";
				String sqla2 = "CREATE TABLE EMPLEADOS (Nombre VARCHAR(20), PuestoTrabajo VARCHAR2(20), SALDO INT)";
				String sqla3 = "CREATE TABLE OFICINA (NombreOficina VARCHAR2(20), EDAD INT)";
				String sqlb = "DROP TABLE PRUEBA";
				String sqlm = "ALTER TABLE PRUEBA ADD CONSTRAINT PRUEBA PK PRIMARY KEY(NOMBRE)";
			
				st.executeUpdate(sqla);
				//st.executeUpdate(sqlb);
			//	st.executeUpdate(sqlm);

				st.close();
				con.close();
				con = null;
			}

		} catch (SQLException SQLEx) {
			System.out.print(SQLEx);
		} catch (ClassNotFoundException CNFex) {
			System.out.print(CNFex);
		}
	}
}
