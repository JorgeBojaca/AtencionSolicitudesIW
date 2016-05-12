package co.edu.udea.iw.dto;

/**
 * DTO
 * Clase para manejar la Tabla Pregunta
 * de la Base de Datos atencionSolicitudes..
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca  
 * @version 1.0
 */
public class Pregunta {

	private Integer id;
	private String descripcion;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
