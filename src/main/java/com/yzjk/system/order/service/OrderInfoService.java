package com.yzjk.system.order.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yzjk.system.order.entity.OrderInfo;


/**
 * 
 *
 * @author yzjk code generator
 * @date 2019-04-10 15:49:16
 */
public interface OrderInfoService extends IService<OrderInfo> {
	
	/**
	 * 订单列表
	 * @param orderInfo
	 * @return
	 */
	public List<OrderInfo> getByOrderList(OrderInfo orderInfo);
}