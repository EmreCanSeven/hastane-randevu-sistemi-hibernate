package dao;

import java.util.List;

import model.Poliklinik;

public interface PoliklinikDao extends GenericDao<Poliklinik>{
	

	void save(Poliklinik poliklinik);
	
	void delete(Poliklinik poliklinik);
	
	void update(Poliklinik poliklinik);
	
	Poliklinik findById(Long id); //id g�ndereiyorum, bana urunu   gönderiyor.
	
	List<Poliklinik> findAll();

}
