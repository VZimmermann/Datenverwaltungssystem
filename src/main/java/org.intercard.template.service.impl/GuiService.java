package org.intercard.template.service.impl;

import java.util.List;

import org.intercard.template.data.db.dao.IGuiUserDao;
import org.intercard.template.data.db.domain.GuiUser;
import org.intercard.template.data.db.ex.DataException;
import org.intercard.template.service.IGuiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuiService implements IGuiService {

	private static final Logger logger = LoggerFactory
			.getLogger(GuiService.class);

	private IGuiUserDao guiUserDao;

	@Override
	public boolean isAuthenticatedUser(GuiUser user) {
		if (user != null) {
			try {
				GuiUser dbUser = guiUserDao.findByName(user.getUsername());

				if (dbUser.getPassword().equals(user.getPassword()))
					return true;

			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;
	}

	@Override
	public GuiUser getGuiuser(String name) {
		if (name != null) {
			try {
				GuiUser dbUser = guiUserDao.findByName(name);
				return dbUser;

			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return null;
	}

	@Override
	public GuiUser getGuiuser(int id) {
		if (id != 0) {
			try {
				GuiUser dbUser = guiUserDao.findOne(id);
				return dbUser;

			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return null;
	}

	@Override
	public List<GuiUser> getGuiuserList() {
		try {
			List<GuiUser> ret = guiUserDao.findAll();
			if (ret != null && !ret.isEmpty())
				return ret;
		} catch (DataException e) {
			logger.debug("EX", e);
		}
		return null;
	}

	@Override
	public boolean createGuiuser(GuiUser user) {
		if (user != null) {
			try {
				guiUserDao.doSave(user);
				logger.debug(" Service Create User");
				return true;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;
	}

	@Override
	public boolean updateGuiuser(GuiUser user) {
		if (user != null && user.getId() != 0) {
			try {
				guiUserDao.doUpdate(user);
				logger.debug(" Service Update User");
				return true;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;
	}

	@Override
	public boolean deleteGuiuser(GuiUser user) {
		if (user != null && user.getId() != 0) {
			try {
				guiUserDao.doDelete(user);
				logger.debug(" Service Delete User");
				return true;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;
	}

	/*
	 * SETTER FOR SPRING CONFIG
	 */
	public void setGuiUserDao(IGuiUserDao guiUserDao) {
		this.guiUserDao = guiUserDao;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

}
