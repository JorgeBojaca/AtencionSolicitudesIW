package co.edu.udea.iw.dto;

/**
 * DTO
 * Clase para manejar la tabla Usuario
 * de la Base de Datos atencionSolicitudes.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca  
 * @version 1.0
 */
public class Usuario {
	
	private String user; //PK
	private String password;
	private String nombres;
	private String apellidos;
	private String email;
	private String telefono;
	private String direccion;
	private Rol rol; //FK
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Rol getRol() {
		return rol;
	}
	
	public void setRol(Rol rol) {
		this.rol = rol;
	}	
}
