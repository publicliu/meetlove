package net.lw.meetlove.domain;

import java.util.List;
import static org.junit.Assert.assertNotNull;

import net.lw.ice.api.person.entity.IOrganization;
import net.lw.ice.api.person.entity.IUser;
import net.lw.ice.api.person.service.IOrganizationService;
import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;
import net.lw.ice.common.filter.Filter;
import net.lw.ice.domain.test.BindSessionInTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MysqlTestConfig.class)
public class OrganizationServiceTest extends BindSessionInTest{

	@Autowired
	private IOrganizationService orgService;

	@Test
	public void testAdd(){
		IOrganization jsOrg = orgService.make();
		jsOrg.setCode("JS");
		jsOrg.setName("江苏省厅");
		jsOrg.setAddress("江苏省");
		jsOrg.setDescription("江苏省");
		jsOrg.setParent(null);
		jsOrg.setZip("000000");
		orgService.add(jsOrg);


		IOrganization njOrg = orgService.make();
		njOrg.setCode("NJ");
		njOrg.setName("南京市");
		njOrg.setAddress("南京市");
		njOrg.setDescription("南京市");
		njOrg.setParent(jsOrg);
		njOrg.setZip("000000");
		orgService.add(njOrg);

		IOrganization gaoChunOrg = orgService.make();
		gaoChunOrg.setCode("GAOCHUN");
		gaoChunOrg.setName("高淳县");
		gaoChunOrg.setAddress("高淳县");
		gaoChunOrg.setDescription("高淳县");
		gaoChunOrg.setParent(njOrg);
		gaoChunOrg.setZip("000000");
		orgService.add(gaoChunOrg);

		IOrganization lishuiOrg = orgService.make();
		lishuiOrg.setCode("LISHUI");
		lishuiOrg.setName("溧水县");
		lishuiOrg.setAddress("溧水县");
		lishuiOrg.setDescription("溧水县");
		lishuiOrg.setParent(njOrg);
		lishuiOrg.setZip("000000");
		orgService.add(lishuiOrg);

		IOrganization suzhouOrg = orgService.make();
		suzhouOrg.setCode("SUZHOU");
		suzhouOrg.setName("苏州市");
		suzhouOrg.setAddress("苏州市");
		suzhouOrg.setDescription("苏州市");
		suzhouOrg.setParent(jsOrg);
		suzhouOrg.setZip("000000");
		orgService.add(suzhouOrg);
	}

	@Test
	public void testList(){
		List<IOrganization> orgs = orgService.list();
		assertNotNull(orgs);
		for(IOrganization org : orgs){
			System.out.println(org.getName());
		}
	}

	@Test
	public void testGet(){
		long id = 23;
		IOrganization org = orgService.get(id);
		System.out.println(org.getName());
	}

	@Test
	public void testUpdate(){
		long id = 23;
		IOrganization org = orgService.get(id);
		System.out.println(org.getName());
		org.setName(org.getName()+"_update");
		orgService.update(org);
		org = orgService.get(id);
		System.out.println(org.getName());
	}

	@Test
	public void testListSubOrg(){
		long id = 23;
		List<IOrganization> subOrgs = orgService.listChildren(id);
		assertNotNull(subOrgs);
		for(IOrganization org : subOrgs){
			System.out.println(org.getName());
		}
	}

	@Test
	public void testListFilter(){
		IFilter filter = new Filter();
		filter.like("name", "市");
		List<IOrganization> orgs = orgService.list(filter);
		assertNotNull(orgs);
		for(IOrganization org : orgs ){
			System.out.println(org.getName());
		}
	}


	@Test
	public void testPageFilter(){
		int offset = 0;
		int limit = 2;
		IFilter filter = new Filter();
		filter.like("name", "市");
		IPageResult<IOrganization> pageResult = orgService.page(offset, limit,filter);
		assertNotNull(pageResult);
		System.out.println(pageResult.getTotal());
		System.out.println(pageResult.list().size());
	}

	@Test
	public void testPageChildrenById(){
		int offset = 0;
		int limit = 10;
		IFilter filter = new Filter();
		long id = 23;
		IPageResult<IOrganization> pageResult = orgService.pageChildren(offset, limit, filter, id);
		assertNotNull(pageResult);
		System.out.println(pageResult.getTotal());
		for(IOrganization org : pageResult.list()){
			System.out.println(org.getName());
		}
	}

	/*@Test
	public void testListUser(){
		String code = "JS";
		List<IUser> users = orgService.listUser(code);
		assertNotNull(users);
		System.out.println(users.size());
	}*/
}
