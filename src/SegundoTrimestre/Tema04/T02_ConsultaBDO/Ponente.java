/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SegundoTrimestre.Tema04.T02_ConsultaBDO;

/**
 *
 * @author IMCG
 */
//clase que implementa la entidad ponente
public class Ponente {
	private String nif;
	private String nombre;
	private String email;
	private float cache;

	// constructores
	public Ponente() {
		this.nif = null;
		this.nombre = null;
		this.email = null;
		this.cache = 0;
	}

	public Ponente(String ni, String n, String e) {
		this.nif = ni;
		this.nombre = n;
		this.email = e;
		this.cache = -1; // caché no asignado
	}

	public Ponente(String ni, String no, String e, float c) {
		this.nif = ni;
		this.nombre = no;
		this.email = e;
		this.cache = c;
	}

	// métodos básicos para asignar y obtener valores de atributos
	public void setNif(String n) {
		this.nif = n;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNombre(String n) {
		this.nombre = n;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setEmail(String e) {
		this.email = e;
	}

	public String getEmail() {
		return this.email;
	}

	public void setCache(float c) {
		this.cache = c;
	}

	public float getCache() {
		return this.cache;
	}

	@Override
	// comportamiento del método toString heredado de la superclase Objet
	// Devuelve los atributos de un objeto ponente
	public String toString() {
		if (this.cache != -1) {
			return this.nif + " " + this.nombre + " " + this.email + " Caché:" + this.cache;
		} else {
			return this.nif + " " + this.nombre + " " + this.email;
		}
	}

}
