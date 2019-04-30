package com.yzjk.system.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yzjk.system.sys.entity.SysUser;

public interface UserService extends IService<SysUser>{
	
	SysUser getUserByName(String userName);
	
	
	SysUser getUserByUserId(Long userId);
	
}
