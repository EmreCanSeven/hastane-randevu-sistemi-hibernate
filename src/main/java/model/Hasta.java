package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import enums.Cinsiyet;

@Entity
@Table(name = "HASTA",  schema = "hrs")
public class Hasta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //AUTO_ÝNCREEMNET ==> GENRATED VALUE
	@Column(name = "ID", unique = true, nullable = false)
	private long id;

	@Column(name = "TCKN", unique = true, nullable = false, length = 11)
	private String tckn;

	@Column(name = "ADI", nullable = false, length = 100)
	private String adi;

	@Column(name = "SOYADI", nullable = false, length = 100)	
	private String soyadi;

	@Column(name = "CINSIYET", nullable = true)
	@Enumerated(EnumType.STRING)                     /** Enum larý map ederken bnun gibi yap.. */
//	@Transient
	private Cinsiyet cinsiyet;

	@Column(name = "DOGUM_YERI", nullable = false, length = 100)
	private String dogumYeri;

	@Column(name = "DOGUM_TARIHI", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dogumTarihi;

	@Column(name = "CEP_TEL", nullable = false, length = 30)
	private String cepTel;

	@Column(name = "BABA_ADI", nullable = false, length = 100)
	private String babaAdi;

	@Column(name = "ANNE_ADI", nullable = false, length = 100)
	private String anneAdi;
	
	@Column(name = "CREATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "UPDATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTckn() {
		return tckn;
	}
	public void setTckn(String tckn) {
		this.tckn = tckn;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getSoyadi() {
		return soyadi;
	}
	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}
	public Cinsiyet getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(Cinsiyet cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	public String getDogumYeri() {
		return dogumYeri;
	}
	public void setDogumYeri(String dogumYeri) {
		this.dogumYeri = dogumYeri;
	}
	public Date getDogumTarihi() {
		return dogumTarihi;
	}
	public void setDogumTarihi(Date dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}
	public String getCepTel() {
		return cepTel;
	}
	public void setCepTel(String cepTel) {
		this.cepTel = cepTel;
	}
	public String getBabaAdi() {
		return babaAdi;
	}
	public void setBabaAdi(String babaAdi) {
		this.babaAdi = babaAdi;
	}
	public String getAnneAdi() {
		return anneAdi;
	}
	public void setAnneAdi(String anneAdi) {
		this.anneAdi = anneAdi;
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

}
