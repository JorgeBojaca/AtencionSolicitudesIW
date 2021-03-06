package co.edu.udea.iw.logicaNegocio;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.RolDao;
import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionDao;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.validation.Validaciones;

/**
 * Clase encargada de la logica de negocio para la clase Usuario. Clase
 * transaccional con la BD.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
@Transactional // Anotacion requerida para informarle a Spring que esta clase
				// manejar� transacciones
public class UsuarioService {

	/**
	 * Beans para manejar los DaoHibernate
	 */
	private UsuarioDao usuarioDAO; //comentar
	private RolDao rolDAO;

	/**
	 * Metodo para guardar la informacion ingresada por el cliente.
	 * 
	 * @param user
	 *            identificador del cliente
	 * @param password
	 *            contrasenia del cliente
	 * @param nombres
	 *            nombre del cliente
	 * @param apellidos
	 *            apellidos del cliente
	 * @param email
	 *            email del cliente
	 * @param telefono
	 *            telefono del cliente
	 * @param direccion
	 *            direccion del cliente
	 * @throws ExceptionDao
	 *             Manejar las excepciones del DAO.
	 * @throws IWServiceException
	 *             Manejar las excepciones de la lógica del negocio.
	 */
	public String guardarCliente(String user, String password, String nombres, String apellidos, String email,
			String telefono, String direccion) throws ExceptionDao, IWServiceException {

		Usuario usuario = null;
		Rol rol = null;

		if (Validaciones.isTextoVacio(user)) {
			throw new IWServiceException(
					"El campo user del cliente no puede ser nulo, ni una cadena de caracteres vacia");
		}

		if (Validaciones.isTextoVacio(password)) {
			throw new IWServiceException(
					"El campo password del cliente no puede ser nulo, ni una cadena de caracteres vacia");
		}

		if (Validaciones.isTextoVacio(nombres)) {
			throw new IWServiceException(
					"El campo nombres del cliente no puede ser nulo, ni una cadena de caracteres vacia");
		}

		if (Validaciones.isTextoVacio(apellidos)) {
			throw new IWServiceException(
					"El campo apellidos del cliente no puede ser nulo, ni una cadena de caracteres vacia");
		}

		if (Validaciones.isTextoVacio(email)) {
			throw new IWServiceException(
					"El campo email del cliente no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if (!Validaciones.isEmail(email)) { // SI NO ES UN CORREO MANDAR LA
											// EXCEPTION
			throw new IWServiceException("El correo electronico del cliente debe ser valido");
		}

		if (Validaciones.isTextoVacio(telefono)) {
			throw new IWServiceException(
					"El campo telefono del cliente no puede ser nulo, ni una cadena de caracteres vacia");
		}

		if (Validaciones.isTextoVacio(direccion)) {
			throw new IWServiceException(
					"El campo direccion del cliente no puede ser nulo, ni una cadena de caracteres vacia");
		}

		// El cliente no puede existir
		if (usuarioDAO.obtenerUsuario(user) != null) {
			throw new IWServiceException("Ya existe un cliente con usuario " + user + " en el sistema");
		}

		usuario = new Usuario();
		rol = rolDAO.obtenerRol(3); // Se obtiene el Rol con id=3 que identifica
									// a un CLIENTE

		usuario.setUser(user);
		usuario.setPassword(password);
		usuario.setNombres(nombres);
		usuario.setApellidos(apellidos);
		usuario.setEmail(email);
		usuario.setTelefono(telefono);
		usuario.setDireccion(direccion);
		usuario.setRol(rol);

		usuarioDAO.guardar(usuario);
		return "Se ha creado un " + rol.getNombre() + " exitosamente";

	}

	/**
	 * Metodo para modificar los campos de un cliente
	 * 
	 * @param user
	 *            identificador del cliente
	 * @param password
	 *            contrasenia del cliente
	 * @param nombres
	 *            nombres del cliente
	 * @param apellidos
	 *            apellidos del cliente
	 * @param email
	 *            correo electronico del cliente
	 * @param telefono
	 *            telefono del cliente
	 * @param direccion
	 *            direccion del cliente
	 * @throws ExceptionDao
	 *             Manejar las excepciones del DAO.
	 * @throws IWServiceException
	 *             Manejar las excepciones de la lógica del negocio.
	 */
	public String actualizarCliente(String user, String password, String nombres, String apellidos, String email,
			String telefono, String direccion) throws ExceptionDao, IWServiceException {

		Usuario usuario = null;
		Rol rol = null;

		if (Validaciones.isTextoVacio(user)) {
			throw new IWServiceException(
					"El campo user del cliente no puede ser nulo, ni una cadena de caracteres vacia");
		}

		if (Validaciones.isTextoVacio(password)) {
			throw new IWServiceException(
					"El campo password del cliente no puede ser nulo, ni una cadena de caracteres vacia");
		}

		if (Validaciones.isTextoVacio(nombres)) {
			throw new IWServiceException(
					"El campo nombres del cliente no puede ser nulo, ni una cadena de caracteres vacia");
		}

		if (Validaciones.isTextoVacio(apellidos)) {
			throw new IWServiceException(
					"El campo apellidos del cliente no puede ser nulo, ni una cadena de caracteres vacia");
		}

		if (Validaciones.isEmail(email)) {
			throw new IWServiceException("El correo electronico del cliente debe ser valido");
		}

		if (Validaciones.isTextoVacio(telefono)) {
			throw new IWServiceException(
					"El campo telefono del cliente no puede ser nulo, ni una cadena de caracteres vacia");
		}

		if (Validaciones.isTextoVacio(direccion)) {
			throw new IWServiceException(
					"El campo direccion del cliente no puede ser nulo, ni una cadena de caracteres vacia");
		}
		// No importa que el cliente exista
		if (usuarioDAO.obtenerUsuario(user) == null) {
			throw new IWServiceException("No existe el cliente con usuario: " + user + " en el sistema");
		}

		usuario = new Usuario();
		rol = rolDAO.obtenerRol(3);// Obtener el rol con id=3 que representa a
									// un CLIENTE

		usuario.setUser(user);
		usuario.setPassword(password);
		usuario.setNombres(nombres);
		usuario.setApellidos(apellidos);
		usuario.setEmail(email);
		usuario.setTelefono(telefono);
		usuario.setDireccion(direccion);
		usuario.setRol(rol);
		System.out.println(rol.getNombre());

		usuarioDAO.actualizar(usuario);

		return "Se ha actualizado exitosamente";

	}

	/**
	 * Metodo para verificar el usuario y contrasenia con la base de datos
	 * 
	 * @param user
	 *            identificador del usuario
	 * @param password
	 *            contrasenia del usuario
	 * @return Usuario
	 * @throws ExceptionDao
	 *             Manejar las excepciones del DAO.
	 * @throws IWServiceException
	 *             Manejar las excepciones de la lógica del negocio.
	 */
	public Usuario autenticarUsuario(String user, String password) throws ExceptionDao, IWServiceException {

		Usuario usuario = null;
		usuario = usuarioDAO.obtenerUsuario(user);

		if (usuario == null) {
			throw new IWServiceException("No existe el cliente con usuario: " + user + " en el sistema");
		}

		if (!usuario.getPassword().equals(password)) {
			throw new IWServiceException("La contrasennia es incorrecta");
		}
		return usuario;

	}

	/**
	 * Metodo para obtener el listado de usuarios
	 * 
	 * @return Lista de usuarios
	 * @throws ExceptionDao
	 *             Manejar las excepciones del DAO.
	 */
	public List<Usuario> obtener() throws ExceptionDao {
		return usuarioDAO.obtenerUsuarios();
	}

	/**
	 * Metodo para obtener el usuario del identificador enviado como parametro
	 * 
	 * @param user
	 *            identificador del usuario
	 * @return Usuario
	 * @throws ExceptionDao
	 *             Manejar las excepciones del DAO.
	 * @throws IWServiceException
	 *             Manejar las excepciones de la logica de negocio.
	 */
	public Usuario obtener(String user) throws ExceptionDao, IWServiceException {
		if (user == null && "".equals(user)) {
			throw new IWServiceException(
					"El campo user del cliente no puede ser nulo, ni una cadena de caracteres vacia");
		}

		return usuarioDAO.obtenerUsuario(user);
	}

	public UsuarioDao getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDao usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public RolDao getRolDAO() {
		return rolDAO;
	}

	public void setRolDAO(RolDao rolDAO) {
		this.rolDAO = rolDAO;
	}

}
