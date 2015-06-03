/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月27日 上午10:41:17
 */
package net.lw.meetlove.web.admin.goods.form;

import java.util.ArrayList;
import java.util.List;

import net.lw.meetlove.api.entity.IItemResource;
import net.lw.meetlove.api.entity.ItemResourceType;

/**
 * @author liuwei
 *
 */
public class ResourceForm {

	private long id;
	private String name;
	private ItemResourceType type;

	/**
	 *
	 */
	public ResourceForm() {}

	/**
	 * @param id
	 * @param name
	 * @param type
	 */
	public ResourceForm(long id, String name, ItemResourceType type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}


	public static ResourceForm toForm(IItemResource resource){
		return new ResourceForm(resource.getId(), resource.getName(), resource.getType());
	}

	public static List<ResourceForm> toForms(List<IItemResource> resources){
		List<ResourceForm> result = new ArrayList<ResourceForm>();
		for(IItemResource resource : resources){
			result.add(toForm(resource));
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
	 * @return the type
	 */
	public ItemResourceType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(ItemResourceType type) {
		this.type = type;
	}



}
