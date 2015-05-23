/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月20日 下午9:18:52
 */
package net.lw.meetlove.domain.service;

import java.util.List;

import javax.annotation.Resource;

import net.lw.ice.domain.dao.IGenericDao;
import net.lw.meetlove.api.entity.IGoodsItem;
import net.lw.meetlove.api.entity.IItemResource;
import net.lw.meetlove.api.service.IGoodsItemService;
import net.lw.meetlove.domain.entity.GoodsItem;
import net.lw.meetlove.domain.entity.ItemResource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuwei
 *
 */
@Service
@Transactional
public class GoodsItemService implements IGoodsItemService {


	@Resource(name="hibernateDao")
	private IGenericDao dao;

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#make()
	 */
	public IGoodsItem make() {
		return new GoodsItem();
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#makeResource()
	 */
	public IItemResource makeResource() {
		// TODO Auto-generated method stub
		return new ItemResource();
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#get(long)
	 */
	public IGoodsItem get(long infoId) {
		return dao.load(infoId, GoodsItem.class);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#add(net.lw.meetlove.api.entity.IFoodInfo)
	 */
	public IGoodsItem add(IGoodsItem foodInfo) {
		return dao.save(foodInfo);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#remove(long)
	 */
	public void remove(long id) {
		dao.delete(id, GoodsItem.class);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#udpate(net.lw.meetlove.api.entity.IFoodInfo)
	 */
	public void udpate(IGoodsItem foodInfo) {
		dao.update(foodInfo);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#list()
	 */
	public List<IGoodsItem> list() {
		return dao.loadAll(IGoodsItem.class);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#listResources(long)
	 */
	public List<IItemResource> listResources(long infoId) {
		IGoodsItem foodInfo = this.get(infoId);
		return foodInfo.listResources();
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#addResources(long, net.lw.meetlove.api.entity.IFoodResources)
	 */
	public IItemResource addResource(long infoId, IItemResource resources) {
		IGoodsItem foodInfo = this.get(infoId);
		resources.setFoodInfo(foodInfo);
		return dao.save(resources);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodInfoService#removeResources(long, long)
	 */
	public void removeResource(long resourceId) {
		dao.delete(resourceId, ItemResource.class);
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
