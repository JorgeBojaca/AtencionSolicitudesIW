package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.SucursalDao;
import co.edu.udea.iw.dto.Sucursal;
import co.edu.udea.iw.dto.TipoSolicitud;
import co.edu.udea.iw.exception.ExceptionDao;

/**
 * Implementación de la interfaz SucursalDao, 
 * esta se basara en Hibernate,
 * en esta clase se hereda de HibernateDaoSupport 
 * para adquirir la funcionalidad de Hibernate.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
public class SucursalDaoHibernate extends HibernateDaoSupport implements SucursalDao {

	@Override
	public List<Sucursal> obtenerSucursales() throws ExceptionDao {
		List<Sucursal> sucursales = new ArrayList<Sucursal>();
		Session session = null;
		
		try {
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Sucursal.class);
			sucursales = criteria.list();
		} catch (DataAccessException e) {
			throw new ExceptionDao(e);
		}
		return sucursales;
	}

	@Override
	public Sucursal obtenerSucursal(Integer id) throws ExceptionDao {
		Sucursal sucursal;
		Session session;
		try {
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			sucursal = (Sucursal)session.get(Sucursal.class, id);
		} catch (DataAccessException e) {
			throw new ExceptionDao(e);
		}
		return sucursal;
	}

}
