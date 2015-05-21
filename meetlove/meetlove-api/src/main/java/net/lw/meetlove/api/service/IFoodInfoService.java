package net.lw.meetlove.api.service;

import java.util.List;

import net.lw.meetlove.api.entity.IFoodInfo;
import net.lw.meetlove.api.entity.IFoodResource;

public interface IFoodInfoService {

	public IFoodInfo make();

	public IFoodResource makeResource();

	public IFoodInfo get(long infoId);

	public IFoodInfo add(IFoodInfo foodInfo);

	public void remove(long id);

	public void udpate(IFoodInfo foodInfo);

	public List<IFoodInfo> list();

	public List<IFoodResource> listResources(long infoId);

	public IFoodResource addResource(long infoId,IFoodResource resource);

	public void removeResource(long resourceId);

	public void removeAllResources(long infoId);

}
