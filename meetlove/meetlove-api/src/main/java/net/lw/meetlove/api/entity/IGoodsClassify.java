package net.lw.meetlove.api.entity;

import java.util.List;

public interface IGoodsClassify {

	public long getId();

	public void setName(String name);

	public String getName();

	public void setRemark(String remark);

	public String getRemark();

	public void setStatus(GoodsStatus goodsStatus);

	public GoodsStatus getStatus();

	public void setSort(int sort);

	public int getSort();

	public List<IGoodsClassify> listClassifyChildren();

	public List<IGoodsItem> listGoodsItemChildren();

}
