import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DMLModPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				String classDriver ="oracle.jdbc.driver.OracleDriver";
				String driver = "jdbc:oracle:thin:";
				String bbdd = "@localhost:1521";
				String usuario = "JAVAP";
				String pass = "JAVAP";	
				try{   
		            Class.forName(classDriver);
		            Connection con  = DriverManager.getConnection
		            		(driver+bbdd,usuario,pass);
		           if (!con.isClosed()){
		            	System.out.println("Conexión establecida.");
		            	
		            	String nombre = "'Juan'";
		            	String nombre1 = "Juan";
		            	PreparedStatement ps = con.prepareStatement("Delete from prueba");
		            	System.out.println(ps.executeUpdate());
		            	
		            	Statement st = con.createStatement();
		            	String sqladd = "INSERT INTO PRUEBA (NOMBRE, EDAD) VALUES ('Pepe', '28')";
		            	System.out.println(st.executeUpdate(sqladd));
		            	sqladd = "INSERT INTO PRUEBA (NOMBRE, EDAD) VALUES ('Juan', '30')";
		            	System.out.println(st.executeUpdate(sqladd));		 		
		            	sqladd = "INSERT INTO PRUEBA (NOMBRE, EDAD) VALUES ('Antonio', '33')";
		            	System.out.println(st.executeUpdate(sqladd));	 
		        		String sqlmod = "UPDATE PRUEBA SET EDAD = '35' WHERE Nombre = "+nombre;
		        		System.out.println(st.executeUpdate(sqlmod));
		        		String sqlbor = "DELETE FROM PRUEBA WHERE NOMBRE = 'Juan' ";
		        		System.out.println(st.executeUpdate(sqlbor));
		            	
		            	ps = con.prepareStatement("UPDATE PRUEBA SET EDAD = '37' WHERE Nombre = ?");
		            	ps.setString(1,nombre1);
		            	System.out.println(ps.executeUpdate());
		      
		            	st.close();
		            	
		            	con.close();
		            	con = null;}
		        }catch(SQLException slex){
		            System.out.print(slex);
		        }catch(ClassNotFoundException clex){
		            System.out.print(clex);
		        }

	}

}
