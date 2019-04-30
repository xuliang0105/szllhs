package com.yzjk.system.sys.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzjk.common.ehcache.EhCacheProvider;
import com.yzjk.system.sys.entity.Resource;
import com.yzjk.system.sys.entity.Role;
import com.yzjk.system.sys.entity.RoleResource;
import com.yzjk.system.sys.entity.SysUser;
import com.yzjk.system.sys.entity.UserRole;
import com.yzjk.system.sys.mapper.UserMapper;
import com.yzjk.system.sys.service.ResourceService;
import com.yzjk.system.sys.service.RoleResourceService;
import com.yzjk.system.sys.service.RoleService;
import com.yzjk.system.sys.service.UserRoleService;
import com.yzjk.system.sys.service.UserService;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService{

	@Autowired private UserRoleService userRoleService;
	@Autowired private RoleService roleService;
	@Autowired private RoleResourceService roleResourceService;
	@Autowired private ResourceService resourceService;
	
	@Override
	public SysUser getUserByName(String userName) {
		SysUser user = null;
		if(StringUtils.isNotEmpty(userName)) {
			user = getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUserName,userName));
			user = getUserByUserId(user.getUserId());
			return user;
		}
		return null;
	}

	@Override
	public SysUser getUserByUserId(Long userId) {
		if(userId > 0 ) {
			SysUser user = new SysUser();
			user.setUserId(userId);
			//角色列表
			List<UserRole> userRole = userRoleService.list(Wrappers.<UserRole>query().lambda().eq(UserRole::getUserId,user.getUserId()));
			List<Long> roleIds = userRole.stream().map(UserRole::getRoleId).collect(Collectors.toList());
			if(roleIds != null && roleIds.size() > 0) {
				List<Role> roleList = (List<Role>) roleService.listByIds(roleIds);
				if(roleList!=null && roleList.size() > 0 ) {
					for(Role r : roleList) {
						//资源列表
					  List<RoleResource> roleResource=  roleResourceService.list(Wrappers.<RoleResource>query().lambda().eq(RoleResource::getRoleId,r.getId()));
					  List<Long> resourceIds = roleResource.stream().map(RoleResource::getResourceId).collect(Collectors.toList());
					  List<Resource> resource =(List<Resource>)resourceService.listByIds(resourceIds);
					  r.setResourceList(resource);
					}
					 user.setRoleList(roleList);
					 EhCacheProvider.put("userCache", user.getUserId(), user);
				}
				return user;
			}
		}
		return null;
	}

}
