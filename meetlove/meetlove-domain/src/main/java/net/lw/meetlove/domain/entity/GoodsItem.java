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

import net.lw.meetlove.api.entity.GoodsStatus;
import net.lw.meetlove.api.entity.IGoodsClassify;
import net.lw.meetlove.api.entity.IGoodsItem;
import net.lw.meetlove.api.entity.IItemResource;

/**
 * @author liuwei
 *
 */
@Entity
@Table(name = "ML_GOODS_ITEM")
public class GoodsItem implements IGoodsItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "SEQ_ML_GOODSITEM")
	@SequenceGenerator(name="SEQ_ML_GOODSITEM",sequenceName="SEQ_ML_GOODSITEM")
	@Column(name="ID")
	private long id;

	@Column(name="NAME",nullable = false)
	private String name;

	@Column(name="REMARK",nullable = true)
	private String remark;

	@Column(name = "STATUS")
	private GoodsStatus status;

	@Column(name = "PRICE")
	private long price;

	@Column(name = "OLD_PRICE")
	private long oldPrice;


	@ManyToOne(fetch = FetchType.LAZY,targetEntity= net.lw.meetlove.domain.entity.GoodsClassify.class)
	@JoinColumn(name="CLASSIFY_ID")
	private IGoodsClassify classify;


	@OneToMany(mappedBy="goodsItem",targetEntity=ItemResource.class)
	private List<IItemResource> resources = new ArrayList<IItemResource>();
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
	public GoodsStatus getStatus() {
		return status;
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
	 * @return the classify
	 */
	public IGoodsClassify getClassify() {
		return classify;
	}
	/**
	 * @param classify the classify to set
	 */
	public void setClassify(IGoodsClassify classify) {
		this.classify = classify;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(GoodsStatus status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.entity.IFoodInfo#listResources()
	 */
	public List<IItemResource> listResources() {
		return this.resources;
	}



}
