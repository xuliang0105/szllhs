package com.yzjk.system.sys.entity;

import java.io.Serializable;

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
 * @date 2019-04-25 11:56:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("role_resource")
public class RoleResource extends Model<RoleResource> implements Serializable{
private static final long serialVersionUID = 1L;

    /**
   * 
   */
    @TableId(type = IdType.INPUT)
    private Long roleId;
    /**
   * 
   */
    private Long resourceId;
  
}
