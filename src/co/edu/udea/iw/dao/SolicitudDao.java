package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.ExceptionDao;

/**
 * DAO Interfaz que define los metodos que va a proveer la clase Solicitud.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
public interface SolicitudDao {

	/**
	 * Registrar una nueva solicitud en la tabla Solicitud.
	 * 
	 * @param solicitud
	 *            registro de la solicitud hecha por el usuario que se guardará
	 *            en la tabla de Solicitud.
	 * @throws ExceptionDao
	 *             cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public void guardar(Solicitud solicitud) throws ExceptionDao;

	/**
	 * Actualizar la informacion de la solicitud en la tabla Solicitud.
	 * 
	 * @param solicitud
	 *            registro que contiene la informacion de la Solicitud que se va
	 *            a actualizar.
	 * @return Solicitud actualizado.
	 * @throws ExceptionDao
	 *             cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public Solicitud actualizar(Solicitud solicitud) throws ExceptionDao;

	/**
	 * Obtener la lista de solicitudes almacenados en la tabla Solicitud de la
	 * base de datos.
	 * 
	 * @return lista de solicitudes.
	 * @throws ExceptionDao
	 *             cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public List<Solicitud> obtenerSolicitud() throws ExceptionDao;

	/**
	 * Obtener la Solicitud que corresponda al identificador ingresado como
	 * parámetro.
	 * 
	 * @param id
	 *            identifidor de la solicitud.
	 * @return Solicitud con toda su información.
	 * @throws ExceptionDao
	 *             cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public Solicitud obtenerSolicitud(int id) throws ExceptionDao;

}
