package org.intercard.template.data.db.dao;

import java.util.List;

import org.intercard.template.data.db.domain.GuiUser;
import org.intercard.template.data.db.ex.DataException;

public interface IGuiUserDao extends IDao<GuiUser> {

	/** Find GuiUser by Name */
	public GuiUser findByName(String tName) throws DataException;

	/** Find GuiUser by ID */
	public GuiUser findByID(Long id) throws DataException;

	/** Find all existing GuiUser */
	public List<GuiUser> findAllGuiUser() throws DataException;

}
