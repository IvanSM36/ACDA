/**
 * 
 */
package Practica;

import java.io.File;
import java.io.IOException;

/**
 * @author IvanSM
 *
 */
public class FicherosDir {

	/**
	 * @param args
	 */

	public static void listarDirectorio(File directorio, String separador) {
		File[] ficheros = directorio.listFiles();

		if (ficheros != null) {
			for (int i = 0; i < ficheros.length; i++) {
				System.out.println(separador + ficheros[i].getName());
				if (ficheros[i].isDirectory()) {
					String nuevo_separador;
					nuevo_separador = separador + " ";
					listarDirectorio(ficheros[i], nuevo_separador);
				}
			}
		}

	}

	public static void main(String[] args) {

		File fichero1 = new File("archivo01.txt");
		File dir01 = new File("c:/Ivan/2ºDAM");
		File dir02 = new File("c:/Ivan/2ºDAM/HLC");
		File dir03 = new File("c:/Ivan/2ºDAM/PROGs");
		File dir04 = new File("c:/Ivan/2ºDAM/PROGm");
		File dir05 = new File("c:/Ivan/2ºDAM/DEIN");

		if (dir01.exists()) {
			System.out.println("El directorio " + dir01.getName() + " existe \n");
		} else {
			System.out.println("El directorio " + dir01.getName() + " no existe, se creará");
			if (dir01.mkdir()) {
				System.out.println("El directorio " + dir01.getName() + " se ha creado correctamente \n");
			} else
				System.out.println("Problema al crear el directorio");
		}

		if (dir02.exists()) {
			System.out.println("El directorio " + dir02.getName() + " existe \n");
		} else {
			System.out.println("El directorio " + dir02.getName() + " no existe, se creará");
			if (dir02.mkdir()) {
				System.out.println("El directorio " + dir02.getName() + " se ha creado correctamente \n");
			} else
				System.out.println("Problema al crear el directorio");
		}

		if (dir03.exists()) {
			System.out.println("El directorio " + dir03.getName() + " existe \n");
		} else {
			System.out.println("El directorio " + dir03.getName() + " no existe, se creará");
			if (dir03.mkdir()) {
				System.out.println("El directorio  " + dir03.getName() + " se ha creado correctamente \n");
			} else
				System.out.println("Problema al crear el directorio");
		}

		if (dir04.exists()) {
			System.out.println("El directorio " + dir04.getName() + " existe \n");
		} else {
			System.out.println("El directorio " + dir04.getName() + " no existe, se creará");
			if (dir04.mkdir()) {
				System.out.println("El directorio " + dir04.getName() + " se ha creado correctamente \n");
			} else
				System.out.println("Problema al crear el directorio");
		}

		if (dir05.exists()) {
			System.out.println("El directorio " + dir05.getName() + " existe \n");
		} else {
			System.out.println("El directorio " + dir05.getName() + " no existe, se creará");
			if (dir05.mkdir()) {
				System.out.println("El directorio " + dir05.getName() + " se ha creado correctamente \n");
			} else
				System.out.println("Problema al crear el directorio");
		}
		System.out.println();

		File[] directorios = dir01.listFiles();

		System.out.println("Lista de directorios");
		System.out.println("--------------------");

		listarDirectorio(dir01, " ");

		
	}

}
