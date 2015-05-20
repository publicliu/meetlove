/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月20日 下午9:15:37
 */
package net.lw.meetlove.domain;

import java.util.List;

import net.lw.meetlove.api.entity.FoodStatus;
import net.lw.meetlove.api.entity.IFoodClassify;
import net.lw.meetlove.api.entity.IFoodInfo;

/**
 * @author liuwei
 *
 */
public class FoodClassify implements IFoodClassify {

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.entity.IFoodClassify#getId()
	 */
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.entity.IFoodClassify#setName(java.lang.String)
	 */
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.entity.IFoodClassify#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.entity.IFoodClassify#setDesc(java.lang.String)
	 */
	public void setDesc(String desc) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.entity.IFoodClassify#getDesc()
	 */
	public String getDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.entity.IFoodClassify#setStatus(net.lw.meetlove.api.entity.FoodStatus)
	 */
	public void setStatus(FoodStatus foodStatus) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.entity.IFoodClassify#getStatus()
	 */
	public FoodStatus getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.entity.IFoodClassify#setOrder(int)
	 */
	public void setOrder(int order) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.entity.IFoodClassify#getOrder()
	 */
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.entity.IFoodClassify#listClassifyChildren()
	 */
	public List<IFoodClassify> listClassifyChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.entity.IFoodClassify#listFoodInfoChildren()
	 */
	public List<IFoodInfo> listFoodInfoChildren() {
		// TODO Auto-generated method stub
		return null;
	}

}
