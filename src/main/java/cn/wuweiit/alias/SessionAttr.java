package cn.wuweiit.alias;




/**
 * Session属性
 * 
 * @author marker
 * @version 1.0
 */
public interface SessionAttr {
	
	
	String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";//放到session中的key
	
	String LOGIN_USER = "user";
	
	/** 用户ID */
	String LOGIN_USER_ID = "s_userId";
	
	/** 用户角色（老师、学生） */
	String LOGIN_USER_ROLE = "s_userRole";
	
	/** 防止Cookie欺骗码 */
	String CookieDeceive = "s_cookieDeceiveCode";
	
	/**  */
	String TOKEN_KEY = "s_form_token";
	
	/** 当前用户的课程Id */
	String CURRENT_COURSE_ID = "courseId";
	
}
