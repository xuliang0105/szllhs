package com.yzjk.system.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzjk.system.entity.User;
import com.yzjk.system.mapper.UserMapper;
import com.yzjk.system.service.UserService;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}
