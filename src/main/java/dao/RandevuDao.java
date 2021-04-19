package dao;

import model.Randevu;

public interface RandevuDao extends GenericDao<Randevu>{

	void save(Randevu randevu);
	
	void delete(Randevu randevu);
	
	void update(Randevu randevu);
	
	Randevu findById(Long id); //id g�ndereiyorum, bana urunu   gönderiyor.

}
