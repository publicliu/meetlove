/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月22日 上午2:40:36
 */
package net.lw.meetlove.web.admin.system.form;

import java.util.ArrayList;
import java.util.List;

import net.lw.meetlove.api.entity.GoodsStatus;
import net.lw.meetlove.api.entity.IGoodsClassify;
import net.lw.meetlove.api.entity.ISystemArgs;
import net.lw.meetlove.api.entity.SystemArgsType;


/**
 * @author liuwei
 *
 */
public class ArgsForm {

	private long id;
	private String name;
	private String value;
	private String remark;
	private SystemArgsType type;


	public ArgsForm() {}

	/**
	 * @param id
	 * @param name
	 * @param value
	 * @param remark
	 * @param type
	 */
	public ArgsForm(long id, String name, String value, String remark,
			SystemArgsType type) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.remark = remark;
		if(type == null || type.equals("")){
			this.type = SystemArgsType.CUSTOM;
		}
		else {
			this.type = type;
		}

	}




	public static ArgsForm toForm(ISystemArgs args){
		return new ArgsForm(
				args.getId(),
				args.getName(),
				args.getValue(),
				args.getRemark(),
				args.getType());
	}

	public static List<ArgsForm> toForms(List<ISystemArgs> list){
		List<ArgsForm> result = new ArrayList<ArgsForm>();
		for(ISystemArgs args : list){
			result.add(toForm(args));
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
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the type
	 */
	public SystemArgsType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(SystemArgsType type) {
		this.type = type;
	}







}
