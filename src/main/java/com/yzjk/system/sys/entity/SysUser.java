package com.yzjk.system.sys.entity;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
public class SysUser   extends Model<SysUser>{
	private static final long serialVersionUID = 1L;
    @TableId(type = IdType.INPUT)
    private Long userId;
    /**
   * 
   */
    private String userName;
    /**
   * 
   */
    private String password;
    /**
   * 
   */
    private String name;
    /**
   * 
   */
    private String idcard;
    /**
   * 
   */
    private String mobilePhone;
    /**
   * 
   */
    private String email;
    /**
   * 
   */
    private Integer userStatus;
    /**
   * 
   */
    private Date createTime;
	
    private List<Role> roleList;
    
    @TableField(exist = false)
    private String confirmPassword;
    
    @TableField(exist = false)
    private String oldPassword;
}
