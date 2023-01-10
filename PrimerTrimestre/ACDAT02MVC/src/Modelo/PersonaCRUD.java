package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonaCRUD {

	private Connection con;

	public PersonaCRUD(Connection con) {
		this.con = con;
	}

	/**
	 * Creamos el metodo insertar() para poder agregar datos en la base de datos.
	 *
	 * @param persona objetoPersona
	 * @return int
	 */
	public int insertar(Persona p) {
		int res = 0;
		String sql = "INSERT INTO PERSONA (DNI, NOMBRE, EDAD) VALUES(?, ?, ?)";
		try {
			PreparedStatement sentencia = con.prepareStatement(sql);
			sentencia.setString(1, p.getDni());
			sentencia.setString(2, p.getNombre());
			sentencia.setInt(3, p.getEdad());
			sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * Modifica los datos de una persona en la base de datos.
	 * 
	 * @param String dni
	 * @return persona
	 */
	public int modificar(Persona p) {
		int res = 0;
		String sql = "UPDATE PERSONA SET NOMBRE = ?, EDAD = ? WHERE DNI = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getNombre());
			ps.setInt(2, p.getEdad());
			ps.setString(3, p.getDni());
			ps.executeUpdate();
			System.out.println("Persona actualizada.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al actualizar persona");

		}
		return res;
	}

	/**
	 * Borra los datos de la base de datos con la clave primaria
	 * 
	 * @param String dni
	 * @return persona
	 */
	public int borrar(String dni) {
		int res = 0;
		String sql = "DELETE FROM PERSONA WHERE DNI = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dni);
			ps.executeUpdate();
			System.out.println("Persona borrada.");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se a podido borrar.");

		}
		return res;
	}

	/**
	 * Lee los datos con la clave primaria construye un objeto con sus datos y lo
	 * devuelve.
	 *
	 * @param String dni
	 * @return persona
	 */
	public Persona leer(String dni) {
		Persona p = null;
		// Traemos de base de datos una persona y la devolvemos.
		String sql = "SELECT * FROM PERSONA WHERE upper(DNI) = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dni);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				p = new Persona(rs.getString("DNI"), rs.getString("NOMBRE"), rs.getInt("EDAD"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * 0 Lee los datos y construye un objeto con sus datos y lo devuelve.
	 *
	 * @param null
	 * @return persona
	 */
	public ArrayList<Persona> leer() {
		ArrayList<Persona> personas = null;
		int res = 0;
		String sql = "SELECT * FROM PERSONA";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Persona p = new Persona(rs.getString(1), rs.getString(2), rs.getInt(3));
				personas = new ArrayList<Persona>();
				personas.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return personas;
	}

}
