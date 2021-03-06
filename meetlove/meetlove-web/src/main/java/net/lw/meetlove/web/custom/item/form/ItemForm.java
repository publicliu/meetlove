/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月27日 上午10:35:53
 */
package net.lw.meetlove.web.custom.item.form;

import java.util.ArrayList;
import java.util.List;

import net.lw.meetlove.api.entity.GoodsStatus;
import net.lw.meetlove.api.entity.IGoodsItem;
import net.lw.meetlove.web.admin.goods.form.ResourceForm;

/**
 * @author liuwei
 *
 */
public class ItemForm {

	private long id;
	private String name;
	private String remark;
	private GoodsStatus status;
	private List<ResourceForm> resources = new ArrayList<ResourceForm>();



	/**
	 * @param id
	 * @param name
	 * @param remark
	 * @param status
	 * @param resources
	 */
	public ItemForm(long id, String name, String remark,
			GoodsStatus status, List<ResourceForm> resources) {
		this.id = id;
		this.name = name;
		this.remark = remark;
		this.status = status;
		this.resources = resources;
	}



	public static ItemForm toForm(IGoodsItem item){
		return new ItemForm(
				item.getId(),
				item.getName(),
				item.getRemark(),
				item.getStatus(),
				ResourceForm.toForms(item.listResources())
				);
	}

	public static List<ItemForm> toForms(List<IGoodsItem> items){
		List<ItemForm> result = new ArrayList<ItemForm>();
		for(IGoodsItem item : items){
			result.add(toForm(item));
		}
		return result;
	}



	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}



	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}



	/**
	 * @return the status
	 */
	public GoodsStatus getStatus() {
		return status;
	}



	/**
	 * @param status the status to set
	 */
	public void setStatus(GoodsStatus status) {
		this.status = status;
	}



	/**
	 * @return the resources
	 */
	public List<ResourceForm> getResources() {
		return resources;
	}



	/**
	 * @param resources the resources to set
	 */
	public void setResources(List<ResourceForm> resources) {
		this.resources = resources;
	}






}
