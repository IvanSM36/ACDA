import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaConex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	      try{   
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            Connection con  = DriverManager.getConnection
	            		("jdbc:oracle:thin:@localhost:1521","HR","HR");
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM employees");
	            System.out.println("Conexión establecida.");
	            while(rs.next()){
	                System.out.println(rs.getString(1)+" "+rs.getString(2));
	            }
	            st.close();
	            con.close();
		    	con = null;
	        }catch(SQLException slex){
	            System.out.print(slex);
	        }catch(ClassNotFoundException clex){
	            System.out.print(clex);
	        }
	     
		
		
	}

}
