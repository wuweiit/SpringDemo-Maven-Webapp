package cn.wuweiit.web.servlet;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class FaceInnerServlet extends HttpServlet {

	private static final long serialVersionUID = 1043845924358079493L;

	/**
	 * Constructor of the object.
	 */
	public FaceInnerServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		if(uri.startsWith("/about")){ // 关于我们
			int suffix = uri.indexOf(".html");
			String pageName = uri.substring(0, suffix); 
			request.getRequestDispatcher(pageName + ".do").forward(request, response);
			return;
		}

		
		
		// 默认采用主页宣传应用
		request.getRequestDispatcher("/index.do").forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	
	
	/**
	 * 获取文件名称后缀
	 * @param path
	 * @return 后缀
	 */
	@SuppressWarnings("unused")
	private String getSuffix(String path){
        if (path.lastIndexOf(".") != -1 && path.lastIndexOf(".") != 0) {
            return path.substring(path.lastIndexOf(".") + 1);
        } else {
            return "";
        }
	}
}
