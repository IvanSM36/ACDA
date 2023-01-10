package Tema01.BufferEW;
import java.io.*;
public class PruebaFW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File archivo = new File("pruebaFW.txt");
		FileWriter fw = null;
		String cadena = "Estamos probando el flujo de salida File Writér,";
		
		try {
			fw = new FileWriter(archivo);
			for(char c : cadena.toCharArray())
				fw.write(c);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
		
		
}


