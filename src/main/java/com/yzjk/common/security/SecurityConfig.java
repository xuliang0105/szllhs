package com.yzjk.common.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yzjk.common.security.auth.MyUserDetailsService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    public void configure(WebSecurity web) {
        //如果有不需要设置权限的，就放到web.ignoring() 中
        //permitAll 还是要走所有的过滤器，直到最后一个过滤器FilterSecurityInterceptor 认定是可以放过的，才能访问
        web.ignoring().antMatchers("/config/**", "/css/**", "/fonts/**", "/img/**", "/js/**", "/common/**", "/druid/**", "/actuator/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //  允许所有用户访问"/"和"/index.html"
        http.authorizeRequests()
                .antMatchers("/", "/index.html","/login-error.html","/*/*").permitAll()
                .anyRequest().authenticated()   // 其他地址的访问均需验证权限
                .and()
                .formLogin()
                .loginPage("/login.html")   //  登录页
                .failureUrl("/login-error.html").permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/index.html");
   
        
        //解决不允许显示在iframe的问题
        http.headers().frameOptions().disable();
        
      //开启登陆功能
        http.formLogin().loginPage("/user/login")
                 .loginProcessingUrl("/userInfo/userLogin")//自定义登录页面
                .usernameParameter("userName").passwordParameter("password").permitAll();
        //登陆失败会重定向到/login?error页面

        //开启注销功能
        http.logout().logoutSuccessUrl("/").permitAll();
        //注销成功会去/login?logout页面

        //开启记住我的功能
        http.rememberMe().rememberMeParameter("remember");

        // 关闭csrf
        http.csrf().disable();
        
      //session管理
        //session失效后跳转
        http.sessionManagement().invalidSessionUrl("/userInfo/userLogin");
        //只允许一个用户登录,如果同一个账户两次登录,那么第一个账户将被踢下线,跳转到登录页面
        http.sessionManagement().maximumSessions(1).expiredUrl("/userInfo/userLogin");
        
    }

    /**
     * 自定义认证规则
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	 //不删除凭据，以便记住用户
    	auth.eraseCredentials(false);
    	// 自定义UserDetailsService,设置加密算法
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    
    /**
     * 登录成功后跳转
     * 如果需要根据不同的角色做不同的跳转处理,那么继承AuthenticationSuccessHandler重写方法
     *
     * @return
     */
	/*private SimpleUrlAuthenticationSuccessHandler authenticationSuccessHandler() {
	    return new SimpleUrlAuthenticationSuccessHandler("/loginSuccess");
	}*/

    
    
}