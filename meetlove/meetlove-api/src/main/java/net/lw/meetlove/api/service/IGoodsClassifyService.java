package net.lw.meetlove.api.service;

import java.util.List;

import com.sun.org.apache.xml.internal.security.Init;

import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;
import net.lw.meetlove.api.entity.IGoodsClassify;
import net.lw.meetlove.api.entity.IGoodsItem;

public interface IGoodsClassifyService {

	public IGoodsClassify make();

	public IGoodsClassify get(long classifyId);

	public IGoodsClassify add(IGoodsClassify foodClassify);

	public void remove(IGoodsClassify foodClassify);

	public void remove(long id);

	public void update(IGoodsClassify foodClassify);

	public List<IGoodsClassify> list();

	public IPageResult<IGoodsClassify> page(int offset,int limit,IFilter filter);

	public List<IGoodsItem> listFoodInfos(long classifyId);

	public List<IGoodsClassify> listChildrenClassifies(long classifyId);

	public List<IGoodsClassify> listFirstChildrenClassifies();

}
