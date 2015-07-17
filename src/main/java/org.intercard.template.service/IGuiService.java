package org.intercard.template.service;

import java.util.List;

import org.intercard.template.data.db.domain.GuiUser;

public interface IGuiService {

	/**
	 * If Param user NULL then throws Nullpointer
	 * 
	 * @throws NullPointerException
	 *             if User NULL
	 * @param user
	 * @return true if User known / false if user in db not found
	 */
	public boolean isAuthenticatedUser(GuiUser user);

	public GuiUser getGuiuser(String name);

	public GuiUser getGuiuser(int id);

	public List<GuiUser> getGuiuserList();

	public boolean createGuiuser(GuiUser user);

	public boolean updateGuiuser(GuiUser user);

	public boolean deleteGuiuser(GuiUser user);

	public boolean logout();

}
