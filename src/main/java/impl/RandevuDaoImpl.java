package impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.RandevuDao;
import main.DbOperations;
import model.Doktor;
import model.Randevu;

public class RandevuDaoImpl implements RandevuDao{

	public void save(Randevu randevu) {
		
		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		session.save(randevu);

		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
		
	}

	public void delete(Randevu randevu) {
		// TODO Auto-generated method stub
		
	}

	public void update(Randevu randevu) {
		// TODO Auto-generated method stub
		
	}

	public Randevu findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Randevu> findAll() {
		
		SessionFactory sessionFactory = DbOperations.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Query query = (Query) session.createQuery("from Randevu "); 
		
		List<Randevu> list = query.list();
		
		return list;
		
	}

}
