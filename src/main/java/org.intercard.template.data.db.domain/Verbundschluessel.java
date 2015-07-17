package org.intercard.template.data.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.intercard.template.data.db.IEntity;

/**
 * 
 * @author vanessa zimmermann
 *
 */

@Entity
@Table(name = "Verbundschluessel")
// @NamedQueries({ @NamedQuery(name = "findSchluesseltoKunde", query =
// "SELECT s FROM Verbundschluessel s join fetch s.kunde k where kunde.id= :id ")
// })
public class Verbundschluessel implements IEntity {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -249971297446L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;

	// @Column(name = "schluessel")
	// @Enumerated(EnumType.STRING)
	// private VerbundschluesselEnum schluessel;

	@Column(name = "Hauptboerse")
	private boolean hauptboerse;

	@Column(name = "OeffenDaten")
	private boolean oeffenDaten;

	@Column(name = "MTKNR_TRW_DATEN")
	private boolean mtknr_trw_daten;

	@Column(name = "Bibliotheksnr")
	private boolean bibliotheksnr;

	@Column(name = "Zutrittsnr")
	private boolean zutrittsnr;

	@ManyToOne
	@JoinColumn
	private Kunde kunde;

	// +++Getter Setter+++//

	@Override
	public String toString() {
		return "Verbundschluessel [" + "hauptboerse=" + hauptboerse
				+ ", oeffenDaten=" + oeffenDaten + ", mtknr_trw_daten="
				+ mtknr_trw_daten + ", bibliotheksnr=" + bibliotheksnr
				+ ", zutrittsnr=" + zutrittsnr + "]";
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public int getId() {
		return id;
	}

	public boolean isHauptboerse() {
		return hauptboerse;
	}

	public void setHauptboerse(boolean hauptboerse) {
		this.hauptboerse = hauptboerse;
	}

	public boolean isOeffenDaten() {
		return oeffenDaten;
	}

	public void setOeffenDaten(boolean oeffenDaten) {
		this.oeffenDaten = oeffenDaten;
	}

	public boolean isMtknr_trw_daten() {
		return mtknr_trw_daten;
	}

	public void setMtknr_trw_daten(boolean mtknr_trw_daten) {
		this.mtknr_trw_daten = mtknr_trw_daten;
	}

	public boolean isBibliotheksnr() {
		return bibliotheksnr;
	}

	public void setBibliotheksnr(boolean bibliotheksnr) {
		this.bibliotheksnr = bibliotheksnr;
	}

	public boolean isZutrittsnr() {
		return zutrittsnr;
	}

	public void setZutrittsnr(boolean zutrittsnr) {
		this.zutrittsnr = zutrittsnr;
	}

	// public VerbundschluesselEnum getSchluessel() {
	// return schluessel;
	// }
	//
	// public void setSchluessel() {
	// this.schluessel = schluessel;
	// }

}
