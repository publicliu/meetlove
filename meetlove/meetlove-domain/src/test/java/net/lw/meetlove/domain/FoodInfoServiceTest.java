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
	}

	@Test
	public void testUpdate(){
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

}
