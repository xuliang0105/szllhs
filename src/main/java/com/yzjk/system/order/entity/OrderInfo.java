package com.yzjk.system.order.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("order_info")
public class OrderInfo extends Model<OrderInfo> {
private static final long serialVersionUID = 1L;

    /**
   * 
   */
    @TableId(type = IdType.INPUT)
    private Long orderId;
    /**
   * 
   */
    private String orderNo;
    /**
   * 
   */
    private Integer orderType;
    /**
   * 
   */
    private Long buyerId;
    /**
   * 
   */
    private Integer buyerType;
    /**
   * 
   */
    private String buyerName;
    /**
   * 
   */
    private Long sellerId;
    /**
   * 
   */
    private Integer sellerType;
    /**
   * 
   */
    private String sellerName;
    /**
   * 
   */
    private BigDecimal orderAmount;
    /**
   * 
   */
    private BigDecimal orderActualAmount;
    /**
   * 
   */
    private Integer orderStatus;
    /**
   * 
   */
    private Date createTime;
    /**
   * 
   */
    private Integer isDel;
    /**
   * 
   */
    private Date delTime;
  
    @TableField(exist = false)
    private List<OrderDetail> orderDetailList;
    
    @TableField(exist = false)
    private List<OrderPay> orderPayList;
    
}
