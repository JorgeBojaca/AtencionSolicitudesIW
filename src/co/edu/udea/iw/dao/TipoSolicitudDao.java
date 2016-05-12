package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.TipoSolicitud;
import co.edu.udea.iw.exception.ExceptionDao;

/**
 * DAO Interfaz que define los metodos que va a proveer
 * la clase TipoSolicitud.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
public interface TipoSolicitudDao {

	/**
	 * Obtiene la lista de los tipos de solicitud almacenados en la 
	 * tabla TipoSolicitud de la base de datos.
	 * 
	 * @return lista de los tipos de solicitud.
	 * @throws ExceptionDao cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public List<TipoSolicitud> obtenerTipoSolicitudes() throws ExceptionDao;

	/**
	 * Obtiene el tipo Solicitud que corresponda al identificador ingresado como parámetro.
	 * 
	 * @param id identificador del tipo de solicitud.
	 * @return TipoSolicitud con toda su información.
	 * @throws ExceptionDao cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public TipoSolicitud obtenerTipoSolicitud(Integer id) throws ExceptionDao;

}
