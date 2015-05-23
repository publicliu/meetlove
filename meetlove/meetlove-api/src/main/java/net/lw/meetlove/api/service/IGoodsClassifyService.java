package net.lw.meetlove.api.service;

import java.util.List;

import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;
import net.lw.meetlove.api.entity.IGoodsClassify;
import net.lw.meetlove.api.entity.IGoodsItem;

public interface IGoodsClassifyService {

	public IGoodsClassify make();

	public IGoodsClassify get(long classifyId);

	public IGoodsClassify add(IGoodsClassify classify);

	public void remove(IGoodsClassify classify);

	public void remove(long id);

	public void update(IGoodsClassify classify);

	public List<IGoodsClassify> list();

	public IPageResult<IGoodsClassify> page(int offset,int limit,IFilter filter);

	public List<IGoodsItem> listGoodsItems(long classifyId);

	public List<IGoodsClassify> listChildrenClassifies(long classifyId);

	public List<IGoodsClassify> listFirstChildrenClassifies();

}
