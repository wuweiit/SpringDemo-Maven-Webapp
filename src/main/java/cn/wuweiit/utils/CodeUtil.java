package cn.wuweiit.utils;

import java.util.UUID;

import cn.wuweiit.security.MD5;

public class CodeUtil {

	
	/**
	 * 
	 * @return
	 */
	public static String get32bit(){
		String code = UUID.randomUUID().toString().replaceAll("-", "");
		return code.toUpperCase(); 
	}
	
	public static String get16bit(){
		String code = MD5.getMD5Code(get32bit()).substring(8, 24 );
		return code.toUpperCase(); 
	}
	
	
	public static String get4Random(){ 
		int a = (int) (Math.random() * 10000);
		return String.valueOf(a).toUpperCase(); 
	}
	
	
	// UUID
	public static String getUUID64(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	
}
