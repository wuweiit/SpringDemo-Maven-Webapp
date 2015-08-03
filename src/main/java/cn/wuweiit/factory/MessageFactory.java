package cn.wuweiit.factory;
 

import cn.wuweiit.alias.StateCode;
import cn.wuweiit.domain.FliedMessageResult;
import cn.wuweiit.domain.MessageResult;



/**
 * 消息工厂
 * 
 * @author marker
 * @version 1.0
 */
public class MessageFactory {
 
	
	public static MessageResult get(int msgId){
		return new MessageResult(msgId);
	}

	public static MessageResult get(Object entity) { 
		return new MessageResult(entity);
	}
	
	
	/**
	 * 获取错误消息对象
	 * @param messgae 错误消息内容
	 * @return
	 */
	public static MessageResult getErrorMessage(String messgae){
		return new MessageResult(false, messgae);
	}

	/**
	 * 获取错误消息对象
	 * @param messgae 错误消息内容
	 * @return
	 */
	public static MessageResult getExceptionMessage(Exception e) {
		return new MessageResult(false, e.getMessage());
	}
	
	
	
	/**
	 * 用户未登录错误
	 * @return
	 */
	public static MessageResult getUserNotLoginError() {
		return new MessageResult(StateCode.UserNotLoginError);
	}

	
	
	/**
	 * 获取字段错误消息
	 * @param errorCode
	 * @return
	 */
	public static MessageResult getFieldErrorMessage(
			FliedMessageResult[] errorCode) { 
		return new MessageResult(false, errorCode);
	}

	
	/**
	 * 获取成功消息
	 * @return
	 */
	public static MessageResult getOperationSuccess() { 
		return get(StateCode.OperationSuccess);
	}
}
