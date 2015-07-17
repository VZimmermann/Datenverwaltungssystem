/**
 * 
 * @author Raphael Biewald
 * 
 */
package org.intercard.template.ui.jsf.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.intercard.template.data.db.domain.GuiUser;
import org.intercard.template.service.IGuiService;
import org.intercard.template.ui.jsf.controller.AbstractFaceController;
import org.intercard.template.ui.jsf.controller.IGuiUserFaceController;

/**
 * 
 */

public class GuiUserFaceController extends AbstractFaceController implements
		IGuiUserFaceController {

	private static final long serialVersionUID = 1593939133787897682L;

	private IGuiService guiService;

	private List<GuiUser> userList = null;
	private GuiUser user;

	public GuiUserFaceController() {
		super();
		userList = new ArrayList<GuiUser>();
	}

	public IGuiService getGuiService() {
		return guiService;
	}

	public void setGuiService(IGuiService guiService) {
		this.guiService = guiService;
	}

	public String init() {

		if (guiService != null)
			load();
		return null;
	}

	@Override
	public String load() {
		userList = guiService.getGuiuserList();
		return null;
	}

	@Override
	public String edit() {
		if (user.getId() != 0)
			guiService.updateGuiuser(user);
		else
			guiService.createGuiuser(user);

		return null;
	}

	@Override
	public String delete() {
		guiService.deleteGuiuser(user);

		return null;
	}

	@Override
	public boolean isListNotEmpty() {
		if (userList != null)
			if (!userList.isEmpty())
				return true;
		return false;
	}

	// SETTER / GETTER

	public List<GuiUser> getUserList() {
		return userList;
	}

	public void setUserList(List<GuiUser> userList) {
		this.userList = userList;
	}

	public GuiUser getUser() {
		return user;
	}

	public void setUser(GuiUser user) {
		this.user = user;
	}

}
