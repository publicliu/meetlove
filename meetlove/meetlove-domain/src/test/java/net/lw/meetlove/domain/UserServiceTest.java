package net.lw.meetlove.domain;

import static org.junit.Assert.assertNotNull;
import net.lw.ice.api.person.entity.IOrganization;
import net.lw.ice.api.person.entity.IUser;
import net.lw.ice.api.person.service.IOrganizationService;
import net.lw.ice.api.person.service.IUserService;
import net.lw.ice.domain.test.BindSessionInTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MysqlTestConfig.class)
public class UserServiceTest extends BindSessionInTest {

	@Autowired
	private IUserService userService;

	@Autowired
	private IOrganizationService orgService;

}
