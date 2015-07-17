package org.intercard.template.data.db.domain;

import java.util.ArrayList;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.intercard.template.data.db.IEntity;
import org.intercard.template.data.db.domain.enums.Laenderkuerzel;

/**
 * 
 * @author vanessa zimmermann
 *
 */
@Entity
@Table(name = "Kunde")
@NamedQueries({
		@NamedQuery(name = "findKundebyName", query = "SELECT k FROM Kunde k where k.kundenname= :name "),
		/**
		 * Join from Kunde and KartenTechnologien, so that the Kundennr is
		 * standing in KartenTechnologien
		 */
		@NamedQuery(name = "findKundeWithBags", query = "SELECT k FROM Kunde k join fetch k.kartenTechnologien t where k.id = :id "),

		@NamedQuery(name = "findAllKundeWithBags", query = "SELECT k FROM Kunde k join fetch k.kartenTechnologien t"),
		@NamedQuery(name = "findKundeWithSeriennummer", query = "SELECT k FROM Kunde k join fetch k.serienNummern s where k.id=:id"),
		@NamedQuery(name = "findKunde", query = " SELECT k FROM Kunde k"),

		@NamedQuery(name = "findKundeWithVerbundschluessel", query = "SELECT k FROM Kunde k join fetch k.verbundschluessel s where k.id = :id ") })
