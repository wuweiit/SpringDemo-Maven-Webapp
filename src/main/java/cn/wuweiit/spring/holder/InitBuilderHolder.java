package cn.wuweiit.spring.holder;

import java.io.File;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ServletContextAware;



/**
 * 运行环境初始化构建
 * 
 * 
 * 
 * 
 * @author marker
 * */
public class InitBuilderHolder implements ServletContextAware{
	
	/** 日志记录器 */ 
	protected Logger logger = LoggerFactory.getLogger(getClass()); 
	
	
	/** Spring容器 */
	@Autowired 
	private ApplicationContext applicationContext;
	
	
	 
	public void setServletContext(ServletContext application) {
    	String webRootPath = application.getRealPath(File.separator);//网站根目录路径
    	
    	
    	
	}
	
	
	
	private Class<?> getErrorCodeClass() throws ClassNotFoundException{
		return Class.forName("com.lydoa.common.alias.ErrorCode");
	}

}
