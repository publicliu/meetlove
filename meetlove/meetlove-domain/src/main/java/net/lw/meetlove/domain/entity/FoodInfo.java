/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月20日 下午9:16:05
 */
package net.lw.meetlove.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import net.lw.meetlove.api.entity.FoodStatus;
import net.lw.meetlove.api.entity.IFoodClassify;
import net.lw.meetlove.api.entity.IFoodInfo;
import net.lw.meetlove.api.entity.IFoodResources;

/**
 * @author liuwei
 *
 */
@Entity
@Table(name = "ML_FOODINFO")
public class FoodInfo implements IFoodInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "SEQ_ML_FOODINFO")
	@SequenceGenerator(name="SEQ_ML_FOODINFO",sequenceName="SEQ_ML_FOODINFO")
	@Column(name="ID")
	private long id;

	@Column(name="NAME",nullable = false)
	private String name;

	@Column(name="REMARK",nullable = true)
	private String remark;

	@Column(name = "STATUS")
	private FoodStatus status;

	@ManyToOne(fetch = FetchType.LAZY,targetEntity= net.lw.meetlove.domain.entity.FoodClassify.class)
	@JoinColumn(name="CLASSIFY_ID")
	private IFoodClassify classify;


	@OneToMany(mappedBy="foodInfo",targetEntity=FoodResources.class)
	private List<IFoodResources> resources = new ArrayList<IFoodResources>();
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
	 * @return the desc
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param desc the desc to set
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
	 * @return the classify
	 */
	public IFoodClassify getClassify() {
		return classify;
	}
	/**
	 * @param classify the classify to set
	 */
	public void setClassify(IFoodClassify classify) {
		this.classify = classify;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(FoodStatus status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.entity.IFoodInfo#listResources()
	 */
	public List<IFoodResources> listResources() {
		return this.resources;
	}



}
