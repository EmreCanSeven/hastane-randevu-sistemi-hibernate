package impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.SehirDao;
import model.Doktor;
import model.Sehir;
import util.SessionHelper;

public class SehirDaoImpl implements SehirDao{

	public void save(Sehir sehir) {
		
		SessionFactory sessionFactory = SessionHelper.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		session.save(sehir);

		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
		
		
	}

	public void delete(Sehir sehir) {
		
		SessionFactory sessionFactory = SessionHelper.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		session.delete(sehir);

		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
		
	}

	public void update(Sehir sehir) {
		
		SessionFactory sessionFactory = SessionHelper.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		
		session.update(sehir);

		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
		
	}

	public Sehir findById(Long id) {
		
		Sehir sehir = new Sehir();

		SessionFactory sessionFactory = SessionHelper.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Sehir.class);

		criteria.add(Restrictions.eq("id", id));
		
		List<Sehir> sehirList = criteria.list();
		
		sehir =  (Sehir) sehirList.get(0);

		return sehir;
		
	}

	public List<Sehir> findByDogumYeri(String dogumYeri) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Sehir> findAll() {
		
		SessionFactory sessionFactory = SessionHelper.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Query query = (Query) session.createQuery("from Sehir "); 
		
		List<Sehir> list = query.list();
		
		return list;
	}
	
	public Sehir findByAdi(String adi) {
		
		Sehir sehir = new Sehir();

		SessionFactory sessionFactory = SessionHelper.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Sehir.class);

		criteria.add(Restrictions.eq("adi", adi));
		
		List<Sehir> sehirList = criteria.list();
		
		sehir =  (Sehir) sehirList.get(0);

		return sehir;
		
	}


}
