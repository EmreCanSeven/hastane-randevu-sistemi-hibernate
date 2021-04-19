package model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enums.Cinsiyet;

@Entity
@Table(name = "DOKTOR",  schema = "hrs")
public class Doktor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //AUTO_ÝNCREEMNET ==> GENRATED VALUE
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "TCKN", unique = true, nullable = false, length = 11)
	private String tckn;

	@Column(name = "ADI", nullable = false, length = 100)
	private String adi;

	@Column(name = "SOYADI", nullable = false, length = 100)	
	private String soyadi;

	//TODO : transient i kaldýr, cinsiyeti enum olarak anotasyon(annotation) ekle ... 

	@Column(name = "CINSIYET", nullable = false)
	@Enumerated(EnumType.STRING) 
	private Cinsiyet cinsiyet;

	@Column(name = "DOGUM_YERI", nullable = false, length = 100)
	private String dogumYeri;

	
	@Column(name = "DOGUM_TARIHI", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dogumTarihi;

	@Column(name = "CEP_TEL", nullable = false, length = 30)
	private String cepTel;

	@Column(name = "EPOSTA", nullable = true, length = 100)
	private String ePosta;

	@ManyToOne
	@JoinColumn(name="Poliklinik")
	private Poliklinik poliklinik;

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
	public String getePosta() {
		return ePosta;
	}
	public void setePosta(String ePosta) {
		this.ePosta = ePosta;
	}
	public Poliklinik getPoliklinik() {
		return poliklinik;
	}
	public void setPoliklinik(Poliklinik poliklinik) {
		this.poliklinik = poliklinik;
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
