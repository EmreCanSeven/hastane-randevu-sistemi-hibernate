package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import enums.HastahaneTipi;

@Entity
@Table(name = "HASTAHANE",  schema = "hrs")
public class Hastahane implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //AUTO_ÝNCREEMNET ==> GENRATED VALUE
	@Column(name = "ID", unique = true, nullable = false)
	private long id;
	
	@Column(name = "ADI", nullable = false)
	private String adi;
	
	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JoinColumn(name="sehir")
	private Sehir sehir;
	
	@Column(name = "HASTAHANE_TIPI", nullable = false)
	@Enumerated(EnumType.STRING)                     /** Enum larý map ederken bnun gibi yap.. */
	private HastahaneTipi hastahaneTipi;
	
	
	@Column(name = "CREATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "UPDATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
//	private Poliklinik poliklinik;
	
//	private List<Poliklinik> poliklinikList;
//	@OneToMany(cascade=CascadeType.ALL)
//	private Doktor doktor;
//	private SortedSet<CoachGroup> coachGroups = new TreeSet<>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public Sehir getSehir() {
		return sehir;
	}
	public void setSehir(Sehir sehir) {
		this.sehir = sehir;
	}
	public HastahaneTipi getHastahaneTipi() {
		return hastahaneTipi;
	}
	public void setHastahaneTipi(HastahaneTipi hastahaneTipi) {
		this.hastahaneTipi = hastahaneTipi;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
//	public Poliklinik getPoliklinik() {
//		return poliklinik;
//	}
//	public void setPoliklinik(Poliklinik poliklinik) {
//		this.poliklinik = poliklinik;
//	}
	
	
	
//	public Doktor getDoktor() {
//		return doktor;
//	}
//	public void setDoktor(Doktor doktor) {
//		this.doktor = doktor;
//	}
//	public List<Poliklinik> getPoliklinikList() {
//		return poliklinikList;
//	}
//	public void setPoliklinikList(List<Poliklinik> poliklinikList) {
//		this.poliklinikList = poliklinikList;
//	}

}
