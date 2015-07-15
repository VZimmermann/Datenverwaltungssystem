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

/**
 * 
 * @author vanessa zimmermann
 *
 */
@Entity
@Table(name = "GUIUSER")
@NamedQueries({ @NamedQuery(name = "findGUserByName", query = "SELECT g FROM GuiUser g WHERE g.username = :name") })
public class GuiUser implements IEntity {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -2724976971298747446L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "GUIUSERname", unique = true)
	private String username;

	@Column(name = "GUIUSERpassword")
	private String password;

	@Column(name = "GUIUSERadmin", nullable = false)
	private boolean admin;

	// ++++++++++++++++++++++++++++++++++++
	public GuiUser() {

	}

	// ++++++++++++++++++++++++++++++++++++
	// Getter and Setter
	// ++++++++++++++++++++++++++++++++++++

	@Override
	public Long getId() {
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "GuiUser [id=" + id + ", username=" + username + ", password="
				+ password + ", isAdmin=" + admin + "]";
	}

}
