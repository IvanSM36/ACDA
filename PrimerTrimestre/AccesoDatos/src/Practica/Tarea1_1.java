package Practica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.BufferedInputStream;

public class Tarea1_1 {

	// Metodos
	public static void copiaFicheroBinario(File origen, File destino) {
		FileInputStream fileInput = null;
		BufferedInputStream bufferedInput = null;
		
		FileOutputStream fileOutput = null;
		BufferedOutputStream bufferedOutput = null;		
		byte[] array = new byte[200];
		int leerByte = 0;

		try {
			// Se abre el archivo original para lectura
			fileInput = new FileInputStream(origen);
			bufferedInput = new BufferedInputStream(fileInput);

			// Se abre el archivo destino para escritura
			fileOutput = new FileOutputStream(destino);
			bufferedOutput = new BufferedOutputStream(fileOutput);

			
			// Bucle para leer de un archivo y escribir en el otro.
			leerByte = bufferedInput.read(array);//Leemos
			while (leerByte > 0) {
				bufferedOutput.write(array, 0, leerByte); //Escribimos
				leerByte = bufferedInput.read(array);
			}

			// Cierre de los archivo
			bufferedInput.close();
			bufferedOutput.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/*
	 * Copia y sustituye numeros a letras 
	 * 
	 */
	public static void copiaSustituyeNum(File origen, File destino) {

		BufferedReader br = null;
		BufferedWriter bw = null;
		String linea = null;
		String lineaMod = "";

		try {
			//Declaramos la lectura y escritura
			br = new BufferedReader(new FileReader(origen));
			bw = new BufferedWriter(new FileWriter(destino));

			//Recorremos el fichero para leer y recoger los datos.
			while (br.ready()) {
				linea = br.readLine();
				//Leemos caracter a caracter los datos que hemos recogido para comprobar y modificar si es un numero escribirlo
				for (int i = 0; i < linea.length(); i++) {
					char letra = linea.charAt(i);
					switch (letra) {
					case '1':
						lineaMod += "uno";
						break;
					case '2':
						lineaMod += "dos";
						break;
					case '3':
						lineaMod += "tres";
						break;
					case '4':
						lineaMod += "cuatro";
						break;
					case '5':
						lineaMod += "cinco";
						break;
					case '6':
						lineaMod += "seis";
						break;
					case '7':
						lineaMod += "siete";
						break;
					case '8':
						lineaMod += "ocho";
						break;
					case '9':
						lineaMod += "nueve";
						break;
					default:
						lineaMod += letra;
						break;
					}
				}
				//Escribimos y mostramos por pantalla el resultado
				bw.write(lineaMod);
				System.out.println(lineaMod);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		// Copia fichero binario -- Copiará un fichero binario
		File archivoOriginal = new File("ficheros/kitkat.jpg");
		File archivoCopia = new File("ficheros/kit.jpg");

		copiaFicheroBinario(archivoOriginal, archivoCopia);

		// Copia y sustituye número -- Mediante los stream que considere necearios, abre
		// un fichero, y si aparece un número cámbialo por su valor en letras
		File archivoLeer = new File("ficheros/ejemplo");
		File archivoEscritura = new File("ficheros/ejemploEscrito");

		copiaSustituyeNum(archivoLeer, archivoEscritura);

	}

}
