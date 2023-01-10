/**
 * 
 */
package Practica;

import java.io.FileReader;

/**
 * @author IvanSM
 *
 */
public class LeerArchivoFileReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileReader ficheroLeer = new FileReader("animales.txt");		
			int c = ficheroLeer.read();
			while(c != -1) {
				c = ficheroLeer.read();
				System.out.println(c);
			}	
			 			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
