package dao;

import java.util.List;

import model.Doktor;

public interface DoktorDao extends GenericDao<Doktor>{
	
	void save(Doktor doktor);
	
	void delete(Doktor doktor);
	
	void update(Doktor doktor);
	
	Doktor findById(Long id); 
	
	List<Doktor> findByDogumYeri(String dogumYeri);
	
	List<Doktor> findAll();
	
}