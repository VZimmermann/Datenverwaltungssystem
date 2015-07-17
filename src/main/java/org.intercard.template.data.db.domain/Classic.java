package org.intercard.template.data.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.intercard.template.data.db.domain.enums.Aufbautype;

/**
 * 
 * @author vanessa zimmermann
 *
 */
@Entity
@Table(name = "Classic")
@NamedQueries({

		@NamedQuery(name = "findActivClassic", query = "SELECT c FROM Classic c where c.aktiv= :activ"),
		/*
		 * @NamedQuery(name = "findClassicbySystemnummer", query =
		 * "SELECT c FROM Classic c where c.N1V= :n1v and c.N1A = :n1a and c.n2= : n2 and c.n3= :n3  "
		 * ),
		 */
		@NamedQuery(name = "findAllClassic", query = "SELECT c FROM Classic c ") })
public class Classic extends KartenTechnologien {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -35476857446L;

	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private Aufbautype type;

	@Column(name = "N1V")
	private Integer N1V;

	@Column(name = "N1A")
	private Integer N1A;

	@Column(name = "N2")
	private Integer N2;

	@Column(name = "N3")
	private Integer N3;

	// ++++++++++++++++++++++++++++++++++++
	public Classic() {

	}

	// ++++++++++++++++++++++++++++++++++++
	// Getter and Setter
	// ++++++++++++++++++++++++++++++++++++

	@Override
	public String toString() {
		return "Classic[" + super.toString() + ", Systemnummer=" + N1V + "/"
				+ N1A + "." + N2 + "." + N3 + "]";
	}

	public String toStringZusammengesetzt() {
		return N1V + "/" + N1A + "." + N2 + "." + N3;
	}

	public Aufbautype getType() {
		return type;
	}

	public void setType(Aufbautype type) {
		this.type = type;
	}

	// public String getSystemnummergesamt() {
	// String systemnummergesamt = N1V + "/" + N1A + "." + N2 + "." + N3;
	// return systemnummergesamt;
	// }
	//
	// public void setSystemnummergesamt(String systemnummergesamt) {
	// this.systemnummergesamt = systemnummergesamt;
	// }

	//
	// public void setSystemnummergesamt(int N1V, int N1A, int N2, int N3) {
	// this.N1A = N1A;
	// this.N1V = N1V;
	// this.N2 = N2;
	// this.N3 = N3;
	//
	// }

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

}
