package com.yzjk.system.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yzjk.common.util.RestResp;
import com.yzjk.system.sys.entity.SysUser;
import com.yzjk.system.sys.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/userInfo")
//@CacheConfig(cacheNames = {"userCache"})
public class UserController {
	
	@Autowired
    private UserService userService;
	 
		@GetMapping("/userLogin")
		public String userLogin(Model model,String loginAfterUrl){
			model.addAttribute("loginAfterUrl", loginAfterUrl);
		    return "login";
		}
	
		@RequestMapping("/login")
		@ResponseBody
		//@Cacheable(key = "User + login +#p0")
		 public RestResp login(Model model,SysUser user,String loginAfterUrl){
			/*User u = userInfoService.getOne(Wrappers.<User>query()
					.lambda().eq(User::getUserName, user.getUserName())
					.eq(User::getPassword,DigestUtils.md5DigestAsHex(user.getPassword().getBytes())));
			if(u == null) {
				return  RestResp.error(RestResp.ERROR, "登录失败,用户名密码不正确");
			}
			//用户休息存缓存、 角色、资源列表查询
			EhCacheProvider.put("userCache", u.getUserId(), u);
			return RestResp.ok("登陆成功!",loginAfterUrl);*/
			
			SysUser sysUser = userService.getUserByName(user.getUserName());
			return RestResp.ok(sysUser);
	    }
		
		
		@RequestMapping("/userRegister")
		 public String userRegister(Model model,String loginAfterUrl){
			model.addAttribute("loginAfterUrl", loginAfterUrl);
	       return "register";
	    }
		
		@RequestMapping("/register")
		@ResponseBody
		 public RestResp register(Model model,SysUser user,String loginAfterUrl){
			if(StringUtils.isNotEmpty(user.getUserName())) {
				SysUser u = userService.getOne((Wrappers.<SysUser>query()
					.lambda().eq(SysUser::getUserName, user.getUserName())));
				if(u !=null) {
					return RestResp.error(RestResp.ERROR, "用户名已被占用");
				}else if(!user.getPassword().equals(user.getConfirmPassword())){
					return RestResp.error(RestResp.ERROR, "密码不一致");
				}else {
					user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
					userService.save(user);
				}
			}
	       return  RestResp.ok("注册成功",loginAfterUrl);
	    }
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	 
	   @GetMapping("/getUser")
	   public String getUser(Model model){
	        //打印日志
	        log.info("TestController getUser info");
	        model.addAttribute("contents",userService.list());
	        return  "user/userlist";
	    }
	    
	    @GetMapping("/form")
	    public String form(Model model){
	        log.info("ThymeleafUserController form info log start");
	        model.addAttribute("user" , new SysUser());
	        return "/user/form";
	    }
	    
	    @GetMapping("/{id}")
	    public String userview(@PathVariable("id") int id , Model model){
	        SysUser user = userService.getById(id);
	        model.addAttribute("user",user);
	        return "/user/userview";
	    }
	    
	    @PostMapping("/saveUser")
	    public String saveUser(SysUser user){
		/*
		 * log.info("ThymeleafUserController saveUser info log start");
		 * if(StringUtils.isNotEmpty()){ user.setId(IdUtil.generateId());
		 * userInfoService.save(user); }else{ userInfoService.updateById(user); }
		 */
	        return "/common/success";
	    }

	    @GetMapping(value = "/edit/{id}")
	    public String editForm(@PathVariable("id") int id , Model model){
	        log.info("ThymeleafUserController editForm info log start");
	        SysUser user = userService.getById(id);
	        model.addAttribute("user" , user);
	        return "/user/form";
	    }

	    @GetMapping(value = "/delete/{id}")
	    public String delete(@PathVariable("id") int id){
	    	userService.removeById(id);
	        return "/common/success";
	    }

}
