/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月22日 上午2:40:36
 */
package net.lw.meetlove.web.admin.goods.form;

import java.util.ArrayList;
import java.util.List;

import net.lw.meetlove.api.entity.FoodStatus;
import net.lw.meetlove.api.entity.IFoodClassify;


/**
 * @author liuwei
 *
 */
public class ClassifyForm {

	private long id;
	private String name;
	private String remark;
	private FoodStatus status;


	public ClassifyForm() {}


	/**
	 * @param id
	 * @param name
	 * @param remark
	 * @param status
	 */
	public ClassifyForm(long id, String name, String remark, FoodStatus status) {
		this.id = id;
		this.name = name;
		this.remark = remark;
		this.status = status;
	}

	public static ClassifyForm toForm(IFoodClassify classify){
		return new ClassifyForm(
				classify.getId(),
				classify.getName(),
				classify.getRemark(),
				classify.getStatus());
	}

	public static List<ClassifyForm> toForms(List<IFoodClassify> classifies){
		List<ClassifyForm> result = new ArrayList<ClassifyForm>();
		for(IFoodClassify classify : classifies){
			result.add(toForm(classify));
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
	public FoodStatus getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(FoodStatus status) {
		this.status = status;
	}





}
