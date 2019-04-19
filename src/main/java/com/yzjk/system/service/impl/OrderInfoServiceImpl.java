package com.yzjk.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzjk.system.entity.OrderInfo;
import com.yzjk.system.mapper.OrderInfoMapper;
import com.yzjk.system.service.OrderInfoService;

/**
 * 
 *
 * @author yzjk code generator
 * @date 2019-04-10 15:49:16
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

	/**
	 * 查订单列表
	 */
	@Override
	public List<OrderInfo> getByOrderList(OrderInfo orderInfo) {
		QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<OrderInfo>();
		queryWrapper.setEntity(orderInfo);
		List<OrderInfo> orderInfoList = list(queryWrapper);
		return orderInfoList;
	}
	
}
