package impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.HastaDao;
import main.DbOperations;
import model.Hasta;

public class HastaDaoImpl implements HastaDao{

	public void save(Hasta hasta) {
		
		
		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		session.save(hasta);
		
		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
		
	}

	public void delete(Hasta hasta) {
		// TODO Auto-generated method stub
		
	}

	public void update(Hasta hasta) {
		
		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		session.update(hasta);

		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
		
	}

	public Hasta findById(Long id) {
		
		Hasta hasta = new Hasta();

		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Hasta.class);

		criteria.add(Restrictions.eq("id", id));

		hasta =  (Hasta) criteria.list().get(0);
		
		return hasta;
		
	}

	public List<Hasta> findAll(){
		
		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Query query = (Query) session.createQuery("from Hasta "); 
		
		List<Hasta> list = query.list();
		
		return list;
		
	}
	
	public Hasta findByAdi(String adi) {
		
		Hasta hasta = new Hasta();

		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Hasta.class);

		criteria.add(Restrictions.eq("adi", adi));

		hasta =  (Hasta) criteria.list().get(0);

		return hasta;
		
	}

}
