package net.lw.meetlove.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import java.util.List;

import net.lw.ice.domain.test.BindSessionInTest;
import net.lw.meetlove.api.entity.ItemResourceType;
import net.lw.meetlove.api.entity.GoodsStatus;
import net.lw.meetlove.api.entity.IGoodsClassify;
import net.lw.meetlove.api.entity.IGoodsItem;
import net.lw.meetlove.api.entity.IItemResource;
import net.lw.meetlove.api.service.IGoodsClassifyService;
import net.lw.meetlove.api.service.IGoodsItemService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MysqlTestConfig.class)
public class GoodsItemServiceTest extends BindSessionInTest {

	private final Logger logger = LoggerFactory.getLogger(GoodsItemServiceTest.class);

	@Autowired
	private IGoodsClassifyService classifyService;
	@Autowired
	private IGoodsItemService infoService;

	@Test
	public void testAdd(){
		IGoodsClassify classify = classifyService.get(4);//港式甜品
		IGoodsItem foodInfo = infoService.make();
		foodInfo.setClassify(classify);
		foodInfo.setName("冰冻草莓2");
		foodInfo.setRemark("冰冻草莓2");
		foodInfo.setStatus(GoodsStatus.ON);
		infoService.add(foodInfo);
	}

	@Test
	public void testRemove(){
		infoService.remove(1);
	}

	@Test
	public void testUpdate(){
		IGoodsItem info = infoService.get(2);
		info.setName(info.getName()+"_update");
		infoService.udpate(info);
	}

	@Test
	public void testList(){
		List<IGoodsItem> infos = infoService.list();
		logger.debug("****************************");
		for(IGoodsItem info : infos){
			logger.debug(info.getName());
		}
		logger.debug("****************************");
	}

	@Test
	public void testGet(){
		IGoodsItem info = infoService.get(2);
		logger.debug(info.getName());
	}


	@Test
	public void testAddResource(){
		IItemResource resource = infoService.makeResource();
		resource.setName("test");
		resource.setType(ItemResourceType.IMAGE);
		infoService.addResource(2, resource);
	}

	@Test
	public void testListResources(){
		List<IItemResource> resources = infoService.listResources(2);
		logger.debug("****************************");
		for(IItemResource resource : resources){
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
