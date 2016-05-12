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


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class SolicitudServiceTest {
	
	@Autowired
	SolicitudService solicitudService;

//	@Test
	public void guardarSolicitud() {
		
		try {
			Solicitud solicitud=solicitudService.guardarSolicitud("descr",2, "milena", "carro", 1,new Date());
			System.out.println("Se guardó correctamente la solicitud con la siguiente información:");
			System.out.println("ID de Solicitud: "+solicitud.getId());
			System.out.println("Descripción: "+solicitud.getDescripcion());
			System.out.println("Tipo de Solicitud: "+solicitud.getTipoSolicitud().getNombre());
			System.out.println("Cliente: "+solicitud.getCliente().getNombres());
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
	
//	@Test
	public void mostrarSolicitudes(){
		try {
			List<Solicitud> solicitudes=solicitudService.obtenerSolicitudes("bojaca");
			if(solicitudes.isEmpty()){
				System.out.println("No hay nada para mostrar");
			}
			for(Solicitud solicitud:solicitudes){
				System.out.println("ID solicitud: "+solicitud.getId());
				System.out.println("Desripción: "+solicitud.getDescripcion());
				System.out.println("Cliente: "+solicitud.getCliente().getNombres());
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
	
//	@Test
	public void responderSolicitud(){
		
		try {
			solicitudService.responderSolicitud(1, "No podemos responder esta solicitud", new Date(),"diana");
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
//	@Test
	public void asignarResponsable(){
		
		try {
			Solicitud solicitid=solicitudService.asignarResponsable(1, "diana","bojaca");
			System.out.println("Se asignó correctamente el responsable...");
			System.out.println("ID de Solicitud: "+solicitid.getId());
			System.out.println("Descripcion: "+solicitid.getDescripcion());
			System.out.println("Responsable: "+solicitid.getResponsable().getNombres()+" "+
					solicitid.getResponsable().getApellidos());
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
	
	@Test
	public void solicitudesAtrasadas(){
		try {
			for(Solicitud solicitud:solicitudService.seguimientoSolicitudes()){
				
				System.out.println("Id Solicitud: "+solicitud.getId());
				System.out.println("Fecha de Solicitud:" +solicitud.getFechaSolicitud());
				System.out.println();
				
			}
		} catch (ExceptionDao e) {
			e.printStackTrace();
		} catch (IWServiceException e) {
			e.printStackTrace();
		}
	}
	

}
