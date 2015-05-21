package net.lw.meetlove.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import java.util.List;

import net.lw.ice.domain.test.BindSessionInTest;
import net.lw.meetlove.api.entity.FoodResourceType;
import net.lw.meetlove.api.entity.FoodStatus;
import net.lw.meetlove.api.entity.IFoodClassify;
import net.lw.meetlove.api.entity.IFoodInfo;
import net.lw.meetlove.api.entity.IFoodResource;
import net.lw.meetlove.api.service.IFoodClassifyService;
import net.lw.meetlove.api.service.IFoodInfoService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MysqlTestConfig.class)
public class FoodInfoServiceTest extends BindSessionInTest {

	private final Logger logger = LoggerFactory.getLogger(FoodInfoServiceTest.class);

	@Autowired
	private IFoodClassifyService classifyService;
	@Autowired
	private IFoodInfoService infoService;

	@Test
	public void testAdd(){
		IFoodClassify classify = classifyService.get(4);//港式甜品
		IFoodInfo foodInfo = infoService.make();
		foodInfo.setClassify(classify);
		foodInfo.setName("冰冻草莓2");
		foodInfo.setRemark("冰冻草莓2");
		foodInfo.setStatus(FoodStatus.ON);
		infoService.add(foodInfo);
	}

	@Test
	public void testRemove(){
		infoService.remove(1);
	}

	@Test
	public void testUpdate(){
		IFoodInfo info = infoService.get(2);
		info.setName(info.getName()+"_update");
		infoService.udpate(info);
	}

	@Test
	public void testList(){
		List<IFoodInfo> infos = infoService.list();
		logger.debug("****************************");
		for(IFoodInfo info : infos){
			logger.debug(info.getName());
		}
		logger.debug("****************************");
	}

	@Test
	public void testGet(){
		IFoodInfo info = infoService.get(2);
		logger.debug(info.getName());
	}


	@Test
	public void testAddResource(){
		IFoodResource resource = infoService.makeResource();
		resource.setName("test");
		resource.setType(FoodResourceType.IMAGE);
		infoService.addResource(2, resource);
	}

	@Test
	public void testListResources(){
		List<IFoodResource> resources = infoService.listResources(2);
		logger.debug("****************************");
		for(IFoodResource resource : resources){
			logger.debug(resource.getName());
		}
		logger.debug("****************************");
	}

	@Test
	public void testRemoveResource(){
		infoService.removeResource(1);
	}

	@Test
	public void testRemoveAllResources(){
		infoService.removeAllResources(2);
	}

}
