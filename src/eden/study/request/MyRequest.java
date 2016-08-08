package eden.study.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 关于常用获得客户端信息的方法
 * @author eden
 *
 */
public class MyRequest extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("返回客户端发出请求时的完整URL(网址):");
		System.out.println(request.getRequestURL());
		
		System.out.print("返回请求行中的资源名部分：");
		System.out.println(request.getRequestURI());
		
		System.out.print("返回请求行中的参数部分:");
		System.out.println(request.getQueryString());
		
		System.out.print("返回发送请求的客户端请求的IP地址（来访者的ip）：");
		System.out.println(request.getRemoteAddr());
		
		System.out.print("返回发送请求的客户端的主机名（要在dns上注册，如不是返回ip）：");
		System.out.println(request.getRemoteHost());
		
		System.out.print("返回客户端所使用的网络端口号:");
		System.out.println(request.getRemotePort());
		
		System.out.print("返回web服务器的IP地址：");
		System.out.println(request.getLocalAddr());
		
		System.out.print("返回web服务器的主机名：");
		System.out.println(request.getLocalName());
		
		System.out.print("得到请求URL地址所使用的方法（post、get）：");
		System.out.println(request.getMethod());
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
