package com.yzjk.system.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user")
public class User   extends Model<User>{
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
	
    @TableField(exist = false)
    private String confirmPassword;
    
    @TableField(exist = false)
    private String oldPassword;
}
