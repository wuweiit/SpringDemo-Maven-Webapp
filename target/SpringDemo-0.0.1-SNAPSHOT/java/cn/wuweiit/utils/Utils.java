package cn.wuweiit.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	/**
	 * 验证输入的邮箱格式是否符合
	 * 
	 * @param email
	 * @return 是否合法
	 */
	public static boolean emailFormat(String email) {
		boolean tag = true;
		final String pattern1 = "^([_a-z0-9A-Z]+[-|\\.]?)+[_a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		final Pattern pattern = Pattern.compile(pattern1);
		final Matcher mat = pattern.matcher(email);
		if (!mat.find()) {
			tag = false;
		}
		return tag;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(Utils.emailFormat("dsad_sads@qq.com"));
		
		
	}
	
	
	public static String getString(String keyword) throws Exception{
		if(keyword != null && !"".equals(keyword)){
			return new String(keyword.getBytes("ISO-8859-1"),"utf-8"); 
		}
		return "";
	}
}
