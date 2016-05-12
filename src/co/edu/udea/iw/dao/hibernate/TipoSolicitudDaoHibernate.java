package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.TipoSolicitudDao;
import co.edu.udea.iw.dto.TipoSolicitud;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionDao;

/**
 * Implementación de la interfaz TipoSolicitudDao, 
 * esta se basara en Hibernate,
 * en esta clase se hereda de HibernateDaoSupport 
 * para adquirir la funcionalidad de Hibernate.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
public class TipoSolicitudDaoHibernate extends HibernateDaoSupport implements TipoSolicitudDao{

	@Override
	public List<TipoSolicitud> obtenerTipoSolicitudes() throws ExceptionDao {
		List<TipoSolicitud> tiposolicitudes = new ArrayList<TipoSolicitud>();
		Session session = null;
		
		try {
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(TipoSolicitud.class);
			tiposolicitudes = criteria.list();
		} catch (DataAccessException e) {
			throw new ExceptionDao(e);
		}
		return tiposolicitudes;
	}

	@Override
	public TipoSolicitud obtenerTipoSolicitud(Integer id) throws ExceptionDao {
		TipoSolicitud tiposolicitud;
		Session session;
		try {
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			tiposolicitud = (TipoSolicitud)session.get(TipoSolicitud.class, id);
		} catch (DataAccessException e) {
			throw new ExceptionDao(e);
		}
		return tiposolicitud;
	}

}
