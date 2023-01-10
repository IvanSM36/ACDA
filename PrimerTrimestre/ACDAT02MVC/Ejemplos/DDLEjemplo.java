import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DDLEjemplo {
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
            	
            	
            	Statement st = con.createStatement();
            	String sqla = "CREATE TABLE PRUEBA ( NOMBRE VARCHAR2(20) , EDAD INT )";
        		String sqlb = "DROP TABLE PRUEBA";
        		String sqlm = "ALTER TABLE PRUEBA ADD CONSTRAINT PRUEBA_PK PRIMARY KEY (NOMBRE)";
            	
            	st.executeUpdate(sqla);
            	st.executeUpdate(sqlm);
            	//st.executeUpdate(sqlb);
      
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
