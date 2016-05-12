package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionDao;

/**
 * Implementación de la interfaz UsuarioDao, 
 * esta se basara en Hibernate,
 * en esta clase se hereda de HibernateDaoSupport 
 * para adquirir la funcionalidad de Hibernate.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
public class UsuarioDaoHibernate extends HibernateDaoSupport implements UsuarioDao{

	@Override
	public Usuario guardar(Usuario usuario) throws ExceptionDao {
		
		Session session = null;
		
		try {
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(usuario);			
		} catch (HibernateException e) {
			throw new ExceptionDao(e);
		}
		
		return usuario;
	}

	@Override
	public Usuario actualizar(Usuario usuario) throws ExceptionDao {
		
		Session session = null;
		
		try {
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.update(usuario);
		} catch (HibernateException e) {
			throw new ExceptionDao(e);
		}
		return usuario;
	}

	@Override
	public List<Usuario> obtenerUsuarios() throws ExceptionDao {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Session session = null;
		
		try {
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Usuario.class);
			usuarios = criteria.list();
		} catch (HibernateException e) {
			throw new ExceptionDao(e);
		}
		return usuarios;
	}

	@Override
	public Usuario obtenerUsuario(String user) throws ExceptionDao {
		Usuario usuario;
		Session session;
		try {
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			usuario = (Usuario)session.get(Usuario.class,user);
		} catch (HibernateException e) {
			throw new ExceptionDao(e);
		}
		return usuario;
	}	
}
