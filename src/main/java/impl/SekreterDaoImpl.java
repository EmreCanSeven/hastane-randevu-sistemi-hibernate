package impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.SekreterDao;
import model.Doktor;
import model.Sekreter;
import util.SessionHelper;

public class SekreterDaoImpl implements SekreterDao{

	public void save(Sekreter sekreter) {
		
		SessionFactory sessionFactory = SessionHelper.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		session.save(sekreter);
		
		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
		
	}

	public void delete(Sekreter sekreter) {
		
		SessionFactory sessionFactory = SessionHelper.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		session.delete(sekreter);

		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
		
		
	}

	public void update(Sekreter sekreter) {
		
		SessionFactory sessionFactory = SessionHelper.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		
		session.update(sekreter);

		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
		
	}

	public Sekreter findById(Long id) {
		
		
		Sekreter sekreter = new Sekreter();

		SessionFactory sessionFactory = SessionHelper.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Sekreter.class);

		criteria.add(Restrictions.eq("id", id));
		
		List<Sekreter> sekreterList = criteria.list();
		
		sekreter =  (Sekreter) sekreterList.get(0);

		return sekreter;
		
		
		
		
	}

	public List<Sekreter> findByDogumYeri(String dogumYeri) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Sekreter> findAll() {
		
		SessionFactory sessionFactory = SessionHelper.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Query query = (Query) session.createQuery("from Sekreter "); 
		
		List<Sekreter> list = query.list();
		
		return list;
	}

}
