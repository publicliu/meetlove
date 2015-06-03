/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月24日 上午11:16:12
 */
package net.lw.meetlove.web.admin.goods.form;

import java.util.ArrayList;
import java.util.List;

import net.lw.meetlove.api.entity.GoodsStatus;
import net.lw.meetlove.api.entity.IGoodsClassify;
import net.lw.meetlove.api.entity.IGoodsItem;
import net.lw.meetlove.api.entity.IItemResource;

/**
 * @author liuwei
 *
 */
public class ItemForm {

	private long id;
	private String name;
	private String remark;
	private GoodsStatus status;
	private String resourceName;
	private String resourcePath;
	private long classifyId;
	private long price;
	private long oldPrice;
	public ItemForm() {}



	/**
	 * @param id
	 * @param name
	 * @param remark
	 * @param status
	 * @param resourceId
	 * @param resourceName
	 */
	public ItemForm(long id, String name, String remark, GoodsStatus status,
			 String resourceName,long classifyId) {
		this.id = id;
		this.name = name;
		this.remark = remark;
		this.status = status;
		this.resourceName = resourceName;
		this.classifyId = classifyId;
	}


	public static ItemForm toForm(IGoodsItem item){
		ItemForm form = new ItemForm();
		form.setId(item.getId());
		form.setName(item.getName());
		form.setRemark(item.getRemark());
		form.setStatus(item.getStatus());
		form.setPrice(item.getPrice());
		form.setOldPrice(item.getOldPrice());

		IGoodsClassify classify = item.getClassify();
		form.setClassifyId(classify.getId());



		List<IItemResource> resources = item.listResources();
		if(resources.size() == 0){
			form.setResourceName("default.jpg");
		}
		else {
			form.setResourceName(resources.get(0).getName());
		}
		return form;
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
	 * @return the price
	 */
	public long getPrice() {
		return price;
	}



	/**
	 * @param price the price to set
	 */
	public void setPrice(long price) {
		this.price = price;
	}



	/**
	 * @return the oldPrice
	 */
	public long getOldPrice() {
		return oldPrice;
	}



	/**
	 * @param oldPrice the oldPrice to set
	 */
	public void setOldPrice(long oldPrice) {
		this.oldPrice = oldPrice;
	}



	/**
	 * @return the resourceName
	 */
	public String getResourceName() {
		return resourceName;
	}
	/**
	 * @param resourceName the resourceName to set
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
		this.resourcePath = "default.jpg";
	}



	/**
	 * @return the resourcePath
	 */
	public String getResourcePath() {
		return resourcePath;
	}



	/**
	 * @param resourcePath the resourcePath to set
	 */
	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}



	/**
	 * @return the classifyId
	 */
	public long getClassifyId() {
		return classifyId;
	}



	/**
	 * @param classifyId the classifyId to set
	 */
	public void setClassifyId(long classifyId) {
		this.classifyId = classifyId;
	}




}
