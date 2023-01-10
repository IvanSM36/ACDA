package EjemplosLecturaEscritura;

import java.io.File;
import java.io.IOException;

public class fileclase2709 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fichero1 = new File ("prueba.txt");
		File directorio = new File ("c:/jaime/");
		File directorio2 = new File ("c:/dam1/segundo/acdat/");
		File fichero2 = new File(directorio,"prueba.txt");
		File fichero3 = new File ("c:/jaime/","prueba.txt");
		
		if (directorio.exists()) {
			System.out.println("El directorio existe");
			//directorio.delete();
		}else
		{
			System.out.println("El directorio no existe");
			if (directorio.mkdir()) {
				System.out.println("El directorio "
						+ directorio.getName() +
						" se ha creado correctamente");
			}else
				System.out.println("Problema al crear el directorio");
		}
		
		if (!fichero1.exists()) {
			
			try {
				fichero1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		System.out.println("La ruta absoluta de fichero 2 es "
							+ fichero2.getAbsolutePath());
		System.out.println("La ruta absoluta de fichero 3 es "
				+ fichero3.getAbsolutePath());
		
		
		if (fichero2.exists()) {
			System.out.println("El fichero existe");
			//directorio.delete();
		}else {
			try {
				fichero2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	directorio2.mkdirs();
		
		
	}

}
