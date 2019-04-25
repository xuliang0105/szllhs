package com.yzjk.system.order.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author yzjk code generator
 * @date 2019-04-10 15:49:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("order_pay")
public class OrderPay extends Model<OrderPay> {
private static final long serialVersionUID = 1L;

    /**
   * 
   */
    @TableId(type = IdType.INPUT)
    private Long payId;
    /**
   * 
   */
    private Long orderId;
    /**
   * 
   */
    private Integer payType;
    /**
   * 
   */
    private String payBizId;
    /**
   * 
   */
    private String payAccount;
    /**
   * 
   */
    private String collectAccount;
    /**
   * 
   */
    private BigDecimal payMoney;
    /**
   * 
   */
    private String payOrderCreateTime;
    /**
   * 
   */
    private String payTime;
    /**
   * 
   */
    private Date createTime;
  
}
