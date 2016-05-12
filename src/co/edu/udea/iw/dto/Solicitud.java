package co.edu.udea.iw.dto;

import java.util.Date;

/**
 * DTO
 * Clase para manejar la Tabla Solicitud.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */

public class Solicitud {
	
	private int id;//PK
	private TipoSolicitud tipoSolicitud;//FK a la tabla Solicitud
	private Usuario cliente;//FK a la tabla usuario
	private String descripcion;
	private String complejidad;
	private Usuario responsable;// FK a la tabla usuario
	private String producto;
	private Sucursal sucursal; //FK a la tabla sucursal
	private Date fechaSolicitud;
	private String respuestaSolicitud;
	private Date fechaRespuesta;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public TipoSolicitud getTipoSolicitud() {
		return tipoSolicitud;
	}
	
	public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	
	public Usuario getCliente() {
		return cliente;
	}
	
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getComplejidad() {
		return complejidad;
	}
	public void setComplejidad(String complejidad) {
		this.complejidad = complejidad;
	}
	
	public Usuario getResponsable() {
		return responsable;
	}
	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
	}
	
	public String getProducto() {
		return producto;
	}
	
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	
	public String getRespuesta() {
		return respuestaSolicitud;
	}
	
	public void setRespuesta(String respuesta) {
		this.respuestaSolicitud = respuesta;
	}
	
	public Date getFechaRespuesta() {
		return fechaRespuesta;
	}
	
	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}
}
