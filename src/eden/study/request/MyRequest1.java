package eden.study.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 	获取请求头和请求数据
 * @author eden
 *
 */
public class MyRequest1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取请求数据
		String value = request.getParameter("uname");
		System.out.println(value);
	}

	/**
	 * 获取头的相关方法
	 * @param request
	 */
	private void demo(HttpServletRequest request) {
		String headValue = request.getHeader("Accept-Encoding");
		System.out.println(headValue);
		
		System.out.println("---------------");
		
		Enumeration<String> e = request.getHeaders("Accept-Encoding");
		while(e.hasMoreElements()){
			String value = e.nextElement();
			System.out.println(value);
		}
		
		System.out.println("--------------");
		
		e = request.getHeaderNames();
		while(e.hasMoreElements()){
			String name = e.nextElement();
			String value = request.getHeader(name);
			System.out.println(name + ": " + value);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
