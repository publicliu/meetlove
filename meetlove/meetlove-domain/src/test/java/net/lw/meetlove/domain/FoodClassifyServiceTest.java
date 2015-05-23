package net.lw.meetlove.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import java.util.List;

import net.lw.ice.domain.test.BindSessionInTest;
import net.lw.meetlove.api.entity.FoodStatus;
import net.lw.meetlove.api.entity.IFoodClassify;
import net.lw.meetlove.api.entity.IFoodInfo;
import net.lw.meetlove.api.service.IFoodClassifyService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MysqlTestConfig.class)
public class FoodClassifyServiceTest extends BindSessionInTest {

	private final Logger logger = LoggerFactory.getLogger(FoodClassifyServiceTest.class);

	@Autowired
	private IFoodClassifyService classifyService;

	@Test
	public void testAdd(){
		IFoodClassify classify = classifyService.make();
		classify.setName("test6");
		classify.setRemark("test7");
		classify.setStatus(FoodStatus.OFF);

		classify = classifyService.add(classify);


	}

	@Test
	public void testRemove(){
		classifyService.remove(2);
	}

	@Test
	public void testUpdate(){
		IFoodClassify classify = classifyService.get(3);
		classify.setName(classify.getName()+"_update");
		classifyService.update(classify);

		IFoodClassify classify2 = classifyService.get(3);
		logger.debug(classify2.getName());
	}

	@Test
	public void testList(){
		List<IFoodClassify> list = classifyService.list();
		assertEquals(2, list.size());
	}

	public void testGet(){
		IFoodClassify classify = classifyService.get(10);
		assertNull(classify);
	}

	@Test
	public void testListFoodInfos(){
		List<IFoodInfo> infos = classifyService.listFoodInfos(4);
		logger.info("******************************************");
		for(IFoodInfo info : infos){
			logger.info(info.getName());
		}
		logger.info("******************************************");
	}

	@Test
	public void testListFirstChildrenClassifies(){
		List<IFoodClassify> classifies = classifyService.listFirstChildrenClassifies();
		logger.info("******************************************");
		for(IFoodClassify classify : classifies){
			logger.info(classify.getName());
		}
		logger.info("******************************************");
	}

}
