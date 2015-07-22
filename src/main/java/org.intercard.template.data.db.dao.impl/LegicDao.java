package org.intercard.template.data.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.intercard.template.data.db.IEntity;

/**
 * 
 * @author vanessa zimmermann
 *
 */
@Entity
@Table(name = "Legic")
@NamedQueries({
		@NamedQuery(name = "findAllLegic", query = "SELECT l FROM Legic l"),
		@NamedQuery(name = "findActivLegic", query = "SELECT l FROM Legic l where l.aktiv = :activ") })
public class Legic extends KartenTechnologien implements IEntity {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -15176857446L;

	@Column(name = "N1V", nullable = true)
	private Integer N1V;

	@Column(name = "N1A", nullable = true)
	private Integer N1A;

	@Column(name = "N2", nullable = true)
	private Integer N2;

	@Column(name = "N3", nullable = true)
	private Integer N3;

	@Column(name = "Kartentechnologie")
	private String kartentechnologie = "Legic";

	@Column(name = "zusammengesetzt")
	private String zusammengesetzt;

	// ++++++++++++++++++++++++++++++++++++
	public Legic() {

	}

	// ++++++++++++++++++++++++++++++++++++
	// Getter and Setter
	// ++++++++++++++++++++++++++++++++++++

	@Override
	public String toString() {
		return "Legic[" + super.toString() + ", Systemnummer=" + N1V + "/"
				+ N1A + "." + N2 + "." + N3 + "]";
	}

	public Integer getN1V() {
		return N1V;
	}

	public void setN1V(Integer n1v) {
		N1V = n1v;
	}

	public Integer getN1A() {
		return N1A;
	}

	public void setN1A(Integer n1a) {
		N1A = n1a;
	}

	public Integer getN2() {
		return N2;
	}

	public void setN2(Integer n2) {
		N2 = n2;
	}

	public Integer getN3() {
		return N3;
	}

	public void setN3(Integer n3) {
		N3 = n3;
	}

	public String getZusammengesetzt() {
		return zusammengesetzt;
	}

	public void setZusammengesetzt() {

		zusammengesetzt = N1V + "/" + N1A + "." + N2 + "." + N3;

	}
}
