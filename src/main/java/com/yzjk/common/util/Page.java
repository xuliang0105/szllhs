package com.yzjk.common.util;

import org.apache.ibatis.session.RowBounds;


/**
 * 分页辅助对象,继承了mybatis的分页辅助对象RowBounds
 * 
 * @author hdr
 * 
 */

public class Page {
	/**
	 * 页号，默认为1
	 */
	private Integer num;
	/**
	 * 限制数量，相当于页面大小，默认为10
	 */
	private Integer limit;
	/**
	 * 总页数
	 */
	private Integer sum;
	/**
	 * 总记录数
	 */
	private Integer count;

	/**
	 * 默认的构造函数
	 */
	public Page() {
	    initNumAndLimit();
	}
	/**
	 * 
	 * @param limit 页面大小
	 */
	public Page(Integer limit) {
		this.num = 1;
		this.limit = limit;
		this.initNumAndLimit();
	}

	/**
	 * 
	 * @param num
	 *            页号，从1开始
	 * @param limit
	 *            页面大小
	 */
	public Page(Integer num, Integer limit) {
		this.num = num;
		this.limit = limit;
		this.initNumAndLimit();
	}

	/**
	 * 初始化页号也页面大小
	 */
	public void initNumAndLimit() {
		if (num == null) {
			num = 1;
		}
		if (limit == null) {
			limit = 10;
		}
	}

	/**
	 * 初始化总记录数和总页数
	 * 
	 * @param count
	 *            传入总记录数，会根据
	 */
	public void initCountAndSum(Integer count) {
		this.initNumAndLimit();
		this.count = count;
		this.sum = count % this.limit == 0 ? count / this.limit : count / this.limit + 1;
	}

	/**
	 * 根据设置好的参数初始化一个mybatis的分页对象
	 * 
	 * @return
	 */
	public RowBounds createRowBounds() {
		this.initNumAndLimit();
		return new RowBounds((num - 1) * limit, limit);
	}

	/**
	 * 如果count或num一个不为空则不需要重新设置
	 * 
	 * @return count或sum其中一个不为空则返回true，两个都为空则返回false
	 */
	public boolean hasCountAndSum() {
		return sum != null && count != null;
	}
	
	/**
	 * 获取手动分页时的起始ROWNUM
	 * @return
	 */
	public Integer startRowNum(){
		return (num - 1) * limit;
	}
	
	/**
	 * 获取手动分页时的结束ROWNUM
	 * @return
	 */
	public Integer endRowNum(){
		return num * limit;
	}

	public Integer getCount() {
		return count;
	}

	public Integer getLimit() {
		return limit;
	}

	public Integer getNum() {
		return num;
	}

	public Integer getSum() {
		return sum;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

}
