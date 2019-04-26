package com.yzjk.common.security.auth;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yzjk.system.sys.entity.Resource;
import com.yzjk.system.sys.entity.Role;
import com.yzjk.system.sys.entity.SysUser;
import com.yzjk.system.sys.service.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    /**
     * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userService.getUserByName(username);
        
        if (null == sysUser) {
            throw new UsernameNotFoundException(username);
        }
        
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Role role: sysUser.getRoleList()) {
        	for(Resource resource: role.getResourceList()) {
        		authorities.add(new SimpleGrantedAuthority(resource.getUrl()));
        	}
        }
        
        return new User(sysUser.getUserName(), sysUser.getPassword(), authorities);
    }
}