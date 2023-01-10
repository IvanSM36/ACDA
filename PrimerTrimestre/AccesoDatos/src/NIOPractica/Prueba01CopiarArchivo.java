/**
 * 
 */
package NIOPractica;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author IvanSM
 *
 */
public class Prueba01CopiarArchivo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Path origen = Paths.get("C:/Ivan/2ºDAM/ACDA/Prueba.txt");
		Path destino = Paths.get("D:/Ivan/2ºDAM/ACDA/Prueba.txt");
		
		if(Files.exists(origen)) {
			System.out.println("El archivo de la ruta origen no existe");
		}
		if (Files.exists(destino)) {
			System.out.println("El archivo de la ruta desino no existe");

		}
		
	}

}
