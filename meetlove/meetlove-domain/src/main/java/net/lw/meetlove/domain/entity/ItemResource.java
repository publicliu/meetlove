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

import net.lw.meetlove.api.entity.ItemResourceType;
import net.lw.meetlove.api.entity.IGoodsItem;
import net.lw.meetlove.api.entity.IItemResource;

/**
 * @author liuwei
 *
 */
@Entity
@Table(name="ML_FOODRESOURCE")
public class ItemResource implements IItemResource {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "SEQ_ML_FOODRESOURCES")
	@SequenceGenerator(name="SEQ_ML_FOODRESOURCES",sequenceName="SEQ_ML_FOODRESOURCES")
	@Column(name="ID")
	private long id;

	@Column(name="NAME",nullable = false)
	private String name;

	@Column(name="type",nullable = false)
	private ItemResourceType type;


	@ManyToOne(fetch = FetchType.LAZY,targetEntity = net.lw.meetlove.domain.entity.GoodsItem.class)
	@JoinColumn(name="infoId")
	private IGoodsItem foodInfo;



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
	/**
	 * @return the foodInfo
	 */
	public IGoodsItem getFoodInfo() {
		return foodInfo;
	}
	/**
	 * @param foodInfo the foodInfo to set
	 */
	public void setFoodInfo(IGoodsItem foodInfo) {
		this.foodInfo = foodInfo;
	}







}
