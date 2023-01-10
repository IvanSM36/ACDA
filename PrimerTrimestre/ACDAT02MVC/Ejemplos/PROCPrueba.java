import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class PROCPrueba {

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
		
		
		
            	String sql = "call PRUEBAPROC(?,?)";
            	CallableStatement proc = con.prepareCall(sql);
            	proc.setString(1, "11111111h");
            	proc.setInt(2,40);
            	
            	proc.execute();
            	
            	sql = "{ ? = call pruebafuc(?) }";
            	proc   = con.prepareCall(sql);
            	proc.setString(2, "11111111h");
            	int edad=0;
            	proc.registerOutParameter(1, Types.NUMERIC);
            	proc.execute();
            	edad = proc.getInt(1);
            	System.out.println(edad);
            	
            	
            	con.close();
            	con = null;}
    }catch(SQLException slex){
        System.out.print(slex);
    }catch(ClassNotFoundException clex){
        System.out.print(clex);
    }

	}

}
