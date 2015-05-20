package net.lw.meetlove.api.entity;

import java.util.List;

public interface IFoodClassify {

	public long getId();

	public void setName(String name);

	public String getName();

	public void setRemark(String remark);

	public String getRemark();

	public void setStatus(FoodStatus foodStatus);

	public FoodStatus getStatus();

	public void setSort(int sort);

	public int getSort();

	public List<IFoodClassify> listClassifyChildren();

	public List<IFoodInfo> listFoodInfoChildren();

}
