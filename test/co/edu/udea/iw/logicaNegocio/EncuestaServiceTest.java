package co.edu.udea.iw.logicaNegocio;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.dto.Respuesta;
import co.edu.udea.iw.exception.ExceptionDao;
import co.edu.udea.iw.exception.IWServiceException;

/**
 * Pruebas para La logica de negocio de todo lo relacionado con la encuesta de
 * satisfaccion que se envia al cliente.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class EncuestaServiceTest {
	@Autowired
	EncuestaService encuestaService;// inyeccion de dependencia de
									// EncuestaService
	@Autowired
	SolicitudService solicitudService;// inyeccion de dependencia de
										// SolicitudService

	/**
	 * Prueba para obtener todas las respuesta de la encuesta realizada al
	 * cliente, entrega el identificador de la solicitud, la pregunta con su
	 * descripcion y su respectiva respuesta.
	 */
	// @Test
	public void obtenerRespuestas() {
		List<Respuesta> respuestas;
		try {

			respuestas = encuestaService.obtener(2);
			for (Respuesta respuesta : respuestas) {
				System.out.println("Id Solicitud:" + respuesta.getId().getIdSolicitud().getId());
				System.out.println("Pregunta: " + respuesta.getId().getIdPregunta().getDescripcion());
				System.out.println("Respuesta: " + respuesta.getRespuesta());
				System.out.println();
			}
		} catch (ExceptionDao e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IWServiceException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	/**
	 * Prueba para generar la encuesta, genera todas las preguntas
	 * correspondientes a la encuesta.
	 */
	// @Test
	public void generarEncuesta() {

		try {
			int i = 0;
			for (String pregunta : encuestaService.generarEncuesta()) {
				if (i == 0) {
					System.out.println("Encuesta de Satisfaccion:");
				}
				i++;
				System.out.println(pregunta);
			}
		} catch (ExceptionDao e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Prueba para responder una unica pregunta
	 * 
	 */
	// @Test
	public void responderEncuesta() {

		try {
			encuestaService.guardarRespuesta(1, 2, 4);
			System.out.println("Se ha guardado su respuesta!!");
		} catch (ExceptionDao e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		} catch (IWServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Prueba para generar el promedio de respuesta de la pregunta que se envia
	 * como parametro
	 */
	@Test
	public void estadisticaPorPregunta() {
		try {
			System.out.println(encuestaService.estadisticaPorPregunta(1));
		} catch (IWServiceException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (ExceptionDao e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
