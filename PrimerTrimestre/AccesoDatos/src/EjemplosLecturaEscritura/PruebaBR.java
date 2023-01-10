package EjemplosLecturaEscritura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PruebaBR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		File archivo = new File("ficheros/coches");
		String linea = null;
		
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo),"ISO-8859-1"));
			
			while (br.ready()) {
				linea = br.readLine();
				System.out.println(linea);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
