package Tema01.Practica1_2;


public class SuperHeroe {

	private String nombre;
	private String arma;
	private int anyo;
	public SuperHeroe(String nombre, String arma, int anyo) {
		this.nombre = nombre;
		this.anyo = anyo;
		this.arma = arma;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getArma() {
		return arma;
	}
	public void setArma(String arma) {
		this.arma = arma;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	
	@Override
	public String toString() {
		return "SuperHeroe [nombre=" + nombre + ", arma=" + arma + ", anyo=" + anyo + "]";
	}	
	
}
