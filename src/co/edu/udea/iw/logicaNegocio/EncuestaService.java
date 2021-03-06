package co.edu.udea.iw.logicaNegocio;

import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.dao.PreguntaDao;
import co.edu.udea.iw.dao.RespuestaDao;
import co.edu.udea.iw.dao.SolicitudDao;
import co.edu.udea.iw.dto.PkRespuesta;
import co.edu.udea.iw.dto.Pregunta;
import co.edu.udea.iw.dto.Respuesta;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.ExceptionDao;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.validation.Validaciones;

/**
 * Clase encargada de la logica de negocio para la Encuestas de satisfaccion.
 * Clase transaccional con la BD. Será util para realizar la encuesta de
 * satisfaccion a los clientes del sistema.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
@Transactional
public class EncuestaService {

	/**
	 * Beans para manejar los DaoHibernate
	 */
	private PreguntaDao preguntaDAO;
	private RespuestaDao respuestaDAO;
	private SolicitudDao solicitudDAO;

	/**
	 * Metodo para validar y obtener la lista de respuestas de una solicitud
	 * determinada
	 * 
	 * @return Listado de Preguntas.
	 * @throws ExceptionDao
	 *             cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public List<Respuesta> obtener(Integer idSolicitud) throws ExceptionDao, IWServiceException {
		if (Validaciones.isTextoVacio(Integer.toString(idSolicitud))) {
			throw new IWServiceException(" El campo idSolicitud no debe ser nulo, ni una cadena de caracteres vacia");
		}
		if (solicitudDAO.obtenerSolicitud(idSolicitud) == null) {
			throw new IWServiceException(" No existe una Solicitud con la identificaci�n ingresada");
		}
		return respuestaDAO.obtenerRespuestas(idSolicitud);
	}

	/**
	 * Metodo para validar y obtener la lista de preguntas que seran desplegadas
	 * en la encuesta de satisfaccion que se enviara al cliente.
	 * 
	 * @return Listado de Preguntas
	 * @throws ExceptionDao
	 *             cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public List<String> generarEncuesta() throws ExceptionDao {
		List<String> strPreguntas = new ArrayList<String>();
		List<Pregunta> preguntas;
		preguntas = preguntaDAO.obtenerPreguntas();
		for (Pregunta pregunta : preguntas) {
			strPreguntas.add(pregunta.getDescripcion());
		}
		return strPreguntas;
	}

	/**
	 * Metodo para validar y guardar la respuestas dadas por el cliente a la
	 * encuentas de satisfaccion.
	 * 
	 * @param idSolicitud
	 *            identificador de la Solicitud.
	 * @param idPregunta
	 *            identificador de la Pregunta.
	 * @param respuesta
	 *            respuesta a la pregunta
	 * @throws ExceptionDao
	 *             cuando ocurre cualquier error en la comunicación con la BD.
	 * @throws IWServiceException
	 *             cuando ocurre cualquier error en la logica de negocio.
	 */
	public void guardarRespuesta(Integer idSolicitud, Integer idPregunta, Integer respuesta)
			throws ExceptionDao, IWServiceException {
		if (Validaciones.isTextoVacio(Integer.toString(idSolicitud))) {
			throw new IWServiceException(" El campo idSolicitud no debe ser nulo, ni una cadena de caracteres vacia");
		}
		if (Validaciones.isTextoVacio(Integer.toString(idPregunta))) {
			throw new IWServiceException(" El campo idPregunta no debe ser nulo, ni una cadena de caracteres vacia");
		}
		if (Validaciones.isTextoVacio(Integer.toString(respuesta))) {
			throw new IWServiceException(" El campo respuesta no debe ser nulo, ni una cadena de caracteres vacia");
		}
		Solicitud solicitud = solicitudDAO.obtenerSolicitud(idSolicitud);
		if (solicitud == null) {
			throw new IWServiceException(" No existe la solicitud, por lo tanto no puede responder la encuesta");
		}
		Pregunta pregunta = preguntaDAO.obtenerPregunta(idPregunta);
		if (pregunta == null) {
			throw new IWServiceException(" No puede responder una pregunta que no existe");
		}
		if (respuesta > 5 && respuesta < 1) {
			throw new IWServiceException(" La respuesta debe estar entre 1 y 5");
		}

		Respuesta resp = new Respuesta();
		PkRespuesta idRespuesta = new PkRespuesta();
		idRespuesta.setIdPregunta(pregunta);
		idRespuesta.setIdSolicitud(solicitud);
		if (respuestaDAO.obtenerRespuesta(idRespuesta) != null) {
			throw new IWServiceException("Solo se puede responder una vez");
		}
		resp.setId(idRespuesta);
		resp.setRespuesta(respuesta);

		respuestaDAO.guardarRespuesta(resp);
	}

	/**
	 * Metodo para validar y generar el promedio de respuesta de la pregunta
	 * ingresada como parametro.
	 * 
	 * @param idPregunta
	 *            identificador de la pregunta
	 * @return promedio
	 * @throws ExceptionDao
	 *             cuando ocurre cualquier error en la comunicación con la BD.
	 * @throws IWServiceException
	 *             cuando ocurre cualquier error en la logica de negocio.
	 */
	public String estadisticaPorPregunta(Integer idPregunta) throws IWServiceException, ExceptionDao {

		if (idPregunta == null) {
			throw new IWServiceException(" El campo idPregunta no puede ser null");
		}
		if (Validaciones.isTextoVacio(Integer.toString(idPregunta))) {
			throw new IWServiceException(" El campo idPregunta no debe ser nulo, ni una cadena de caracteres vacia");
		}
		if (preguntaDAO.obtenerPregunta(idPregunta) == null) {
			throw new IWServiceException(" No existe una pregunta para el id ingresado");
		}
		List<Respuesta> respuestas = respuestaDAO.obtenerRespuestasP(idPregunta);
		int i = 0;
		int suma = 0;
		for (Respuesta respuesta : respuestas) {
			suma += respuesta.getRespuesta();
			i++;
		}

		if (i != 0) {
			int promedio = suma / i;
			return "Se encontraron " + Integer.toString(i) + " respuestas para esta pregunta y un promedio = "
					+ Integer.toString(promedio);

		} else {
			return "No hay respuestas para la pregunta ingresada";
		}
	}

	/**
	 * 
	 * @return preguntaDAO
	 */
	public PreguntaDao getPreguntaDAO() {
		return preguntaDAO;
	}

	/**
	 * 
	 * @param preguntaDAO
	 */
	public void setPreguntaDAO(PreguntaDao preguntaDAO) {
		this.preguntaDAO = preguntaDAO;
	}

	/**
	 * 
	 * @return respuestaDAO
	 */
	public RespuestaDao getRespuestaDAO() {
		return respuestaDAO;
	}

	/**
	 * 
	 * @param respuestaDAO
	 */
	public void setRespuestaDAO(RespuestaDao respuestaDAO) {
		this.respuestaDAO = respuestaDAO;
	}

	/**
	 * 
	 * @return solicitudDAO
	 */
	public SolicitudDao getSolicitudDAO() {
		return solicitudDAO;
	}

	/**
	 * 
	 * @param solicitudDAO
	 */
	public void setSolicitudDAO(SolicitudDao solicitudDAO) {
		this.solicitudDAO = solicitudDAO;
	}

}
