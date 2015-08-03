package cn.wuweiit.domain;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wuweiit.alias.StateCode;
import cn.wuweiit.annotation.Text;


/**
 * 消息对象
 * @author marker
 * @version 1.0
 * 
 * @update 2015-02-11 添加了code属性，描述错误码，绑定国际化资源
 */
public class MessageResult {
	
	/** 日志记录器 */ 
	private Logger logger = LoggerFactory.getLogger(getClass()); 
	

	/** 消息内容缓存区 */
	private static final Map<Integer, String> messages = new HashMap<Integer, String>();
	
	
	/** 状态 */
	protected int status;
	
	/** 消息内容 */
	protected String msg;
	
	/** 消息 */
	protected Object results;
	
	
	/**
	 * 消息
	 * @param boolean status
	 * @param String message
	 * */
	public MessageResult(Object results){
		this.status = StateCode.OperationSuccess;
		this.results = results;
	}
	
	
	
	/**
	 * 针对返回多个错误码的接口设计
	 * @param status
	 * @param errorcode
	 */
	public MessageResult(String[] errorcode){
		this.status = StateCode.OperationError;
		this.results = errorcode;
	}
	
	
	/**
	 * 针对返回多个错误码的接口设计
	 * @param status
	 * @param errorcode
	 */
	public MessageResult(int status){
		this.status = status;
	}


 


 


	/**
	 * 默认操作成功消息
	 */
	public MessageResult() {
		this.status = StateCode.OperationSuccess;
	}



	/**
	 * 通用操作成功与操作失败处理方法
	 * （当status=true时， 状态码为：0）
	 * （当status=false时，状态码为：100500 ）
	 * 
	 * @param status 状态
	 * @param message 消息
	 */
	public MessageResult(boolean status, String results) {
		if(status){
			this.status = StateCode.OperationSuccess;
		}else{
			this.status = StateCode.OperationError;
		}
		this.results = results;
		
	}



	public MessageResult(boolean status, Object results) {
		if(status){
			this.status = StateCode.OperationSuccess;
		}else{
			this.status = StateCode.OperationError;
		}
		this.results = results;
	}



	/**
	 * 构造消息
	 * 
	 * @param status 状态代码
	 * @param obj 对象
	 */
	public MessageResult(int status, Object obj) {
		this.status = status;
		this.results = obj;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public String getMsg() {
		if(null == msg ){
			try {
				if(messages.size() == 0){
					@SuppressWarnings("static-access")
					Class<?> clzz = getClass().forName("com.lydoa.common.alias.StateCode");
					Field[] fields =  clzz.getDeclaredFields();
					for(Field field : fields){ 
						Text t = field.getAnnotation(Text.class); 
						if(t != null){
							messages.put((Integer)field.get(Integer.class), t.value());  
						}
					}
				}
				return messages.get(this.status);
			} catch (Exception e) {
				logger.error("get MessageResult Info Error status="  +this.status , e);
			}
		}
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public Object getResults() {
		return results;
	}



	public void setResults(Object results) {
		this.results = results;
	}



	
	@Override
	public String toString() {
		return this.getMsg();
	}
	
	
	
}
