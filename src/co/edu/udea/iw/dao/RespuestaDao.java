package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.PkRespuesta;
import co.edu.udea.iw.dto.Respuesta;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.ExceptionDao;

public interface RespuestaDao {
	
	public void guardarRespuesta(Respuesta respuesta) throws ExceptionDao;
	public List<Respuesta> obtenerRespuestas(Integer solicitud) throws ExceptionDao;
	public List<Respuesta> obtenerRespuestasP(Integer pregunta) throws ExceptionDao;
	public Respuesta obtenerRespuesta(PkRespuesta id)throws ExceptionDao;

}
