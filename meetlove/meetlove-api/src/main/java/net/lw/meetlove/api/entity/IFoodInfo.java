package net.lw.meetlove.api.entity;

import java.util.List;

public interface IFoodInfo {

	public long getId();

	public String getName();

	public void setName(String name);

	public String getDesc();

	public void setDesc(String desc);

	public List<IFoodResources> listResources();
}
