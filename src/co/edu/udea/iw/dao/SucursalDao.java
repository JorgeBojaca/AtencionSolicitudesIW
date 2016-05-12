package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Sucursal;
import co.edu.udea.iw.exception.ExceptionDao;

/**
 * DAO Interfaz que define los metodos que va a 
 * proveer  la clase Sucursal.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
public interface SucursalDao {

	/**
	 * Obtiene la lista de sucursales almacenadas en la tabla
	 * Sucursal de la base de datos.
	 * 
	 * @return lista de las sucursales.
	 * @throws ExceptionDao cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public List<Sucursal> obtenerSucursales() throws ExceptionDao;

	/**
	 * Obtiene la sucursal que corresponda al identificador ingresado como parámetro.
	 * 
	 * @param id identificador de la sucursal.
	 * @return Sucursal con toda su información.
	 * @throws ExceptionDao cuando ocurre cualquier error en la comunicación con la BD.
	 */
	public Sucursal obtenerSucursal(Integer id) throws ExceptionDao;

}
