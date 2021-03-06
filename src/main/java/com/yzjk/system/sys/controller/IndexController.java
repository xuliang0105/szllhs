package com.yzjk.system.sys.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping
public class IndexController {

	//首页
	@RequestMapping(value= {"","/index"})
	public String index(Model model, HttpServletResponse response) {
			log.info("index{}");
		    model.addAttribute("name", "simonsfan");
		    return "index";
		}

}