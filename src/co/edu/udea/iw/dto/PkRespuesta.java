package co.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * DTO
 * Clase para la clave primaria compuesta
 * de la tabla respuesta de la Base de Datos 
 * atencionSolicitudes..
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca  
 * @version 1.0
 */
public class PkRespuesta implements Serializable {
	
	private Solicitud idSolicitud;
	private Pregunta idPregunta;
	
	public Solicitud getIdSolicitud() {
		return idSolicitud;
	}
	
	public void setIdSolicitud(Solicitud idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	
	public Pregunta getIdPregunta() {
		return idPregunta;
	}
	
	public void setIdPregunta(Pregunta idPregunta) {
		this.idPregunta = idPregunta;
	}
	
}
