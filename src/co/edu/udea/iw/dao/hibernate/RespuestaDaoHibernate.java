package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.RespuestaDao;
import co.edu.udea.iw.dto.PkRespuesta;
import co.edu.udea.iw.dto.Respuesta;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.ExceptionDao;

public class RespuestaDaoHibernate extends HibernateDaoSupport implements RespuestaDao {

	@Override
	public void guardarRespuesta(Respuesta respuesta) throws ExceptionDao {
		Session session;
		try{
		session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.save(respuesta);
		}catch(HibernateException e){
			throw new ExceptionDao(e);
		}
		
	}

	@Override
	public List<Respuesta> obtenerRespuestas(Integer solicitud) throws ExceptionDao {
		Session session;
		List<Respuesta> respuestas=null;
		
		try {
			session=getHibernateTemplate().getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM respuesta WHERE idsolicitud= :solicitud");
			query.addEntity(Respuesta.class);
			query.setParameter("solicitud", solicitud);
			respuestas=query.list();
		} catch (HibernateException e) {
			throw new ExceptionDao(e);
		}
		return respuestas;
	}
	
	

	@Override
	public List<Respuesta> obtenerRespuestasP(Integer pregunta) throws ExceptionDao {
		Session session;
		List<Respuesta> respuestas=null;
		
		try {
			session=getHibernateTemplate().getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM respuesta WHERE idpregunta= :pregunta");
			query.addEntity(Respuesta.class);
			query.setParameter("pregunta", pregunta);
			respuestas=query.list();
		} catch (HibernateException e) {
			throw new ExceptionDao(e);
		}
		return respuestas;
	}

	@Override
	public Respuesta obtenerRespuesta(PkRespuesta id) throws ExceptionDao {
		Session session;
		Respuesta respuesta;
		try{
		session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		respuesta= (Respuesta)session.get(Respuesta.class,id);
		}catch(HibernateException e){
			throw new ExceptionDao(e);
		}
		return respuesta;
	}
	

}
