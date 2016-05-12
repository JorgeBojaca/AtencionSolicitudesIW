package co.edu.udea.iw.dto;

/**
 * DTO
 * Clase para manejar la tabla Respuesta
 * de la Base de Datos atencionSolicitudes.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
public class Respuesta {

	private PkRespuesta id; //Pk compuesta
	private Integer respuesta;
	
	public PkRespuesta getId() {
		return id;
	}
	
	public void setId(PkRespuesta id) {
		this.id = id;
	}
	
	public Integer getRespuesta() {
		return respuesta;
	}
	
	public void setRespuesta(Integer respuesta) {
		this.respuesta = respuesta;
	}	
}
