package cn.wuweiit.utils;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 
 * 不修改此类中的成员变量，则线程安全
 * 
 * 
 * 工具类
 * @author marker
 *
 */
public class HttpUtils {

	
	// 代理服务器的HTTP请求协议，客户端真实IP字段名称
	public static final String X_REAL_IP = "x-forwarded-for";
	
	
	/**
	 * 获取请求对象的URL地址
	 * @param request 请求对象
	 * @return String URL地址（http://www.yl-blog.com）
	 */
	public static String getRequestURL(HttpServletRequest request) {
		StringBuilder url  = new StringBuilder();
		String scheme      = request.getScheme();
		String contextPath = request.getContextPath();
		int port           = request.getServerPort();
		url.append(scheme); // http, https
		url.append("://");
		url.append(request.getServerName());
		if (("http".equals(scheme) && port != 80)
				|| ("https".equals(scheme) && port != 443)) {
			url.append(':');
			url.append(request.getServerPort());
		}
		url.append(contextPath);
		return url.toString();
	}
	
	
	
	/**
	 * for nigx返向代理构造 获取客户端IP地址
	 * @param request
	 * @return
	 */
	public static String getRemoteHost(HttpServletRequest request){
		String ip = request.getHeader(X_REAL_IP);// 获取代理IP地址
		return (null == ip)? request.getRemoteHost() : ip; 
	}
	
	
	
	/**
	 * 检查是否有cookieName
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static boolean checkCookie(HttpServletRequest request, String cookieName){
		Cookie cookie;  
		Cookie[] cookies = request.getCookies();
	    if( cookies != null )
	    	for (int i = 0; i < cookies.length; i++){
	    		cookie = cookies[i];
	    		if(cookie.getName().equals(cookieName))
	    			return true;
	    	} 
		return false;
	}
	
	
	
	
	public static String getCookie(HttpServletRequest request, String cookieName){
		Cookie cookie;  
		Cookie[] cookies = request.getCookies();
	    if( cookies != null )
	    	for (int i = 0; i < cookies.length; i++){
	    		cookie = cookies[i];
	    		if(cookie.getName().equals(cookieName))
	    			return cookie.getValue();
	    	} 
		return "";
	}
	
	
	
	/**
	 * 获取语言信息
	 * 
	 * 1. 优先获取URL重写参数
	 * 2. 获取Http请求浏览器语言标识
	 * 
	 * @param request
	 * @return
	 */
	public static String getLanguage(HttpServletRequest request){
		String lang = null;
		HttpSession session = request.getSession(false);
		if(session != null){
			lang = (String) session.getAttribute("lang");
		}
		if(lang == null){
			lang = request.getParameter("lang"); 
		}
		if(lang == null){
			Locale locale = request.getLocale();
			String c = locale.getCountry();
			if(c != null && !"".equals(c)){
				lang = locale.getLanguage()+"-"+ c;
			}else{
				lang = locale.getLanguage();
				
			}
		}
		if(lang == null){
			lang = "zh";
		}
		return lang.toLowerCase();
	}



	/**
	 * 获取IP地址 
	 * @param request
	 * @return
	 */
	public static String getIPAddress(HttpServletRequest request) { 
		return getRemoteHost(request);
	}
	
	
	
	/**
	 * 关闭Http缓存
	 * 
	 * 禁止页面在IE中缓存

		http响应消息头部设置：
		 
		Expires是个好东东，如果服务器上的网页经常变化，就把它设置为-1，表示立即过期。如果一个网页每天凌晨1点更新，可以把Expires设置为第二天的凌晨1点。
		
		当HTTP1.1服务器指定CacheControl = no-cache时，浏览器就不会缓存该网页。
		
		旧式 HTTP 1.0 服务器不能使用 Cache-Control 标题。
		所以为了向后兼容 HTTP 1.0 服务器，IE使用Pragma:no-cache 标题对 HTTP 提供特殊支持。
		如果客户端通过安全连接 (https://)/与服务器通讯，且服务器在响应中返回 Pragma:no-cache 标题，
		则 Internet Explorer不会缓存此响应。注意：Pragma:no-cache 仅当在安全连接中使用时才防止缓存，如果在非安全页中使用，处理方式与 Expires:-1相同，该页将被缓存，但被标记为立即过期。
	 * @param response
	 */
	public static void closeHttpCache(HttpServletResponse response){
		response.setHeader("CacheControl", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1"); 
	}
}
