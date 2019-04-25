package com.yzjk.system.sys.entity;


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
 * @date 2019-04-25 11:56:30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("resource")
public class Resource extends Model<Resource> {
private static final long serialVersionUID = 1L;

    /**
   * 
   */
    @TableId(type = IdType.INPUT)
    private Long id;
    /**
   * 
   */
    private String name;
    /**
   * 
   */
    private String remark;
    /**
   * 
   */
    private Integer seq;
    /**
   * 
   */
    private String url;
    /**
   * 
   */
    private String method;
    /**
   * 
   */
    private Long pid;
    /**
   * 
   */
    private Integer type;
  
}
