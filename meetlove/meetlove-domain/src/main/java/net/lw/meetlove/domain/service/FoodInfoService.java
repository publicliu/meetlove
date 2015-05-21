/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月20日 下午9:18:52
 */
package net.lw.meetlove.domain.service;

import java.util.List;

import javax.annotation.Resource;

import net.lw.ice.domain.dao.IGenericDao;
import net.lw.meetlove.api.entity.IFoodInfo;
import net.lw.meetlove.api.entity.IFoodResource;
import net.lw.meetlove.api.service.IFoodInfoService;
import net.lw.meetlove.domain.entity.FoodInfo;
import net.lw.meetlove.domain.entity.FoodResource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuwei
 *
 */
@Service
@Transactional
public class FoodInfoService implements IFoodInfoService {


	@Resource(name="hibernateDao")
	private IGenericDao dao;

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#make()
	 */
	public IFoodInfo make() {
		return new FoodInfo();
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#makeResource()
	 */
	public IFoodResource makeResource() {
		// TODO Auto-generated method stub
		return new FoodResource();
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#get(long)
	 */
	public IFoodInfo get(long infoId) {
		return dao.load(infoId, FoodInfo.class);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#add(net.lw.meetlove.api.entity.IFoodInfo)
	 */
	public IFoodInfo add(IFoodInfo foodInfo) {
		return dao.save(foodInfo);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#remove(long)
	 */
	public void remove(long id) {
		dao.delete(id, FoodInfo.class);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#udpate(net.lw.meetlove.api.entity.IFoodInfo)
	 */
	public void udpate(IFoodInfo foodInfo) {
		dao.update(foodInfo);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#list()
	 */
	public List<IFoodInfo> list() {
		return dao.loadAll(IFoodInfo.class);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#listResources(long)
	 */
	public List<IFoodResource> listResources(long infoId) {
		IFoodInfo foodInfo = this.get(infoId);
		return foodInfo.listResources();
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#addResources(long, net.lw.meetlove.api.entity.IFoodResources)
	 */
	public IFoodResource addResource(long infoId, IFoodResource resources) {
		IFoodInfo foodInfo = this.get(infoId);
		resources.setFoodInfo(foodInfo);
		return dao.save(resources);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#removeResources(long, long)
	 */
	public void removeResource(long resourceId) {
		dao.delete(resourceId, FoodResource.class);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#removeAllResources(long)
	 */
	public void removeAllResources(long infoId) {
		String hql = "delete FoodResource r where r.foodInfo.id = :infoId";
		dao.getHibernateSession().createQuery(hql)
								.setLong("infoId", infoId)
								.executeUpdate();

	}

}
