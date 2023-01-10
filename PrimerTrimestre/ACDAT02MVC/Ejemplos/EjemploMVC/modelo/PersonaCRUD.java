package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonaCRUD {


	private Connection con;
	
	
	public PersonaCRUD(Connection con) {
		this.con = con;
	}
	
	public int insertar(Persona p) {
		int res = 0;
		return res;		
	}
	public int modificar(Persona p) {
		int res = 0;
		return res;		
	}
	public int borrar(String dni) {
		int res = 0;
		return res;
	}
	public Persona leer(String dni) {
		Persona p = null;
		//Traemos de base de datos una persona y la devolvemos.
		return p;
	}
	public ArrayList<Persona> leer() {
		ArrayList<Persona> personas = null;
		return personas;
	}

}
