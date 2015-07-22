package org.intercard.template.data.db.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.intercard.template.data.db.IEntity;

/**
 * 
 * @author vanessa zimmermann
 *
 */
@Entity
@Table(name = "Verbund")
@NamedQueries({
		@NamedQuery(name = "findVerbund", query = "SELECT v FROM Verbund v where v.verbundname = :name"),
		@NamedQuery(name = "findAllVerbund", query = "SELECT v FROM Verbund v "),

/*
 * @NamedQuery(name = "findVerbundWithTeilnehmer", query =
 * " Select v, k FROM Verbund v ,Kunde k join fetch v.verbundsTeilnehmer k ")
 */})
public class Verbund implements IEntity {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -4976548298747446L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Column(name = "Verbundname")
	private String verbundname;

	// @ManyToOne
	// private Kunde verbundmutter;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "verbund", fetch = FetchType.EAGER)
	private List<Kunde> verbundsTeilnehmer;

	// ++++++++++++++++++++++++++++++++++++
	public Verbund() {

	}

	// ++++++++++++++++++++++++++++++++++++
	// Getter and Setter
	// ++++++++++++++++++++++++++++++++++++

	@Override
	public int getId() {
		return id;
	}

	public String getVerbundname() {
		return verbundname;
	}

	public void setVerbundname(String verbundname) {
		this.verbundname = verbundname;
	}

	public List<Kunde> getVerbundsTeilnehmer() {
		if (verbundsTeilnehmer == null)
			return new ArrayList<Kunde>();
		return verbundsTeilnehmer;
	}

	public void setVerbundsTeilnehmer(List<Kunde> verbundsTeilnehmer) {
		this.verbundsTeilnehmer = verbundsTeilnehmer;
	}

	public void addVerbundsTeilnehmer(Kunde verbund) {
		if (verbundsTeilnehmer == null) {
			verbundsTeilnehmer = new ArrayList<Kunde>();
		}
		verbundsTeilnehmer.add(verbund);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Verbund [id=");
		builder.append(id);
		builder.append(", ");
		if (verbundname != null) {
			builder.append("verbundname=");
			builder.append(verbundname);
		}
		builder.append("]");
		return builder.toString();
	}

	public String toStringWithVerbundteilnehmer() {
		StringBuilder builder = new StringBuilder();
		builder.append("Verbund [id=");
		builder.append(id);
		builder.append(", ");
		if (verbundname != null) {
			builder.append("verbundname=");
			builder.append(verbundname);
			builder.append(", ");
		}
		if (verbundsTeilnehmer != null) {
			builder.append("verbundsTeilnehmer=");
			builder.append(verbundsTeilnehmer);
		}
		builder.append("]");
		return builder.toString();
	}

}
