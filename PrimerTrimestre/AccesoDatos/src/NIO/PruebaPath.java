package NIO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;



public class PruebaPath {
	public static void main(String[] args) {
	
		Path p1 = Paths.get(System.getProperty("user.dir"),"prueba.txt");
		
		System.out.println(p1.getFileName());
		System.out.println(p1.getRoot());
		System.out.println(p1.getParent());
		System.out.println(p1.getNameCount());
		System.out.println(p1.isAbsolute());
		System.out.println("=========================");		
		
		Path p2 = Paths.get("pepito el de los palotes","prueba.txt");
		System.out.println(p2.getFileName());
		System.out.println(p2.getRoot());
		System.out.println(p2.getParent());
		System.out.println(p2.getNameCount());
		System.out.println(p2.isAbsolute());
		System.out.println(Files.exists(p2));
		System.out.println("=========================");
		
		Path directorio = Paths.get("c:/","dam");
		System.out.println(directorio.getFileName());
		System.out.println(directorio.getRoot());
		System.out.println(directorio.getParent());
		System.out.println(directorio.getNameCount());
		System.out.println(directorio.isAbsolute());
		System.out.println("=========================");
		Path f1 = Paths.get("c:/dam","pruebac.txt");
		if ( !Files.exists(f1) ) {
			try {
				Files.createFile(f1);
				OutputStream os1 = Files.newOutputStream(f1);
				Files.copy(p1, os1);
				os1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				List<String> contenido = Files.readAllLines(f1);
				System.out.println("El contenido del fichero "+
				f1.getFileName() + "es:");
				for (String linea : contenido) {
					System.out.println(linea);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("=========================");
		Path f2 = Paths.get("c:/dam","pruebac1.txt");
		if ( !Files.exists(f2) ) {
			try {
				Files.createFile(f2);
				BufferedWriter bw = Files.newBufferedWriter(f2, Charset.forName("UTF-8"));
				bw.write("Estoy escribiendo en un  fichero.");
				bw.newLine();
				bw.write("Vamos a escribir á ñ."); 
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				List<String> contenido = Files.readAllLines(f2);
				System.out.println("El contenido del fichero "+
				f1.getFileName() + "es:");
				for (String linea : contenido) {
					System.out.println(linea);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
