package org.intercard.template.data.db.dao.impl;

import javax.persistence.Query;

import org.intercard.template.data.db.dao.IGuiUserDao;
import org.intercard.template.data.db.domain.GuiUser;
import org.intercard.template.data.db.ex.DataException;

public class GuiUserDao extends AbstractDao<GuiUser> implements IGuiUserDao {

	@Override
	protected Class<GuiUser> getDomainClass() {
		return GuiUser.class;
	}

	@Override
	public GuiUser findByName(String tName) throws DataException {

		Query q = entityManager.createNamedQuery("findGUserByName");
		q.setParameter("name", tName);

		// GENAU einer erwartet.
		return (GuiUser) q.getSingleResult();
	}
}
