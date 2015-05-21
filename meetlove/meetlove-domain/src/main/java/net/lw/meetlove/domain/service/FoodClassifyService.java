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
import net.lw.meetlove.api.entity.IFoodClassify;
import net.lw.meetlove.api.entity.IFoodInfo;
import net.lw.meetlove.api.service.IFoodClassifyService;
import net.lw.meetlove.domain.entity.FoodClassify;

/**
 * @author liuwei
 *
 */
@Service
@Transactional
public class FoodClassifyService implements IFoodClassifyService {

	@Autowired
	private IGenericDao dao;

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#make()
	 */
	public IFoodClassify make() {
		return new FoodClassify();
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#add(net.lw.meetlove.api.entity.IFoodClassify)
	 */
	public IFoodClassify add(IFoodClassify foodClassify) {
		return dao.save(foodClassify);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#get(long)
	 */
	public IFoodClassify get(long classifyId) {
		return dao.load(classifyId, FoodClassify.class);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#remove(long)
	 */
	public void remove(long id) {
		dao.delete(id, FoodClassify.class);
	}

	public void remove(IFoodClassify foodClassify){
		dao.delete(foodClassify);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#update(net.lw.meetlove.api.entity.IFoodClassify)
	 */
	public void update(IFoodClassify foodClassify) {
		dao.update(foodClassify);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#list()
	 */
	public List<IFoodClassify> list() {
		return dao.loadAll(IFoodClassify.class);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#listFoodInfos(long)
	 */
	public List<IFoodInfo> listFoodInfos(long classifyId) {
		IFoodClassify classify = this.get(classifyId);
		return classify.listFoodInfoChildren();
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#listChildrenClassifies(long)
	 */
	public List<IFoodClassify> listChildrenClassifies(long classifyId) {
		IFoodClassify classify = this.get(classifyId);
		return classify.listClassifyChildren();
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.IFoodClassifyService#page(int, int, net.lw.ice.common.IFilter)
	 */
	public IPageResult<IFoodClassify> page(int offset, int limit, IFilter filter) {
		return dao.page(offset, limit, filter, FoodClassify.class);
	}

}
