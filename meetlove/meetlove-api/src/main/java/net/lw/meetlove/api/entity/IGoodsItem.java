package net.lw.meetlove.api.entity;

import java.util.List;

public interface IGoodsItem {

	public long getId();

	public String getName();

	public void setName(String name);

	public String getRemark();

	public void setRemark(String remark);

	public void setStatus(GoodsStatus goodsStatus);
	public GoodsStatus getStatus();

	public void setClassify(IGoodsClassify classify);
	public IGoodsClassify getClassify();

	public List<IItemResource> listResources();
}
