/**
 * 
 */
package co.edu.udea.iw.dto;

/**
 * DTO
 * Clase para manejar la tabla TipoSolicitud
 * de la Base de Datos atencionSolicitudes..
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca 
 * @version 1.0
 */
public class TipoSolicitud {
	
	private int id;
	private String nombre;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}		
}
