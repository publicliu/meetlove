package net.lw.meetlove.api.service;

import java.util.List;

import net.lw.meetlove.api.entity.IGoodsItem;
import net.lw.meetlove.api.entity.IItemResource;

public interface IGoodsItemService {

	public IGoodsItem make();

	public IItemResource makeResource();

	public IGoodsItem get(long itemId);

	public IGoodsItem add(IGoodsItem goodsItem);

	public void remove(long id);

	public void udpate(IGoodsItem goodsItem);

	public List<IGoodsItem> list();

	public List<IItemResource> listResources(long itemId);

	public IItemResource addResource(long itemId,IItemResource resource);

	public void removeResource(long resourceId);

	public void removeAllResources(long itemId);

}
