package org.intercard.template.data;

import org.intercard.template.data.db.dao.IGuiUserDao;
import org.intercard.template.data.db.domain.GuiUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestGuiUserService extends org.intercard.template.SpringTestBase {

	private static final Logger logger = LoggerFactory
			.getLogger(TestGuiUserService.class);

	IGuiUserDao guiDao = (IGuiUserDao) context
			.getBean("org.intercard.template.data.db.dao.IGuiUserDao");

	public void test() {

		try {

			GuiUser user = guiDao.findByName("User");
			if (user == null)
				fail();

		} catch (Exception e) {
			logger.error("Exception", e);
			fail(e.toString());
		}
	}

	@Override
	protected void setUp() throws Exception {

		// Create GuiUser
		GuiUser element = new GuiUser();
		element.setAdmin(false);
		element.setPassword("1234");
		element.setUsername("User");

		guiDao.doSave(element);

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		for (GuiUser user : guiDao.findAll()) {
			guiDao.doDelete(user);
		}
		super.tearDown();
	}
}
