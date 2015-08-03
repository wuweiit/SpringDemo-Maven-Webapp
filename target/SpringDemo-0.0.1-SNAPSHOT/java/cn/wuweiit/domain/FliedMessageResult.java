package cn.wuweiit.domain;



/**
 * 消息对象
 * @author marker
 * @version 1.0
 * 
 * @update 2015-06-17 加入字段消息，用于对象表单提交生成对应字段错误码和消息内容
 */
public class FliedMessageResult extends MessageResult{
	 

	
	/** 字段名称 */
	private String field;
	
	
	/**
	 * 针对返回多个错误码的接口设计
	 * @param status
	 * @param errorcode
	 */
	public FliedMessageResult(int status, String field){
		this.status = status;
		this.field = field;
	}


	public String getField() {
		return field;
	}


	public void setField(String field) {
		this.field = field;
	}


 


  
	
	
	
}
