package com.yzjk.system.order.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yzjk.system.order.entity.OrderInfo;
import com.yzjk.system.order.service.OrderInfoService;

import lombok.AllArgsConstructor;

/**
 * 
 *
 * @author yzjk code generator
 * @date 2019-04-10 15:49:16
 */
@RestController
@AllArgsConstructor
@RequestMapping("/orderinfo")
public class OrderInfoController {

  	private final OrderInfoService orderInfoService;

  	
  	/**
  	 * 获取订单信息
  	 * @return
  	 */
  	@GetMapping("/getByOrderInfo")
  	public String getByOrderInfo(HttpServletRequest request,Model model,OrderInfo orderInfo) {
  		//判断是否登录 
  		 
  		//未登录
  			//return "redirect:userInfo/userLogin?loginAfterUrl="+request.getRequestURI();
  		//判断角色类型
  		//如果是用户则是买方，如果是医生，则是卖方	
  		//查询
  		 model.addAttribute("orderList",orderInfoService.getByOrderList(orderInfo));
  		 return "order/orderlist"; 
  		
  	}
  	
  	
  	/**
   	* 通过id查询单条记录
   	* @param orderId
   	* @return R
   	*/
  	@GetMapping("/{orderId}")
  	public String getById(@PathVariable("orderId") Long orderId,Model model){
  		model.addAttribute("orderDetail", orderInfoService.getById(orderId));
    	return "order/orderdetail";
  	}

}
