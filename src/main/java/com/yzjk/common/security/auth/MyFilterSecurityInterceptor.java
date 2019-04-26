package com.yzjk.common.security.auth;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

public class MyFilterSecurityInterceptor extends FilterSecurityInterceptor{

    public MyFilterSecurityInterceptor(FilterInvocationSecurityMetadataSource securityMetadataSource, AccessDecisionManager accessDecisionManager, AuthenticationManager authenticationManager){
        this.setSecurityMetadataSource(securityMetadataSource);
        this.setAccessDecisionManager(accessDecisionManager);
        this.setAuthenticationManager(authenticationManager);

    }

    /**
     * 里面调用MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法获取fi对应的所有权限
     * 再调用MyAccessDecisionManager的decide方法来校验用户的权限是否足够
     *
     * @param fi 被拦截的url
     */
    public void invoke(FilterInvocation fi) throws IOException, ServletException {
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            //执行下一个拦截器
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
    }
}
