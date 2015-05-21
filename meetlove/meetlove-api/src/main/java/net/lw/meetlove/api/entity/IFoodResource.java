package net.lw.meetlove.api.entity;

public interface IFoodResource {

	public long getId();

	public String getName();

	public void setName(String name);

	public FoodResourceType getType();

	public void setType(FoodResourceType type);

	public void setFoodInfo(IFoodInfo foodInfo);
	public IFoodInfo getFoodInfo();


}
