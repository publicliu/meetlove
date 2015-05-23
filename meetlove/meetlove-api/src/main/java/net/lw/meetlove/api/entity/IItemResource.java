package net.lw.meetlove.api.entity;

public interface IItemResource {

	public long getId();

	public String getName();

	public void setName(String name);

	public ItemResourceType getType();

	public void setType(ItemResourceType type);

	public void setGoodsItem(IGoodsItem goodsItem);
	public IGoodsItem getGoodsItem();


}
