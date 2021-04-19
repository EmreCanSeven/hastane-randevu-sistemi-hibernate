package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name = "RANDEVU",  schema = "hrs")
public class Randevu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //AUTO_ÝNCREEMNET ==> GENRATED VALUE
	@Column(name = "ID", unique = true, nullable = false)
	private long id;
	
//	@Column(name = "DOKTOR_ID", nullable = false)
	@OneToOne(fetch = FetchType.LAZY)
	private Doktor doktor;
	
//	@Column(name = "HASTA_ID", nullable = false)
	@OneToOne(fetch = FetchType.LAZY)
	private Hasta hasta;
	
//	@Column(name = "HASTAHANE_ID", nullable = false)
	@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private Hastahane hastahane;
	
//	@Column(name = "POLIKLINIK_ID", nullable = false)
	@OneToOne(fetch = FetchType.LAZY)
	private Poliklinik poliklinik;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date randevuTarihi;
	
	
	public long getId() {
		return id;
	}
	public Doktor getDoktor() {
		return doktor;
	}
	public Hasta getHasta() {
		return hasta;
	}
	public Hastahane getHastahane() {
		return hastahane;
	}
	public Poliklinik getPoliklinik() {
		return poliklinik;
	}
	public Date getRandevuTarihi() {
		return randevuTarihi;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public void setDoktor(Doktor doktor) {
		this.doktor = doktor;
	}
	public void setHasta(Hasta hasta) {
		this.hasta = hasta;
	}
	public void setHastahane(Hastahane hastahane) {
		this.hastahane = hastahane;
	}
	public void setPoliklinik(Poliklinik poliklinik) {
		this.poliklinik = poliklinik;
	}
	public void setRandevuTarihi(Date randevuTarihi) {
		this.randevuTarihi = randevuTarihi;
	}

}
