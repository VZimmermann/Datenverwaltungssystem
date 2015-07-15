package org.intercard.template.data.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import org.intercard.template.data.db.IEntity;

/**
 * 
 * @author vanessa zimmermann
 *
 */

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@NamedQueries({ @NamedQuery(name = "findKartentechnologien", query = "SELECT k from KartenTechnologien k") })
public abstract class KartenTechnologien implements IEntity {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -24976971297446L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Column(name = "IsActiv")
	private boolean aktiv;

	@Column(name = "KeyFilePath")
	private String keyfilepath;

	@ManyToOne
	@JoinColumn(name = "KUNDEN_NR")
	private Kunde kunde;

	// ++++++++++++++++++++++++++++++++++++
	public KartenTechnologien() {

	}

	// ++++++++++++++++++++++++++++++++++++
	// Getter and Setter
	// ++++++++++++++++++++++++++++++++++++

	public Long getId() {
		return id;
	}

	public boolean isAktiv() {
		return aktiv;
	}

	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}

	public String getKeyfilepath() {
		return keyfilepath;
	}

	public void setKeyfilepath(String keyfilepath) {
		this.keyfilepath = keyfilepath;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	@Override
	public String toString() {
		return "id=" + id + ", activ=" + aktiv + ",KeyfilePath=" + keyfilepath;
	}
}
