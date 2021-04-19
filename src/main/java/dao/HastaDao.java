package dao;

import java.util.List;

import model.Hasta;

public interface HastaDao extends GenericDao<Hasta> {
	
	void save(Hasta hasta);
	
	void delete(Hasta hasta);
	
	void update(Hasta hasta);
	
	Hasta findById(Long id); //id g�ndereiyorum, bana urunu   gönderiyor.
	
	List<Hasta> findAll();

}
