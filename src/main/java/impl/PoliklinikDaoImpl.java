package impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.PoliklinikDao;
import model.Poliklinik;
import util.SessionHelper;

public class PoliklinikDaoImpl implements PoliklinikDao{

	public void save(Poliklinik poliklinik) {
		
		SessionFactory sessionFactory = SessionHelper.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		session.save(poliklinik);

		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
	}

	public void delete(Poliklinik poliklinik) {
		// TODO Auto-generated method stub
		
	}

	public void update(Poliklinik poliklinik) {
		// TODO Auto-generated method stub
		
	}

	public Poliklinik findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Poliklinik> findAll() {
		
		SessionFactory sessionFactory = SessionHelper.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Query query = (Query) session.createQuery("from Poliklinik "); 
		
		List<Poliklinik> list = query.list();
		
		return list;
		
	}
	
	public Poliklinik findByAdi(String adi) {
		
		Poliklinik poliklinik = new Poliklinik();

		SessionFactory sessionFactory = SessionHelper.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Poliklinik.class);

		criteria.add(Restrictions.eq("adi", adi));

		poliklinik =  (Poliklinik) criteria.list().get(0);

		return poliklinik;
		
	}	

}
