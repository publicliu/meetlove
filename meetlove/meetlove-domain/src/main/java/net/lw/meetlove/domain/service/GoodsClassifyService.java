/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月20日 下午9:18:34
 */
package net.lw.meetlove.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;
import net.lw.ice.domain.dao.IGenericDao;
import net.lw.meetlove.api.entity.IGoodsClassify;
import net.lw.meetlove.api.entity.IGoodsItem;
import net.lw.meetlove.api.service.IGoodsClassifyService;
import net.lw.meetlove.domain.entity.GoodsClassify;

/**
 * @author liuwei
 *
 */
@Service
@Transactional
public class GoodsClassifyService implements IGoodsClassifyService {

	@Autowired
	private IGenericDao dao;

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#make()
	 */
	public IGoodsClassify make() {
		return new GoodsClassify();
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#add(net.lw.meetlove.api.entity.IFoodClassify)
	 */
	public IGoodsClassify add(IGoodsClassify foodClassify) {
		return dao.save(foodClassify);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#get(long)
	 */
	public IGoodsClassify get(long classifyId) {
		return dao.load(classifyId, GoodsClassify.class);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#remove(long)
	 */
	public void remove(long id) {
		dao.delete(id, GoodsClassify.class);
	}

	public void remove(IGoodsClassify foodClassify){
		dao.delete(foodClassify);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#update(net.lw.meetlove.api.entity.IFoodClassify)
	 */
	public void update(IGoodsClassify foodClassify) {
		dao.update(foodClassify);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#list()
	 */
	public List<IGoodsClassify> list() {
		return dao.loadAll(IGoodsClassify.class);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#listFoodInfos(long)
	 */
	public List<IGoodsItem> listFoodInfos(long classifyId) {
		IGoodsClassify classify = this.get(classifyId);
		return classify.listFoodInfoChildren();
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#listChildrenClassifies(long)
	 */
	public List<IGoodsClassify> listChildrenClassifies(long classifyId) {
		IGoodsClassify classify = this.get(classifyId);
		return classify.listClassifyChildren();
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#page(int, int, net.lw.ice.common.IFilter)
	 */
	public IPageResult<IGoodsClassify> page(int offset, int limit, IFilter filter) {
		return dao.page(offset, limit, filter, GoodsClassify.class);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#listFirstChildrenClassifies()
	 */
	public List<IGoodsClassify> listFirstChildrenClassifies() {
		String hql = "from FoodClassify f where f.parent.id is null";
		return dao.findByHQL(hql);
	}

}
