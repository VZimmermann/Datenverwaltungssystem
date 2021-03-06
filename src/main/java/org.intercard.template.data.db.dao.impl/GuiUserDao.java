package org.intercard.template.data.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.intercard.template.data.db.IEntity;

@Entity
@Table(name = "GUIUSER")
@NamedQueries({
		@NamedQuery(name = "findGUserByName", query = "SELECT g FROM GuiUser g WHERE g.username = :name"),
		@NamedQuery(name = "findGUserByID", query = "SELECT g FROM GuiUser g where g.id = :id"),
		@NamedQuery(name = "findAllGUser", query = "SELECT g FROM GuiUser g") })
public class GuiUser implements IEntity {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -2724976971298747446L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "GUIUSERname", unique = true)
	private String username;

	@Column(name = "GUIUSERpassword")
	private String password;

	// ++++++++++++++++++++++++++++++++++++
	public GuiUser() {

	}

	// ++++++++++++++++++++++++++++++++++++
	// Getter and Setter
	// ++++++++++++++++++++++++++++++++++++

	@Override
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "GuiUser [id=" + id + ", "
				+ (username != null ? "username=" + username + ", " : "")
				+ (password != null ? "password=" + password : "") + "]";
	}

}
