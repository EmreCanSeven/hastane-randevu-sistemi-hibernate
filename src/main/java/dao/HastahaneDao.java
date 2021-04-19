package dao;

import java.util.List;

import model.Hastahane;

public interface HastahaneDao extends GenericDao<Hastahane>{
	
	void save(Hastahane hastahane);
	
	void delete(Hastahane hastahane);
	
	void update(Hastahane hastahane);
	
	Hastahane findById(Long id); //id g�ndereiyorum, bana urunu   gönderiyor.
	
	List<Hastahane> findAll();

}
