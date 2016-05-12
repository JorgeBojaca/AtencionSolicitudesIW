package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionDao;

/**
 * DAO Interfaz que define los metodos que va a proveer la clase usuario.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
public interface UsuarioDao {

	/**
	 * Registrar un nuevo usuario en la tabla Usuario.
	 * 
	 * @param usuario
	 *            registro de usuario que se guardará en la tabla Usuario.
	 * @return Usuario guardado.
	 * @throws ExceptionDao
	 *             cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public Usuario guardar(Usuario usuario) throws ExceptionDao;

	/**
	 * Actualizar la informacion del usuario en la tabla Usuario.
	 * 
	 * @param usuario
	 *            registro que contiene la informacion del usuario que se va a
	 *            actualizar.
	 * @return Usuario actualizado.
	 * @throws ExceptionDao
	 *             cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public Usuario actualizar(Usuario usuario) throws ExceptionDao;

	/**
	 * Obtener la lista de usuarios almacenados en la tabla Usuario de la base
	 * de datos.
	 * 
	 * @return lista de Usuarios.
	 * @throws ExceptionDao
	 *             cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public List<Usuario> obtenerUsuarios() throws ExceptionDao;

	/**
	 * Obtiene el Usuario que corresponda al user ingresado como parámetro.
	 * 
	 * @param user
	 *            identificador del usuario.
	 * @return Usuario con toda su información.
	 * @throws ExceptionDao
	 *             cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public Usuario obtenerUsuario(String user) throws ExceptionDao;

}
