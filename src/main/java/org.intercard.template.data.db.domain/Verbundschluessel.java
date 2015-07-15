package org.intercard.template.data.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.intercard.template.data.db.IEntity;
import org.intercard.template.data.db.domain.enums.VerbundschluesselEnum;

/**
 * 
 * @author vanessa zimmermann
 *
 */

@Entity
@Table(name = "Verbundschluessel")
public class Verbundschluessel implements IEntity {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -249971297446L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Column(name = "schluessel")
	@Enumerated(EnumType.STRING)
	private VerbundschluesselEnum schluessel;

	@ManyToOne
	private Kunde kunde;

	// +++Getter Setter+++//

	public Long getId() {
		return id;
	}

	public VerbundschluesselEnum getSchluessel() {
		return schluessel;
	}

	public void setSchluessel(VerbundschluesselEnum schluessel) {
		this.schluessel = schluessel;
	}
}
