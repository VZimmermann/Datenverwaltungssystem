package org.intercard.template.data.db.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.intercard.template.data.db.dao.IGuiUserDao;
import org.intercard.template.data.db.domain.GuiUser;
import org.intercard.template.data.db.ex.DataException;

public class GuiUserDao extends AbstractDao<GuiUser> implements IGuiUserDao {

	@Override
	protected Class<GuiUser> getDomainClass() {
		return GuiUser.class;
	}

	/** Find GuiUser by Name */
	@Override
	public GuiUser findByName(String tName) throws DataException {

		Query q = entityManager.createNamedQuery("findGUserByName");
		q.setParameter("name", tName);

		// GENAU einer erwartet.
		return (GuiUser) q.getSingleResult();
	}

	/** Find GuiUser by ID */
	@Override
	public GuiUser findByID(Long id) throws DataException {
		Query q = entityManager.createNamedQuery("findGUserByID");
		q.setParameter("id", id);

		return (GuiUser) q.getSingleResult();
	}

	/** Find all existing GuiUser */
	@SuppressWarnings("unchecked")
	@Override
	public List<GuiUser> findAllGuiUser() throws DataException {
		Query q = entityManager.createNamedQuery("findAllGUser");
		return (List<GuiUser>) q.getResultList();
	}
}
