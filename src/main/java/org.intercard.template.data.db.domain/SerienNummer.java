package org.intercard.template.data.db.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.intercard.template.data.db.IEntity;

/**
 * GUIUSER for entity.
 * 
 * @author Vanessa Zimmermann
 * 
 */
@Entity
@Table(name = "SerienNummer")
@NamedQueries({ @NamedQuery(name = "findSerialnumber", query = "SELECT s FROM SerienNummer s") })
public class SerienNummer implements IEntity {

	@Transient
	private static final long serialVersionUID = -9765482747446L;

	@Id
	@Column(name = "SNAnfang")
	private Long snanfang;

	@Column(name = "SNEnde", unique = true)
	private Long snende;

	@Column(name = "Kommentar", nullable = true)
	private String kommentar;

	@Column(name = "vergeben_am")
	private Date vergebenam;

	@Column(name = "Anzahl", nullable = true)
	private Long anzahl;

	@ManyToOne
	private Kunde kunde;

	// +++++++++++++++++++++++++++++++++++++
	public SerienNummer() {

	}

	// ++++++++++++++++++++++++++++++++++++
	// Getter and Setter
	// ++++++++++++++++++++++++++++++++++++

	@Override
	public Long getId() {
		return snanfang;
	}

	public Long getSnanfang() {
		return snanfang;
	}

	public Long getSnende() {
		return snende;
	}

	public void setSnende(Long snende) {
		this.snende = snende;
	}

	public String getKommentar() {
		return kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

	public void setSnanfang(Long snanfang) {
		this.snanfang = snanfang;
	}

	public Date getVergebenam() {
		return vergebenam;
	}

	public void setVergebenam(Date vergebenam) {
		this.vergebenam = vergebenam;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(Long anzahl) {
		this.anzahl = anzahl;
	}

	@Override
	public String toString() {
		return "SerialNumber [SNAnfang=" + snanfang + ", SNEnde=" + snende
				+ ", Kommentar=" + kommentar + ", vergeben am=" + vergebenam
				+ ",Anzahl=" + anzahl + "]";
	}

}
