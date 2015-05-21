package net.lw.meetlove.api.service;

import java.util.List;

import net.lw.meetlove.api.entity.IFoodClassify;
import net.lw.meetlove.api.entity.IFoodInfo;

public interface IFoodClassifyService {

	public IFoodClassify make();

	public IFoodClassify get(long classifyId);

	public IFoodClassify add(IFoodClassify foodClassify);

	public void remove(IFoodClassify foodClassify);

	public void remove(long id);

	public void update(IFoodClassify foodClassify);

	public List<IFoodClassify> list();

	public List<IFoodInfo> listFoodInfos(long classifyId);

	public List<IFoodClassify> listChildrenClassifies(long classifyId);

}
