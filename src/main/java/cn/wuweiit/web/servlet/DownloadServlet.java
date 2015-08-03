package cn.wuweiit.web.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 下载AndoridAPP接口
 * 
 * @author marker
 * @version 1.0
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1043845924358079493L;

	
	/** 日志记录 */
	Logger logger = LoggerFactory.getLogger(DownloadServlet.class);
	
	
	/**
	 *  
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(logger.isInfoEnabled()){
			logger.info("download app...");
		}
		@SuppressWarnings("deprecation")
		String webRootPath = request.getRealPath(File.separator);//网站根目录路径
	 
			
//			SystemService systemService = SpringContextHolder.getBean(AliasService.SystemService);
//			
//			// 获取最新的App信息
//			AppVersion appVer = systemService.getNewAppInfo();
//			
//			String filePath = appVer.getFile();
//			String verName = appVer.getVersionName();
//			 
//			OutputStream os = response.getOutputStream(); 
//			File file = new File(webRootPath + filePath);
//			int fileSize = (int) file.length();
//			response.setHeader("Content-Disposition", "attachment; filename=okdoa_"+verName+".apk");  
//			response.setContentType("application/octet-stream; charset=utf-8");  
//			response.setContentLength(fileSize);
//		    os.write(FileUtils.readFileToByteArray(file));
//			os.flush();
//			os.close();
	 
		
	}
 

}
