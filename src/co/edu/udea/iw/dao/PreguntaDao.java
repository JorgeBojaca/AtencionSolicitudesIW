package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Pregunta;
import co.edu.udea.iw.exception.ExceptionDao;

/**
 * DAO Interfaz que define los metodos que va a proveer la clase Pregunta. Esta
 * clase representa la encuesta de satisfacción que se le realizara a los
 * clientes.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */

public interface PreguntaDao {

	/**
	 * Obtiene la lista de preguntas de solicitud almacenados en la tabla
	 * Pregunta de la base de datos.
	 * 
	 * @return lista de preguntas de la encuesta de satisfaccion.
	 * @throws ExceptionDao cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public List<Pregunta> obtenerPreguntas() throws ExceptionDao;

	/**
	 * Obtiene la pregunta que corresponda al identificador ingresado como
	 * parámetro.
	 * 
	 * @param id identificador de la pregunta.
	 * @return Pregunta con toda su información.
	 * @throws ExceptionDao cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public Pregunta obtenerPregunta(Integer id) throws ExceptionDao;

}
