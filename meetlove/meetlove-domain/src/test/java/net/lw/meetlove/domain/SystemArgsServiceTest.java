package net.lw.meetlove.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import java.util.List;

import net.lw.ice.domain.test.BindSessionInTest;
import net.lw.meetlove.api.entity.ISystemArgs;
import net.lw.meetlove.api.entity.ItemResourceType;
import net.lw.meetlove.api.entity.GoodsStatus;
import net.lw.meetlove.api.entity.IGoodsClassify;
import net.lw.meetlove.api.entity.IGoodsItem;
import net.lw.meetlove.api.entity.IItemResource;
import net.lw.meetlove.api.entity.SystemArgsType;
import net.lw.meetlove.api.service.IGoodsClassifyService;
import net.lw.meetlove.api.service.IGoodsItemService;
import net.lw.meetlove.api.service.ISystemArgsService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MysqlTestConfig.class)
public class SystemArgsServiceTest extends BindSessionInTest {

	private final Logger logger = LoggerFactory.getLogger(SystemArgsServiceTest.class);

	@Autowired
	private ISystemArgsService argsService;


	@Test
	public void testAdd(){
		ISystemArgs args = argsService.make();
		args.setName("test");
		args.setValue("test1");
		args.setRemark("test");
		args.setType(SystemArgsType.SYSTEM);
		argsService.add(args);

	}

	@Test
	public void testGetByName(){
		ISystemArgs args = argsService.get("resource");
		logger.debug("*****************************");
		logger.debug(args.getValue());
	}

	@Test
	public void testRemove(){
	}

	@Test
	public void testUpdate(){
		ISystemArgs args = argsService.get(1);
		args.setRemark("update");
		argsService.update(args);
	}

	@Test
	public void testList(){
	}

	@Test
	public void testGet(){
	}




}
