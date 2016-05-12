package co.edu.udea.iw.logicaNegocio;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.ExceptionDao;
import co.edu.udea.iw.exception.IWServiceException;

/**
 * Pruebas para la logica de negocio de todo lo relacionado con las solicitudes.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class SolicitudServiceTest {

	@Autowired
	SolicitudService solicitudService; // inyeccion de dependencia de
										// SolicitudService

	/**
	 * Prueba para guardar una solicitud en la base de datos, se muestra
	 * confirmacion del almacenamiento de la solicitud, y los valores que fueron
	 * almacenados,
	 */
	// @Test
	public void guardarSolicitud() {

		try {
			Solicitud solicitud = solicitudService.guardarSolicitud("descr", 2, "milena", "carro", 1, new Date());
			System.out.println("Se guardo correctamente la solicitud con la siguiente informacion:");
			System.out.println("ID de Solicitud: " + solicitud.getId());
			System.out.println("Descripcion: " + solicitud.getDescripcion());
			System.out.println("Tipo de Solicitud: " + solicitud.getTipoSolicitud().getNombre());
			System.out.println("Cliente: " + solicitud.getCliente().getNombres());
		} catch (ExceptionDao e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IWServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getCause().toString());
		}
	}

	/**
	 * Prueba para obtener la lista de todas las solicitudes realizadas por los
	 * clientes. Solo podran ser vistas por el usuario que tenga el rol de
	 * gerente.
	 */
	// @Test
	public void mostrarSolicitudes() {
		try {
			List<Solicitud> solicitudes = solicitudService.obtenerSolicitudes("bojaca");
			if (solicitudes.isEmpty()) {
				System.out.println("No hay nada para mostrar");
			}
			for (Solicitud solicitud : solicitudes) {
				System.out.println("ID solicitud: " + solicitud.getId());
				System.out.println("Desripcion: " + solicitud.getDescripcion());
				System.out.println("Cliente: " + solicitud.getCliente().getNombres());
				System.out.println();
			}
		} catch (ExceptionDao e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IWServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Prueba para responder una solicitud, se le asigna una descripcion de la
	 * respuesta, la fecha de respuesta y el usuario responsable de responder la
	 * solicitud. Solo podran ser vistas por el usuario que tenga el rol de
	 * gerente y administrador.
	 */
	// @Test
	public void responderSolicitud() {

		try {
			solicitudService.responderSolicitud(1, "No podemos responder esta solicitud", new Date(), "diana");
		} catch (ExceptionDao e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IWServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Prueba para asignar un responsable de responder la solicitud realizada
	 * por un cliente. Se muestra la descripcion de la solicitud realizada por
	 * el cliente, y el responsable de responderla.
	 */
	// @Test
	public void asignarResponsable() {

		try {
			Solicitud solicitid = solicitudService.asignarResponsable(1, "diana", "bojaca");
			System.out.println("Se asigno correctamente el responsable...");
			System.out.println("ID de Solicitud: " + solicitid.getId());
			System.out.println("Descripcion: " + solicitid.getDescripcion());
			System.out.println("Responsable: " + solicitid.getResponsable().getNombres() + " "
					+ solicitid.getResponsable().getApellidos());
		} catch (ExceptionDao e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IWServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Prueba para encontrar las solicitudes a las que no se les ha enviado
	 * respuesta, durante el tiempo maximo establecido.
	 */
	@Test
	public void solicitudesAtrasadas() {
		try {
			for (Solicitud solicitud : solicitudService.seguimientoSolicitudes()) {

				System.out.println("Id Solicitud: " + solicitud.getId());
				System.out.println("Fecha de Solicitud:" + solicitud.getFechaSolicitud());
				System.out.println();

			}
		} catch (ExceptionDao e) {
			e.printStackTrace();
		} catch (IWServiceException e) {
			e.printStackTrace();
		}
	}

}
