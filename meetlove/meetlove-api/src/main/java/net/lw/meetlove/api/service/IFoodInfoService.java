package net.lw.meetlove.api.service;

import java.util.List;

import net.lw.meetlove.api.entity.IFoodInfo;
import net.lw.meetlove.api.entity.IFoodResources;

public interface IFoodInfoService {

	public IFoodInfo make();

	public IFoodInfo get(long infoId);

	public IFoodInfo add(IFoodInfo foodInfo);

	public void remove(long id);

	public void udpate(IFoodInfo foodInfo);

	public List<IFoodInfo> list();

	public List<IFoodResources> listResources(long infoId);

	public IFoodResources addResources(long infoId,IFoodResources resources);

	public void removeResources(long resourceId);

	public void removeAllResources(long infoId);

}
