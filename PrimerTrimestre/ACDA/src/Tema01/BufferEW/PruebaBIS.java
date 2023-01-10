package Tema01.BufferEW;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class PruebaBIS {

	public static void main(String[] args) {
	BufferedInputStream bis = null;
	File archivo = new File("c:/dam/prueba.txt");
	//byte[] b = new byte[10];
	byte[] b = null;
	int t,i;
	
	try {
		bis = new BufferedInputStream(new FileInputStream(archivo));
		b = bis.readAllBytes();
		for(i=0; i<b.length; i++) {
			System.out.print((char)b[i]);
		}
		
		/*
		while ((t=bis.read(b,0,10))>0) {
			for(i=0; i<t; i++) {
		        char ch = (char)b[i];
		        System.out.print(b[i]);
		        //System.out.print(ch);
			}
			System.out.println("   --> Leo en total "+t+" bytes.");
			}
			*/
	
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			bis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	}

}