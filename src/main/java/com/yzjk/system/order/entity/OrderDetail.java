package com.yzjk.system.order.entity;

import java.math.BigDecimal;

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
@TableName("order_detail")
public class OrderDetail extends Model<OrderDetail> {
private static final long serialVersionUID = 1L;

    /**
   * 
   */
    @TableId(type = IdType.INPUT)
    private Long orderDetailId;
    /**
   * 
   */
    private Long orderId;
    /**
   * 
   */
    private Long bizId;
    /**
   * 
   */
    private Integer bizType;
    /**
   * 
   */
    private BigDecimal price;
    /**
   * 
   */
    private BigDecimal discountPrice;
    /**
   * 
   */
    private Integer qty;
    /**
   * 
   */
    private String itemName;
    /**
   * 
   */
    private String itemPic;
  
}
