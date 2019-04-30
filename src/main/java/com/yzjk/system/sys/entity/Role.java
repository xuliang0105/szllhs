package com.yzjk.system.sys.entity;

import java.io.Serializable;
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
 * @date 2019-04-25 11:56:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("role")
public class Role extends Model<Role> implements Serializable{
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
    private Long pid;
  
    @TableField(exist = false)
    private List<Resource> resourceList;
}