public class Kunde implements IEntity {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -26971298747446L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "Name", unique = true)
	private String kundenname;

	@Column(name = "SAPKundenNr")
	private String sapkundennr;

	@Column(name = "SAPStatus")
	private String sapstatus;

	@Column(name = "Hochschulregionnummer")
	private String hochschulregionnummer;

	@Column(name = "Hochschulnummer")
	private String hochschulnummer;

	@Column(name = "Fremdsystemnummer", nullable = true)
	private String fremdsysnr;

	@Column(name = "Kommentarfeld", nullable = true)
	private String kommentar;

	@Column(name = "Laenderkuerzel")
	@Enumerated(EnumType.STRING)
	private Laenderkuerzel laenderkuerzel;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kunde", fetch = FetchType.EAGER)
	private List<KartenTechnologien> kartenTechnologien;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kunde", fetch = FetchType.EAGER)
	// , fetch= FetchType.EAGER -> Gefaehrlich !!!
	private List<SerienNummer> serienNummern;

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "kunde", fetch = FetchType.EAGER)
	private List<Verbundschluessel> verbundschluessel;

	@ManyToOne
	@JoinColumn(name = "VERBUNDS_NR")
	private Verbund verbund;

	@Transient
	private boolean isVerbundsmutter;

	// ++++++++++++++++++++++++++++++++++++
	public Kunde() {
		isVerbundsmutter = false;
		kartenTechnologien = new ArrayList<KartenTechnologien>();
		serienNummern = new ArrayList<SerienNummer>();

		verbundschluessel = new ArrayList<Verbundschluessel>();
	}

	// ++++++++++++++++++++++++++++++++++++
	// Getter and Setter
	// ++++++++++++++++++++++++++++++++++++

	public String getKundenname() {
		return kundenname;
	}

	@Override
	public String toString() {
		return "Kunde ["
				+ ("id=" + id)
				+ (kundenname != null ? "kundenname=" + kundenname + ", " : "")
				+ (sapkundennr != null ? "sapkundennr=" + sapkundennr + ", "
						: "")
				+ (sapstatus != null ? "sapstatus=" + sapstatus + ", " : "")
				+ (hochschulregionnummer != null ? "hochschulregionnummer="
						+ hochschulregionnummer + ", " : "")
				+ (hochschulnummer != null ? "hochschulnummer="
						+ hochschulnummer + ", " : "")
				+ (fremdsysnr != null ? "fremdsysnr=" + fremdsysnr + ", " : "")
				+ (kommentar != null ? "kommentar=" + kommentar + ", " : "")
				+ (laenderkuerzel != null ? "laenderkuerzel=" + laenderkuerzel
						+ ", " : "")
				+ (kartenTechnologien != null ? "kartenTechnologien="
						+ kartenTechnologien + ", " : "")
				+ (serienNummern != null ? "serienNummern=" + serienNummern
						+ ", " : "")
				+ (verbundschluessel != null ? "verbundschluessel="
						+ verbundschluessel + ", " : "")
				+ (verbund != null ? "verbund=" + verbund + ", " : "")
				+ "isVerbundsmutter=" + isVerbundsmutter + "]";
	}

	public void setKundenname(String kundenname) {
		this.kundenname = kundenname;
	}

	public String getSapkundennr() {
		return sapkundennr;
	}

	public void setSapkundennr(String sapkundennr) {
		this.sapkundennr = sapkundennr;
	}

	public String getSapstatus() {
		return sapstatus;
	}

	public void setSapstatus(String sapstatus) {
		this.sapstatus = sapstatus;
	}

	public String getHochschulregionnummer() {
		return hochschulregionnummer;
	}

	public void setHochschulregionnummer(String hochschulregionnummer) {
		this.hochschulregionnummer = hochschulregionnummer;
	}

	public String getHochschulnummer() {
		return hochschulnummer;
	}

	public void setHochschulnummer(String hochschulnummer) {
		this.hochschulnummer = hochschulnummer;
	}

	public String getFremdsysnr() {
		return fremdsysnr;
	}

	public void setFremdsysnr(String fremdsysnr) {
		this.fremdsysnr = fremdsysnr;
	}

	public String getKommentar() {
		return kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

	public Laenderkuerzel getLaenderkuerzel() {
		return laenderkuerzel;
	}

	public void setLaenderkuerzel(Laenderkuerzel laenderkuerzel) {
		this.laenderkuerzel = laenderkuerzel;
	}

	/**
	 * Returns the list or a empty list.
	 * 
	 * @return
	 */
	public List<KartenTechnologien> getKartenTechnologien() {
		if (kartenTechnologien == null)
			return new ArrayList<KartenTechnologien>();
		return kartenTechnologien;
	}

	public void setKartenTechnologien(
			List<KartenTechnologien> kartentechnologien) {
		if (isVerbundsmutter == false) {
			this.kartenTechnologien = kartentechnologien;
		}

	}

	/**
	 * Add an instance of KartenTechnologien to the list or a new list.
	 * 
	 * @param kartenTechnologi
	 */
	public void addKartenTechnologi(KartenTechnologien kartenTechnologi) {
		if (kartenTechnologien == null) {
			kartenTechnologien = new ArrayList<KartenTechnologien>();
		}
		kartenTechnologien.add(kartenTechnologi);
	}

	public List<SerienNummer> getSerienNummern() {
		if (serienNummern == null)
			return new ArrayList<SerienNummer>();
		return serienNummern;
	}

	public void setSerienNummern(List<SerienNummer> serienNummern) {
		this.serienNummern = serienNummern;
	}

	public void addSerienNummern(SerienNummer serienNummer) {
		if (serienNummern == null) {
			serienNummern = new ArrayList<SerienNummer>();
		}
		serienNummern.add(serienNummer);
	}

	public Verbund getVerbund() {
		return verbund;
	}

	public List<Verbundschluessel> getVerbundschluessel() {
		if (verbundschluessel == null)
			return new ArrayList<Verbundschluessel>();
		return verbundschluessel;
	}

	public void setVerbundschluessel(List<Verbundschluessel> verbundschluessel) {
		if (isVerbundsmutter == false) {
			this.verbundschluessel = verbundschluessel;
		} else
			verbundschluessel = null;
	}

	public void addVerbundschluessel(Verbundschluessel schluessel) {
		/**
		 * if a Kunde is not a Verbundsmutter then there are Verbundsschluessel
		 * otherwise not
		 */
		if (isVerbundsmutter == false) {
			if (verbundschluessel == null) {
				verbundschluessel = new ArrayList<Verbundschluessel>();
			}
			verbundschluessel.add(schluessel);
		} else
			verbundschluessel = null;

	}

	public void setVerbund(Verbund verbund) {
		this.verbund = verbund;
	}

	public boolean isVerbundsmutter() {

		return isVerbundsmutter;
	}

	public void setVerbundsmutter(boolean isVerbundsmutter) {
		if (isVerbundsmutter == false) {
			this.isVerbundsmutter = isVerbundsmutter;
		}
	}

	public int getId() {
		return id;
	}

}
