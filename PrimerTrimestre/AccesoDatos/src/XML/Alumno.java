package XML;

public class Alumno {

	private String nombre;
	private Modulo[] modulos;
	
	public Alumno(String nombre, Modulo[] modulos) {
		this.setNombre(nombre);
		this.setModulos(modulos);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Modulo[] getModulos() {
		return modulos;
	}

	public void setModulos(Modulo[] modulos) {
		this.modulos = modulos;
	}
}
