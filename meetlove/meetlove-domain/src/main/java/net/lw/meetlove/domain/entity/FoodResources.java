/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月20日 下午9:16:22
 */
package net.lw.meetlove.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import net.lw.meetlove.api.entity.FoodResourcesType;
import net.lw.meetlove.api.entity.IFoodInfo;
import net.lw.meetlove.api.entity.IFoodResources;

/**
 * @author liuwei
 *
 */
@Entity
@Table(name="ML_FOODRESOURCES")
public class FoodResources implements IFoodResources {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "SEQ_ML_FOODRESOURCES")
	@SequenceGenerator(name="SEQ_ML_FOODRESOURCES",sequenceName="SEQ_ML_FOODRESOURCES")
	@Column(name="ID")
	private long id;

	@Column(name="NAME",nullable = false)
	private String name;

	@Column(name="type",nullable = false)
	private FoodResourcesType type;


	@ManyToOne(fetch = FetchType.LAZY,targetEntity = net.lw.meetlove.domain.entity.FoodInfo.class)
	@JoinColumn(name="infoId")
	private IFoodInfo foodInfo;



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
	public FoodResourcesType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(FoodResourcesType type) {
		this.type = type;
	}
	/**
	 * @return the foodInfo
	 */
	public IFoodInfo getFoodInfo() {
		return foodInfo;
	}
	/**
	 * @param foodInfo the foodInfo to set
	 */
	public void setFoodInfo(IFoodInfo foodInfo) {
		this.foodInfo = foodInfo;
	}







}
