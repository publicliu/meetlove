/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月20日 下午9:15:37
 */
package net.lw.meetlove.domain.entity;

import java.util.ArrayList;
import java.util.List;

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

/**
 * @author liuwei
 *
 */
@Entity
@Table(name = "ML_GOODS_CLASSIFY" )
public class GoodsClassify implements IGoodsClassify {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="SEQ_ML_GOODSCLASSIFY")
	@SequenceGenerator(name="SEQ_ML_GOODSCLASSIFY",sequenceName="SEQ_ML_GOODSCLASSIFY")
	@Column(name = "ID")
	private long id;

	@Column(name="NAME",nullable = false,length=40)
	private String name;

	@Column(name="REMARK",nullable = true)
	private String remark;

	@Column(name = "STATUS",nullable = false,length=1)
	private GoodsStatus status;

	@Column(name = "SORT",nullable = false)
	private int sort = 0;

	@ManyToOne(fetch = FetchType.LAZY,targetEntity=net.lw.meetlove.domain.entity.GoodsClassify.class)
	@JoinColumn(name="PARENT_ID")
	private IGoodsClassify parent;

	@OneToMany(mappedBy="parent",targetEntity=net.lw.meetlove.domain.entity.GoodsClassify.class)
	private List<IGoodsClassify> childrenClassifies = new ArrayList<IGoodsClassify>();


	@OneToMany(mappedBy="classify",targetEntity=GoodsItem.class)
	private List<IGoodsItem> childrenGoodsItems = new ArrayList<IGoodsItem>();
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
	 * @return the Status
	 */
	public GoodsStatus getStatus() {
		return status;
	}
	/**
	 * @param foodStatus the Status to set
	 */
	public void setStatus(GoodsStatus goodsStatus) {
		this.status = goodsStatus;
	}
	/**
	 * @return the order
	 */
	public int getSort() {
		return sort;
	}
	/**
	 * @param order the order to set
	 */
	public void setSort(int sort) {
		this.sort = sort;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(IGoodsClassify parent) {
		this.parent = parent;
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.entity.IFoodClassify#listClassifyChildren()
	 */
	public List<IGoodsClassify> listClassifyChildren() {
		return this.childrenClassifies;
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.entity.IFoodClassify#listFoodInfoChildren()
	 */
	public List<IGoodsItem> listGoodsItemChildren() {
		return this.childrenGoodsItems;
	}


}
