package Practica;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class fichero {
	
	// Este programa escribe y lee los ficheros en otra carpeta creada desde la raiz junto a src
	public static void main(String[] args) {
		// Variables
		Scanner scan = new Scanner(System.in);
		String ficheroEscribir = "Ficheros/datos";
		String ficheroLeer = "Ficheros/datos";
		String linea = "";

		// Pedimos los datos
		System.out.print("Introduzca tu nombre:");
		String nombre = scan.nextLine();
		System.out.print("Introduzca tu apellido:");
		String apellidos = scan.nextLine();
		System.out.print("Introduzca años:");
		int anios = scan.nextInt();
		System.out.println();
		
		// Declaramos la clase BufferedWrite para escribir en el fichero
		try {BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroEscribir, true));

			// Escribimos en el fichero datos
			bw.write(nombre + " " + apellidos + " " + anios + "\n");
			bw.close();
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("No se encuentra el fichero.");
		} catch (IOException ioe) {
			System.out.println("No se puede escribir en el fichero.");
		}

		// Declaramos la clase BufferedReader para leer el fichero
		System.out.println("Contenido del fichero datos");
		System.out.println("---------------------------");
		try {BufferedReader br = new BufferedReader(new FileReader(ficheroLeer));

			// Leemos el fichero datos y los mostramos por consola
			while (br.ready()) {
				linea = br.readLine(); // leo una linea del buffer
				System.out.print(linea + " ");
				System.out.println();
			}

			br.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("No se encuentra el fichero.");
		} catch (IOException ioe) {
			System.out.println("No se puede leer el fichero.");
		}
	}
}
