package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
	
	protected static String classDriver ="oracle.jdbc.driver.OracleDriver";
	protected static String driver = "jdbc:oracle:thin:";
	protected static String bbdd = "@localhost:1521";
	protected static String user = "JAVAP";
	protected static String pass = "JAVAP";	
	protected static Connection con;
	
	
	public static Connection conectar() {
		
		try {
			if (con == null || con.isClosed()){
				try{   
			        Class.forName(classDriver);
			        Connection con  = DriverManager.getConnection(driver + bbdd, user, pass);
			    return con;
			    }catch(SQLException slex){
			        System.out.print(slex);
			    }catch(ClassNotFoundException clex){
			        System.out.print(clex);
			    }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}

	public static void desconectar() {
		try {
			if (!con.isClosed()){
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}