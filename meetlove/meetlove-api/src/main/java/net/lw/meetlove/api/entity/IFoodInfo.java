package net.lw.meetlove.api.entity;

import java.util.List;

public interface IFoodInfo {

	public long getId();

	public String getName();

	public void setName(String name);

	public String getRemark();

	public void setRemark(String remark);

	public void setStatus(FoodStatus foodStatus);
	public FoodStatus getStatus();

	public void setClassify(IFoodClassify classify);
	public IFoodClassify getClassify();

	public List<IFoodResource> listResources();
}
