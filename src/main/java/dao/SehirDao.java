package dao;

import java.util.List;

import model.Doktor;
import model.Sehir;

public interface SehirDao {
	
	void save(Sehir sehir);
	
	void delete(Sehir sehir);
	
	void update(Sehir sehir);
	
	Sehir findById(Long id); 
	
	List<Sehir> findByDogumYeri(String dogumYeri);
	
	List<Sehir> findAll();

}
