package org.intercard.template.data.db.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@NamedQueries({
		@NamedQuery(name = "findAllSeriennummern", query = "SELECT s FROM SerienNummer s"),
		@NamedQuery(name = "findSeriennummerbySNAnfang", query = "SELECT s FROM SerienNummer s where s.snanfang = :snanfang"), })
public class SerienNummer implements IEntity {

	@Transient
	private static final long serialVersionUID = -9765482747446L;

	@Id
	@Column(name = "SNAnfang")
	private int snanfang;

	@Column(name = "SNEnde", unique = true)
	private int snende;

	@Column(name = "Kommentar", nullable = true)
	private String kommentar;

	@Column(name = "vergeben_am")
	private Date vergebenam;

	@Column(name = "Anzahl", nullable = true)
	private int anzahl;

	@ManyToOne
	@JoinColumn
	private Kunde kunde;

	// +++++++++++++++++++++++++++++++++++++
	public SerienNummer() {

	}

	// ++++++++++++++++++++++++++++++++++++
	// Getter and Setter
	// ++++++++++++++++++++++++++++++++++++

	@Override
	public int getId() {
		return snanfang;
	}

	public int getSnanfang() {
		return snanfang;
	}

	public int getSnende() {
		return snende;
	}

	public void setSnende(int snende) {
		this.snende = snende;
	}

	public String getKommentar() {
		return kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

	public void setSnanfang(int snanfang) {
		this.snanfang = snanfang;
	}

	public Date getVergebenam() {
		return vergebenam;
	}

	public void setVergebenam(Date vergebenam) {
		this.vergebenam = vergebenam;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl() {

		anzahl = snende - snanfang;

	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	@Override
	public String toString() {
		return "SerialNumber [SNAnfang=" + snanfang + ", SNEnde=" + snende
				+ ", Kommentar=" + kommentar + ", vergeben am=" + vergebenam
				+ ",Anzahl=" + anzahl + "]";
	}

}
