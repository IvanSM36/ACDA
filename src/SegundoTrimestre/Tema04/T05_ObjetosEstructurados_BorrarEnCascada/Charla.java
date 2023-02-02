package SegundoTrimestre.Tema04.T05_ObjetosEstructurados_BorrarEnCascada;

public class Charla {
	private String titulo;
	private float duracion;
	private Ponente pl;

//constructor
	public Charla() {
		
	}
	
	public Charla(String ti, float h) {
		this.titulo = ti;
		this.pl = null;
		this.duracion = h;
	}

//Método para obtener el ponente de una charla
	public Ponente getPonente() {
		return pl;
	}

//Método para asignar el ponente de una charla
	public void setPonente(Ponente p) {
		this.pl = p;
	}

//Método para obtener el título de una charla
	public String getTitulo() {
		return titulo;
	}

//Método para obtener la duración de una charla
	public float getDuracion() {
		return duracion;
	}

//Método para asignar el ponente de una charla
	public void setDuracion(float h) {
		this.duracion = h;
	}

//Método para mostrar título y ponente de una charla
	@Override
	public String toString() {
		return "Charla: " + titulo + ", " + duracion + " horas. PONENTE: " + pl;
	}
}
