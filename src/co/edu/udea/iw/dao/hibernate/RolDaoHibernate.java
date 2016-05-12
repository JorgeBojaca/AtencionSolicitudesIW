package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.RolDao;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.exception.ExceptionDao;

/**
 * Implementación de la interfaz RolDao, 
 * esta se basara en Hibernate,
 * en esta clase se hereda de HibernateDaoSupport 
 * para adquirir la funcionalidad de Hibernate.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
public class RolDaoHibernate extends HibernateDaoSupport implements RolDao{

	@Override
	public List<Rol> obtenerRoles() throws ExceptionDao {
		List<Rol> roles = new ArrayList<Rol>();
		Session session = null;
		
		try {
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Rol.class);
			roles = criteria.list();
		} catch (HibernateException e) {
			throw new ExceptionDao(e);
		}
		return roles;
	}

	@Override
	public Rol obtenerRol(Integer id) throws ExceptionDao {
		Rol rol=null;
		Session session=null;
		try {
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			rol = (Rol)session.get(Rol.class, id);
		} catch (HibernateException e) {
			throw new ExceptionDao(e);
		}
		return rol;
	}

}
