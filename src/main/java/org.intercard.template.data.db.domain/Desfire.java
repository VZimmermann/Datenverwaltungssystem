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
@Table(name = "Desfire")
@NamedQueries({
		@NamedQuery(name = "findAllDesfire", query = "SELECT d FROM Desfire d"),
		@NamedQuery(name = "findActivDesfire", query = "SELECT d FROM Desfire d where d.activ = :activ"),
		@NamedQuery(name = "findDesfirebyID", query = "SELECT d FROM Desfire d where d.systemnummergesamt = :systemnummergesamt") })
public class Desfire extends KartenTechnologien implements IEntity {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -5415176857446L;

	@Column(name = "N1V", nullable = true)
	private Integer N1V;

	@Column(name = "N1A", nullable = true)
	private Integer N1A;

	@Column(name = "N2", nullable = true)
	private Integer N2;

	@Column(name = "N3", nullable = true)
	private Integer N3;

	@Column(name = "Aufbaustruktur", nullable = true)
	private String aufbaustruktur;

	@Column(name = "Minorversion", nullable = true)
	private String minorversion;

	String systemnummergesamt = N1V + "/" + N1A + "/" + N2 + "/" + N3;

	// ++++++++++++++++++++++++++++++++++++
	public Desfire() {

	}

	// ++++++++++++++++++++++++++++++++++++
	// Getter and Setter
	// ++++++++++++++++++++++++++++++++++++

	@Override
	public String toString() {
		return "Desfire[" + super.toString() + ", Systemnummer=" + N1V + "/"
				+ N1A + "/" + N2 + "/" + N3 + "]";
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

	public String getAufbaustruktur() {
		return aufbaustruktur;
	}

	public void setAufbaustruktur(String aufbaustruktur) {
		this.aufbaustruktur = aufbaustruktur;
	}

	public String getMinorversion() {
		return minorversion;
	}

	public void setMinorversion(String minorversion) {
		this.minorversion = minorversion;
	}

}
