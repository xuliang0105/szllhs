package com.yzjk.system.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yzjk.system.sys.service.ResourceService;

import lombok.AllArgsConstructor;

/**
 * 
 *
 * @author yzjk code generator
 * @date 2019-04-25 11:56:30
 */
@RestController
@AllArgsConstructor
@RequestMapping("/resource")
public class ResourceController {

  	private final ResourceService resourceService;


}
