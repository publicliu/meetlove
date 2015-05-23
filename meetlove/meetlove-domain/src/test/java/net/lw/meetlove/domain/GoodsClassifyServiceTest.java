package net.lw.meetlove.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import java.util.List;

import net.lw.ice.domain.test.BindSessionInTest;
import net.lw.meetlove.api.entity.GoodsStatus;
import net.lw.meetlove.api.entity.IGoodsClassify;
import net.lw.meetlove.api.entity.IGoodsItem;
import net.lw.meetlove.api.service.IGoodsClassifyService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MysqlTestConfig.class)
public class GoodsClassifyServiceTest extends BindSessionInTest {

	private final Logger logger = LoggerFactory.getLogger(GoodsClassifyServiceTest.class);

	@Autowired
	private IGoodsClassifyService classifyService;

	@Test
	public void testAdd(){
		IGoodsClassify classify = classifyService.make();
		classify.setName("test6");
		classify.setRemark("test7");
		classify.setStatus(GoodsStatus.OFF);

		classify = classifyService.add(classify);


	}

	@Test
	public void testRemove(){
		classifyService.remove(2);
	}

	@Test
	public void testUpdate(){
		IGoodsClassify classify = classifyService.get(3);
		classify.setName(classify.getName()+"_update");
		classifyService.update(classify);

		IGoodsClassify classify2 = classifyService.get(3);
		logger.debug(classify2.getName());
	}

	@Test
	public void testList(){
		List<IGoodsClassify> list = classifyService.list();
		assertEquals(2, list.size());
	}

	public void testGet(){
		IGoodsClassify classify = classifyService.get(10);
		assertNull(classify);
	}

	@Test
	public void testListFoodInfos(){
		List<IGoodsItem> infos = classifyService.listFoodInfos(4);
		logger.info("******************************************");
		for(IGoodsItem info : infos){
			logger.info(info.getName());
		}
		logger.info("******************************************");
	}

	@Test
	public void testListFirstChildrenClassifies(){
		List<IGoodsClassify> classifies = classifyService.listFirstChildrenClassifies();
		logger.info("******************************************");
		for(IGoodsClassify classify : classifies){
			logger.info(classify.getName());
		}
		logger.info("******************************************");
	}

}
