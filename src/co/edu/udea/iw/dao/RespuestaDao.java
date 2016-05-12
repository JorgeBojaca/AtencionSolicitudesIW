package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.PkRespuesta;
import co.edu.udea.iw.dto.Respuesta;
import co.edu.udea.iw.exception.ExceptionDao;

/**
 * DAO Interfaz que define los metodos que va a proveer la clase Respuesta. Esta
 * clase se usa para manejar las respuestas hechas por el cliente a la encuesta
 * de satisfaccion.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
public interface RespuestaDao {

	/**
	 * Guardar las respuestas hechas por el cliente en la Tabla Respuesta.
	 * 
	 * @param respuesta
	 *            registro de la respuesta que se guardará en la tabla de
	 *            Respuesta.
	 * @throws ExceptionDao
	 *             cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public void guardarRespuesta(Respuesta respuesta) throws ExceptionDao;

	/**
	 * Obtener la lista de respuestas de la solicitud enviada como parametro, la
	 * cual esta almacenadas en la tabla Respuesta de la base de datos.
	 * 
	 * @param solicitud
	 *            identificador de la solicitud
	 * @return Lista de Respuestas de la solicitud
	 * @throws ExceptionDao
	 *             cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public List<Respuesta> obtenerRespuestas(Integer solicitud) throws ExceptionDao;

	/**
	 * Obtener todas las respuesta al identificador de pregunta, ingresado como
	 * parámetro.
	 * 
	 * @param pregunta
	 *            identificador de la pregunta
	 * @return Listado de respuestas
	 * @throws ExceptionDao
	 *             cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public List<Respuesta> obtenerRespuestasP(Integer pregunta) throws ExceptionDao;

	/**
	 * Obtener la respuesta que corresponda al identificador ingresado como
	 * parámetro.
	 * 
	 * @param id
	 *            identificador de la respuesta.
	 * @return Respuesta con toda su informacion.
	 * @throws ExceptionDao
	 *             cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public Respuesta obtenerRespuesta(PkRespuesta id) throws ExceptionDao;

}
