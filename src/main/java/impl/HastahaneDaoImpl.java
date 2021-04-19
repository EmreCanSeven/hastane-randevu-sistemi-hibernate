package impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.HastahaneDao;
import main.DbOperations;
import model.Doktor;
import model.Hastahane;
import model.Sehir;

public class HastahaneDaoImpl implements HastahaneDao{

	public void save(Hastahane hastahane) {
		
		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		session.save(hastahane);

		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
		
	}

	public void delete(Hastahane hastahane) {

		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		session.delete(hastahane);

		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
		
	}

	public void update(Hastahane hastahane) {

		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		
		session.update(hastahane);

		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
		
	}

	public Hastahane findById(Long id) {
		
		Hastahane hastahane = new Hastahane();

		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Hastahane.class);

		criteria.add(Restrictions.eq("id", id));
		
		List<Hastahane> hastahaneList = criteria.list();
		
		hastahane =  (Hastahane) hastahaneList.get(0);

		return hastahane;
		
	}
	
	public Hastahane findByAdi(String adi) {
		
		Hastahane hastahane = new Hastahane();

		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Hastahane.class);

		criteria.add(Restrictions.eq("adi", adi));

		hastahane =  (Hastahane) criteria.list().get(0);

		return hastahane;
		
	}

	public List<Hastahane> findAll() {
		
		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Query query = (Query) session.createQuery("from Hastahane "); 
		
		List<Hastahane> list = query.list();
		
		return list;
		
		
	}
	
	public List<Hastahane> findHastahaneBySehir(Sehir sehir){
		
		List<Hastahane> geriDonenHastahaneList = new ArrayList<Hastahane>();

		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Hastahane.class);

		criteria.add(Restrictions.eq("sehir", sehir));

		geriDonenHastahaneList = criteria.list();
		
		return geriDonenHastahaneList;
		
		
	}
	
	
	

}
