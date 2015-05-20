package net.lw.meetlove.api.entity;

public interface IFoodResources {

	public long getId();

	public String getName();

	public void setName(String name);

	public FoodResourcesType getType();

	public void setType(FoodResourcesType type);

}
