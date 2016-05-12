package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import co.edu.udea.iw.dao.PreguntaDao;
import co.edu.udea.iw.dto.Pregunta;
import co.edu.udea.iw.exception.ExceptionDao;

/**
 * Implementación de la interfaz PreguntaDao, 
 * esta se basara en Hibernate,
 * en esta clase se hereda de HibernateDaoSupport 
 * para adquirir la funcionalidad de Hibernate.
 * 
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
public class PreguntaDaoHibernate extends HibernateDaoSupport implements PreguntaDao {

	@Override
	public List<Pregunta> obtenerPreguntas() throws ExceptionDao {
		List<Pregunta> preguntas = new ArrayList<Pregunta>();
		Session session = null;
		
		try {
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Pregunta.class);
			preguntas = criteria.list();
		} catch (DataAccessException e) {
			throw new ExceptionDao(e);
		}
		return preguntas;
	}

	@Override
	public Pregunta obtenerPregunta(Integer id) throws ExceptionDao {
		Pregunta pregunta;
		Session session;
		try {
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			pregunta = (Pregunta)session.get(Pregunta.class, id);
		} catch (DataAccessException e) {
			throw new ExceptionDao(e);
		}
		return pregunta;
	}

}
