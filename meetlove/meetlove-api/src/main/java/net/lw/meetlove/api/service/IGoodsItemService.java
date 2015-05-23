package net.lw.meetlove.api.service;

import java.util.List;

import net.lw.meetlove.api.entity.IGoodsItem;
import net.lw.meetlove.api.entity.IItemResource;

public interface IGoodsItemService {

	public IGoodsItem make();

	public IItemResource makeResource();

	public IGoodsItem get(long infoId);

	public IGoodsItem add(IGoodsItem foodInfo);

	public void remove(long id);

	public void udpate(IGoodsItem foodInfo);

	public List<IGoodsItem> list();

	public List<IItemResource> listResources(long infoId);

	public IItemResource addResource(long infoId,IItemResource resource);

	public void removeResource(long resourceId);

	public void removeAllResources(long infoId);

}
