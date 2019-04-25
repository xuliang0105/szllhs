package com.yzjk.system.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yzjk.system.sys.service.RoleService;

import lombok.AllArgsConstructor;

/**
 * 
 *
 * @author yzjk code generator
 * @date 2019-04-25 11:56:15
 */
@RestController
@AllArgsConstructor
@RequestMapping("/role")
public class RoleController {

  	private final RoleService roleService;
 
}
