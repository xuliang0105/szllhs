package com.yzjk.common.util;

import java.util.List;

public class PageUtils {
    
    /**
     * 程序实现分页
     * 
     * @param pageData 被分页的数据
     * @param num 当前页
     * @param limit 每页数据量
     * @return 查询的列表
     */
    public static<T> List<T> page(List<T> pageData, Page page){
	Integer currentPageNo = page.getNum();
	Integer limit = page.getLimit();
	Integer pageSum = pageData.size() % limit == 0 ? pageData.size() / limit : (Integer)(pageData.size() / limit) + 1; //总页数
	page.setCount(pageData.size());
	page.setSum(pageSum);
	
	if(currentPageNo == null || currentPageNo - 1 < 0 || currentPageNo > pageSum){ //如果非法操作，默认跳转至第一页
	    currentPageNo = 1;
	}
	
	if (currentPageNo * limit < pageData.size()){
	    return pageData.subList((currentPageNo - 1) * limit, currentPageNo * limit);
	} else {
	    return pageData.subList((currentPageNo - 1) * limit, pageData.size());	    
	}
    }

}
