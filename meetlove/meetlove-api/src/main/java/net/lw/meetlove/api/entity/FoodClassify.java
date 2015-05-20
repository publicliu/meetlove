package net.lw.meetlove.api.entity;

import java.util.List;

public interface FoodClassify {

	public long getId();

	public void setName(String name);

	public String getName();

	public void setDesc(String desc);

	public String getDesc();

	public void setStatus(FoodStatus foodStatus);

	public FoodStatus getStatus();

	public void setOrder(int order);

	public int getOrder();

	public List<FoodClassify> listClassifyChildren();

	public List<FoodInfo> listFoodInfoChildren();

}
