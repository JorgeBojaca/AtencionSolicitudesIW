package co.edu.udea.iw.logicaNegocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.SolicitudDao;
import co.edu.udea.iw.dao.TipoSolicitudDao;
import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.dto.Sucursal;
import co.edu.udea.iw.dto.TipoSolicitud;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionDao;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.validation.Validaciones;

/**
 * Clase encargada de la logica de negocio para la clase Solicitud. Clase
 * transaccional con la BD.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
@Transactional
public class SolicitudService {

	private SolicitudDao solicitudDAO;
	private UsuarioDao usuarioDAO;
	private TipoSolicitudDao tipoSolicitudDAO;
	//private int cont = 0;

	/**
	 * Metodo para guardar la solicitud realizada
	 * por el Cliente.
	 * Los campos necesarios para realizar la solicitud
	 * son los ingresados como parametros.
	 * 
	 * @param descripcion
	 * @param tiposolicitud
	 * @param cliente
	 * @param producto
	 * @param idSucursal
	 * @param fechaSolicitud
	 * @throws ExceptionDao
	 * @throws IWServiceException
	 */
	public Solicitud guardarSolicitud(String descripcion, int tiposolicitud,
			String cliente, String producto, int idSucursal, Date fechaSolicitud)
			throws ExceptionDao, IWServiceException {

		TipoSolicitud tipoSolicitud = null;
		Usuario usuario;
		Solicitud solicitud;
		usuario = usuarioDAO.obtenerUsuario(cliente);
		if (usuario == null) {
			throw new IWServiceException("El usuario no existe en el sistema");
		}	
		if(!usuario.getRol().getNombre().equals("cliente")){
			throw new IWServiceException(
					"No tiene permisos para realizar solicitudes");
		}
			
		tipoSolicitud = tipoSolicitudDAO.obtenerTipoSolicitud(tiposolicitud);
		if (tipoSolicitud == null) {
			throw new IWServiceException(
					"El tipo de solicitud no es valida en el sistema");
		}
		if (Validaciones.isTextoVacio(descripcion)) {
			throw new IWServiceException(
					"El campo descripcion no puede ser nulo, ni una cadena de caracteres vacia");
		}

		if (Validaciones.isTextoVacio(producto)) {
			throw new IWServiceException(
					"El campo producto no puede ser nulo, ni una cadena de caracteres vacia");
		}

		if (Validaciones.isTextoVacio(Integer.toString(idSucursal))) {
			throw new IWServiceException("Debe seleccionar una sucursal");
		}

		

		solicitud = new Solicitud();

		//solicitud.setId(cont++);
		solicitud.setCliente(usuario);
		solicitud.setTipoSolicitud(tipoSolicitud);
		solicitud.setDescripcion(descripcion);
		solicitud.setProducto(producto);

		solicitudDAO.guardar(solicitud);
		
		return solicitud;

	}

	
	/**
	 * Metodo para asignar un responsable que se encargue de responder la
	 * solicitud.
	 * 
	 * @param idSolicitud identificador de la solicitud.
	 * @param responsable usuario del encargado de responder la solicitud.
	 * @throws ExceptionDao Manejar las excepciones del DAO.
	 * @throws IWServiceException Manejar las excepciones de la lÃ³gica del negocio.
	 */
	public Solicitud asignarResponsable(int idSolicitud, String usuarioResponsable,String usuarioGerente)
			throws ExceptionDao, IWServiceException {
		
		if (Validaciones.isTextoVacio(Integer.toString(idSolicitud))) {
			throw new IWServiceException(
					" El campo idSolicitud no debe ser nulo, ni una cadena de caracteres vacia");
		}
		if (Validaciones.isTextoVacio(usuarioResponsable)) {
			throw new IWServiceException(
					" El campo usuarioResponsable no debe ser nulo, ni una cadena de caracteres vacia");
		}
		if (Validaciones.isTextoVacio(usuarioGerente)) {
			throw new IWServiceException(
					" El campo usuarioGerente no debe ser nulo, ni una cadena de caracteres vacia");
		}
		
		if(!usuarioDAO.obtenerUsuario(usuarioGerente).getRol().getNombre().equals("gerente")){
			throw new IWServiceException(
					"No tiene permisos para realizar esta accion");
		}

		Usuario usrResponsable;
		Solicitud solicitud;

		usrResponsable = usuarioDAO.obtenerUsuario(usuarioResponsable);
		solicitud = solicitudDAO.obtenerSolicitud(idSolicitud);

		if (usrResponsable == null) {
			throw new IWServiceException(
					"El usuario al que le desea asignar la solicitud no se encuentra en el sistema");
		}
		if(usrResponsable.getRol().getNombre().equals("cliente")){
			throw new IWServiceException(
					"No le puede asignar esta responsabilidad a un cliente");
		}

		if (solicitud == null) {
			throw new IWServiceException("No se encuentra la solicitud");
		}
		solicitud.setResponsable(usrResponsable);
		solicitudDAO.actualizar(solicitud);
		
		return solicitud;

	}

	/**
	 * Metodo para asignar la respuesta de la solicitud
	 * ingresada como parametro.
	 * 
	 * @param idSolicitud
	 * @param respuestaSolicitud
	 * @param fechaRespuesta
	 * @throws ExceptionDao
	 * @throws IWServiceException
	 */
	public void responderSolicitud(int idSolicitud, String respuestaSolicitud,
			Date fechaRespuesta,String usuarioResponsable) throws ExceptionDao, IWServiceException {
		
		if (Validaciones.isTextoVacio(usuarioResponsable)) {
			throw new IWServiceException(
					" El campo usuarioResponsable no debe ser nulo, ni una cadena de caracteres vacia");
		}
		if (Validaciones.isTextoVacio(respuestaSolicitud)) {
			throw new IWServiceException(
					" El campo respuesta no debe ser nulo, ni una cadena de caracteres vacia");
		}
		
		Usuario usrResponsable=usuarioDAO.obtenerUsuario(usuarioResponsable);
		
		
		if(usrResponsable==null){
			throw new IWServiceException(
					"No existe el usuario");
		}
		if(usrResponsable.getRol().getNombre().equals("cliente")){
			throw new IWServiceException(
					"No tiene permisos para responder una solicitud");
		}

		Solicitud solicitud=solicitudDAO.obtenerSolicitud(idSolicitud);

		if (solicitud == null) {
			throw new IWServiceException("No se encuentra la solicitud");
		}

		

		solicitud.setRespuesta(respuestaSolicitud);
		solicitud.setFechaRespuesta(fechaRespuesta);
		solicitud.setResponsable(usrResponsable);

		solicitudDAO.actualizar(solicitud);

	}
	
	/**
	 * Metodo para obtener la lista de solicitudes
	 * 
	 * @return
	 * @throws ExceptionDao
	 * @throws IWServiceException
	 */
	public List<Solicitud> obtenerSolicitudes(String user)throws ExceptionDao, IWServiceException{
		
		if(!usuarioDAO.obtenerUsuario(user).getRol().getNombre().equals("gerente")){
			throw new IWServiceException(
					"No tiene permisos para realizar esta acción");
		}
		return solicitudDAO.obtenerSolicitud();
	}
	
	/**
	 * Metodo para retornar una solicitud, dado su identificador
	 * 
	 * @param id
	 * @return
	 * @throws ExceptionDao
	 * @throws IWServiceException
	 */
	public Solicitud obtenerSolicitud(int id) throws ExceptionDao, IWServiceException {
		Solicitud solicitud;
		solicitud = solicitudDAO.obtenerSolicitud(id);
		if(solicitud == null){
			throw new IWServiceException("No se encuentra la solicitud");
		}
		return solicitud;
	}
	
	/**
     * Hacer seguimiento de fecha limite para responder una solicitud
     * TERMINAR!!
     * @return lista de las solicitudes atrasadas.
     */
    
      public List<Solicitud> seguimientoSolicitudes()throws ExceptionDao, IWServiceException {
        List<Solicitud> solicitudesAtrasadas=new ArrayList<Solicitud>();
        List<Solicitud> solicitudes;
        Date fechaActual=new Date();
        int dias=0;
        Date fechaSolicitud;
        
        
        solicitudes=solicitudDAO.obtenerSolicitud();
        
        for(Solicitud solicitud:solicitudes){
            fechaSolicitud=solicitud.getFechaSolicitud();
            dias=diferenciaEnDias(fechaActual, fechaSolicitud);
            if(dias>=15){
                solicitudesAtrasadas.add(solicitud);
            }
            
        }
        return solicitudesAtrasadas;
        
    }
    
    /**
     * Obtener los dias de diferencia entre dos fechas
     * @param fechaMayor
     * @param fechaMenor
     * @return
     */
    public int diferenciaEnDias(Date fechaMayor, Date fechaMenor){
        long diferenciaDias;
        long dias;
        diferenciaDias=fechaMayor.getTime()-fechaMenor.getTime();
        dias=diferenciaDias/(1000*60*60*24);
        return (int)dias;
    }


	public SolicitudDao getSolicitudDAO() {
		return solicitudDAO;
	}


	public void setSolicitudDAO(SolicitudDao solicitudDAO) {
		this.solicitudDAO = solicitudDAO;
	}


	public UsuarioDao getUsuarioDAO() {
		return usuarioDAO;
	}


	public void setUsuarioDAO(UsuarioDao usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}


	public TipoSolicitudDao getTipoSolicitudDAO() {
		return tipoSolicitudDAO;
	}


	public void setTipoSolicitudDAO(TipoSolicitudDao tipoSolicitudDAO) {
		this.tipoSolicitudDAO = tipoSolicitudDAO;
	}
	
	/**
	 * Hacer seguimiento de fecha limite para responder una solicitud
	 * TERMINAR!!
	 * @return
	 */
	/*public List<Solicitud> seguimientoSolicitudes(){
		List<Solicitud> solicitudesAtrasadas=new ArrayList<Solicitud>();
		List<Solicitud> solicitudes;
		int dias=0;
		int dia;
		int mes;
		int anio;
		Date fechaSolicitud;
		
		
		solicitudes=solicitudDAO.obtenerSolicitud();
		
		for(Solicitud solicitud:solicitudes){
			
			
		}
		return solicitudesAtrasadas;
		
	}*/

	
}
