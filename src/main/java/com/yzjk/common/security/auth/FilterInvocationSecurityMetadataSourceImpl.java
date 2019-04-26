package com.yzjk.common.security.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.yzjk.system.sys.entity.Resource;
import com.yzjk.system.sys.service.ResourceService;

@Service
public class FilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private ResourceService resourceService;

    private HashMap<String, Collection<ConfigAttribute>> map = null;

    /**
     * 加载权限表中所有权限
     */
    public void loadResourceDefine(){

        if (!CollectionUtils.isEmpty(map)) {
            //该缓存通过redis 订阅模式来维护/或者其他自定义方案 TODO
        }

        //如果缓存中没有则从数据库中查询
        map = new HashMap<>();

        //查询所有角色拥有的权限
        List<Resource> resources = resourceService.list();

        for(Resource res : resources) {
            String url = res.getUrl();
            if (!map.containsKey(url)) {
                map.put(url, new ArrayList<>());
            }

            ConfigAttribute cfg = new SecurityConfig(res.getName());
            //此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
            map.get(url).add(cfg);
        }

    }

    //此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        loadResourceDefine();

        Collection<ConfigAttribute> list = null;

        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        System.out.println("session: "+ request.getSession().getId());
        AntPathRequestMatcher matcher;

        List<String> targetUrls = new ArrayList<>();

        for(String resUrl : map.keySet()) {
            matcher = new AntPathRequestMatcher(resUrl);
            // TODO 这儿有坑 /path/{id} 和 /path/info之类的会判断有问题,资源定义的时候通过正则表达
            if(matcher.matches(request)) {
                targetUrls.add(resUrl);
            }
        }
        if (targetUrls.size() == 1) {
            list = map.get(targetUrls.get(0));
        } else if (targetUrls.size() > 1) {
            String reqUrl = request.getServletPath();
            for (String url : targetUrls) {
                if (reqUrl.equals(url)) {
                    list = map.get(url);
                }
            }
        }
        return list;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}