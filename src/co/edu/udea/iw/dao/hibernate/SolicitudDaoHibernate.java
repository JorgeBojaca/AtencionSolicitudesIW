package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.SolicitudDao;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.ExceptionDao;

/**
 * Implementación de la interfaz SolicitudDao, 
 * esta se basara en Hibernate,
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
public class SolicitudDaoHibernate extends HibernateDaoSupport implements SolicitudDao{

	@Override
	public void guardar(Solicitud solicitud) throws ExceptionDao {
		Session session = null;
		
		try {
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(solicitud);			
		} catch (HibernateException e) {
			throw new ExceptionDao(e);
		}
		
	}

	@Override
	public Solicitud actualizar(Solicitud solicitud) throws ExceptionDao {
			Session session = null;
		
		try {
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.update(solicitud);
		} catch (HibernateException e) {
			throw new ExceptionDao(e);
		}
		return solicitud;
	}

	@Override
	public List<Solicitud> obtenerSolicitud() throws ExceptionDao {
		List<Solicitud> solicitudes = new ArrayList<Solicitud>();
		Session session = null;
		
		try {
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Solicitud.class);
			solicitudes = criteria.list();
		} catch (HibernateException e) {
			throw new ExceptionDao(e);
		}
		return solicitudes;
	}

	@Override
	public Solicitud obtenerSolicitud(int id) throws ExceptionDao {
		Solicitud solicitud;
		Session session;
		try {
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			solicitud = (Solicitud)session.get(Solicitud.class, id);
		} catch (HibernateException e) {
			throw new ExceptionDao(e);
		}
		return solicitud;
	}	
	
}
