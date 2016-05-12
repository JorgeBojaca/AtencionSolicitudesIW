package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.ExceptionDao;

/**
 * DAO
 * Interfaz que define los metodos que va a proveer
 * la clase Solicitud.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca 
 * @version 1.0
 */
public interface SolicitudDao {
	
	/**
	* Registrar un nuevo solicitud en la tabla Solicitud.
	* 
	* @param solicitud registro de usuario que se guardará en la tabla de Solicitud.
	* @throws ExceptionDao cuando ocurre cualquier error en la comunicación con la BD.
	*/
	public void guardar(Solicitud solicitud) throws ExceptionDao;

	/**
	 * Actualiza la informacion del usuario en la tabla Solicitud.
	 * 
	 * @param Solicitud registro que contiene la informacion del Solicitud que se va a actualizar.
	 * @return Solicitud actualizado.
	 * @throws ExceptionDao cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public Solicitud actualizar(Solicitud solicitud) throws ExceptionDao;

	/**
	 * Obtiene la lista de solicitudes almacenados en la tabla Solicitud de la base de datos.
	 * 
	 * @return lista de solicitudes.
	 * @throws ExceptionDao cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public List<Solicitud> obtenerSolicitud() throws ExceptionDao;

	/**
	 * Obtiene la Solicitud que corresponda al id ingresada como parámetro.
	 * 
	 * @param id identificacion de la solicitud.
	 * @return Solicitud con toda su información.
	 * @throws ExceptionDao cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public Solicitud obtenerSolicitud(int id) throws ExceptionDao;

}
