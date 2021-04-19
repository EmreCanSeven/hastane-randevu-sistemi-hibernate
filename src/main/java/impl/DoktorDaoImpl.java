package impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.DoktorDao;
import main.DbOperations;
import model.Doktor;

public class DoktorDaoImpl implements DoktorDao{

	public void save(Doktor doktor) {
		
		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		session.save(doktor);

		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
		
		
	}

	public void delete(Doktor doktor) {
		
		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		session.delete(doktor);

		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
		
	}

	public void update(Doktor doktor) {
		
		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		
		session.update(doktor);

		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
		
	}

	public Doktor findById(Long id) {
		
		Doktor doktor = new Doktor();

		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Doktor.class);

		criteria.add(Restrictions.eq("id", id));
		
		List<Doktor> doktorList = criteria.list();
		
		doktor =  (Doktor) doktorList.get(0);

		return doktor;
	}

	public List<Doktor> findByDogumYeri(String dogumYeri) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Doktor> findAll() {
		
		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Query query = (Query) session.createQuery("from Doktor "); 
		
		List<Doktor> list = query.list();
		
		return list;
		
	}
	
	public Doktor findByAdi(String adi) {
		
		Doktor doktor = new Doktor();

		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Doktor.class);

		criteria.add(Restrictions.eq("adi", adi));
		
		List<Doktor> doktorList = criteria.list();
		
		doktor =  (Doktor) doktorList.get(0);

		return doktor;
		
	}

}
