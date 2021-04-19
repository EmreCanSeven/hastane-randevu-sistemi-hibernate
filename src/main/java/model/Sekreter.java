package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SEKRETER" , schema = "hrs")
public class Sekreter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String adi;
	private String soyadi;
	private String TCKN;
	private Date createdAt;
	private Date updatedAt;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //AUTO_ÝNCREEMNET ==> GENRATED VALUE
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	
	@Column(name = "ADI", nullable = false, length = 100)
	public String getAdi() {
		return adi;
	}
	@Column(name = "SOYADI", nullable = false, length = 100)
	public String getSoyadi() {
		return soyadi;
	}
	@Column(name = "TCKN", nullable = false, length = 100)
	public String getTCKN() {
		return TCKN;
	}
	
	@Column(name = "CREATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedAt() {
		return createdAt;
	}
	
	
	@Column(name = "UPDATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}
	public void setTCKN(String tCKN) {
		TCKN = tCKN;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

}
