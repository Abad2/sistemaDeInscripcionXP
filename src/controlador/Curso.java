package controlador;

import java.sql.Date;

public class Curso {
	private String nombreCurso, nombreDocente;
	private Date fecha, hora;

	public Curso() {
		nombreCurso = "";
		nombreDocente = "Sin docente";

	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getNombreDocente() {
		return nombreDocente;
	}

	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String crearCurso()//String nombreCurso, String nombreDocente, Date fecha, date hora)
	{
		
		
		boolean confirmacion = true;
		if (!confirmacion) {
			return "No se pudo crear el curso";
		}

		else {
			return "El curso fue creado correctamente";
		}
	}

	public static void main(String args []){
		Curso taller = new Curso();
		String confirmacion = taller.crearCurso();
		System.out.println(confirmacion);
	}
}

