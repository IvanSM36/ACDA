package XML;

public class Modulo {

	private String nombre;
	private int nota;
	
	public Modulo(String nombre, int nota) {
		this.setNota(nota);
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
	
}
