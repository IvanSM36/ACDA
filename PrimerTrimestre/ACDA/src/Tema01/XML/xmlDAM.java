package Tema01.XML;

public class xmlDAM {

	private String ciclo;
	private int curso;
	private Alumno[] alumnos;
	public xmlDAM(String ciclo, int curso, Alumno[] alumnos) {
		this.ciclo = ciclo;
		this.curso = curso;
		this.alumnos = alumnos;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public Alumno[] getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}
	
	
}
