package cn.wuweiit.utils;

import cn.wuweiit.domain.Page;

public class PageUtil {

	
	public static Page transformPageObject(com.github.pagehelper.Page page) { 
		Page page2 = new Page(page.getPageNum(), page.getTotal(), page.getPageSize()); 
		page2.setData(page.getResult()); 
		return page2;
	}
}
