import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DMLSelPrueba {

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
            	
            	System.out.println("Prueba sin parámetros");
            	Statement st = con.createStatement();
            	String sql = "Select * from prueba";
            	ResultSet rs = st.executeQuery(sql);
            	while (rs.next()) {
            		System.out.println(rs.getString("Nombre"));
            		System.out.println(rs.getInt("Edad"));
            	}
            	sql = "Select * from prueba where edad = ?";
            	System.out.println("Prueba con parámetros");
            	PreparedStatement ps = con.prepareStatement(sql);
            	int edad = 33;
            	ps.setInt(1,edad);
            	rs = ps.executeQuery();
            	while (rs.next()) {
            		System.out.println(rs.getString(1));
            		System.out.println(rs.getInt(2));
            	}
            	
            	
      
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
