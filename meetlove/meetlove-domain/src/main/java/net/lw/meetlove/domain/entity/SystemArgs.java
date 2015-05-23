/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月24日 上午2:20:22
 */
package net.lw.meetlove.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import net.lw.meetlove.api.entity.ISystemArgs;
import net.lw.meetlove.api.entity.SystemArgsType;

/**
 * @author liuwei
 *
 */

@Entity
@Table(name="ML_SYSTEM_ARGS")
public class SystemArgs implements ISystemArgs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "SEQ_ML_SYSTEMARGS")
	@SequenceGenerator(name="SEQ_ML_SYSTEMARGS",sequenceName="SEQ_ML_SYSTEMARGS")
	@Column(name="ID")
	private long id;

	@Column(name="NAME",nullable = false)
	private String name;

	@Column(name="VALUE",nullable = false)
	private String value;

	@Column(name="REMARK",nullable = false)
	private String remark;

	@Column(name="TYPE",nullable = false)
	private SystemArgsType type;
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




}
