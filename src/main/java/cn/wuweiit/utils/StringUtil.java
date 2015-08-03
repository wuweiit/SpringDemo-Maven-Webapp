package cn.wuweiit.utils;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.druid.util.StringUtils;

public class StringUtil {

	
	
	/**
	 * 隐藏手机号码
	 * @param phone
	 * @return
	 */
	public static String hidePhoneNumber(String phone){
		if(phone == null){
			return "";
		}
		int len = phone.length();
		int size = 4;
		
		if(len > size){
			int pos = len - size;
			String str = phone.substring(0, pos); 
			for(int i=0; i<size; i++){
				str += "*";
			}
			return str;
		}else{
			return phone;
		}
	}
	
	
	
	/**
	 * 转换
	 * @param dotStr
	 * @return
	 */
	public static List<Long> splitDotToLongList(String dotStr){
		if(!StringUtils.isEmpty(dotStr)){
			List<Long> list = new ArrayList<Long>(1);
			String[] qids = dotStr.split(","); 
			for(String qid : qids ){
				if(!"".equals(qid)){ 
					list.add(Long.valueOf(qid));
				}
			}
			return list;
		}
		return null;
	}
}
