package NIO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesEjemplos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Path origen = Paths.get("C:/dam/prueba.txt");
		Path destino = Paths.get("C:/dam/pruebadestino.txt");
		
		if (Files.exists(origen)) {
			if (!Files.exists(destino)){
				try {
					Files.createFile(destino);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				List<String> lineas = Files.readAllLines(origen);
				BufferedWriter bw = Files.newBufferedWriter(destino, StandardCharsets.UTF_8);
				for (String linea : lineas) {
					bw.write(linea);
					bw.newLine();
				}
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else {
			System.out.println("No exite el fichero de origen.");
		}
		

	}

}
