package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.exception.ExceptionDao;

/**
 * DAO Interfaz que define los metodos que 
 * va a proveer el la clase Rol.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
public interface RolDao {

	/**
	 * Obtiene la lista de roles almacenados en la tabla Rol de la base
	 * de datos.
	 * 
	 * @return lista de roles.
	 * @throws ExceptionDao cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public List<Rol> obtenerRoles() throws ExceptionDao;

	/**
	 * Obtiene el rol que corresponda al identificador ingresado como
	 * parámetro.
	 * 
	 * @param id identificador del rol.
	 * @return Rol con toda su información.
	 * @throws ExceptionDao cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public Rol obtenerRol(Integer id) throws ExceptionDao;

}
