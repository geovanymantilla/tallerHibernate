package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.HibernateSession;
import model.Usuario;

public class UsuarioDao implements GenericDao{

	@Override
	public Usuario selectById(String usuarioId) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		Usuario usuario =(Usuario)session.get(Usuario.class,usuarioId);
		session.close();
		return usuario;
	}

	@Override
	public List<Usuario> selectAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFaactory = HibernateSession.getSessionFactory();
		Session session = sessionFaactory.openSession();
		List<Usuario> usuarios = session.createCriteria(Usuario.class).list();
		session.close();
		return usuarios;
	}

	@Override
	public void insert(Usuario usuario) {
		// TODO Auto-generated method stub
		SessionFactory sessionFaactory = HibernateSession.getSessionFactory();
		Session session = sessionFaactory.openSession();
		session.beginTransaction();
		String id = (String)session.save(usuario);
		usuario.setUsuario(id);
		session.getTransaction().commit();
		session.close();
		
		
	}

	@Override
	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		SessionFactory sessionFaactory = HibernateSession.getSessionFactory();
		Session session = sessionFaactory.openSession();
		session.beginTransaction();
		session.merge(usuario);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub
		SessionFactory sessionFaactory = HibernateSession.getSessionFactory();
		Session session = sessionFaactory.openSession();
		session.beginTransaction();
		session.delete(usuario);
		session.getTransaction().commit();
		session.close();
		
	}

}
