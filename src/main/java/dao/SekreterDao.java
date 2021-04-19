package dao;

import java.util.List;

import model.Doktor;
import model.Sekreter;

public interface SekreterDao extends GenericDao<Sekreter>{
	
	void save(Sekreter sekreter);
	
	void delete(Sekreter sekreter);
	
	void update(Sekreter sekreter);
	
	Sekreter findById(Long id); 
	
	List<Sekreter> findByDogumYeri(String dogumYeri);
	
	List<Sekreter> findAll();

}
