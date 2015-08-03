package cn.wuweiit.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

	
	/**
	 * 获取Cookie
	 * @param request
	 * @param name
	 * @return
	 */
	public static Cookie getCookie(HttpServletRequest request, String name){
		Cookie[] cos = request.getCookies();
		if(cos != null){
			for(Cookie c : cos){
				if("yqcode".equals(c.getName())){
					return c;
				}
			}
		}
		return null;
	}
}
