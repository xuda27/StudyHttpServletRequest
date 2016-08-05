package eden.study.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyRequestDispatcher extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//在request容器中存入一个属性值
		request.setAttribute("text", "你好！中国！");//为什么乱码？
				
		//转发给RequestDispatch1进行读取
		request.getRequestDispatcher("/servlet/MyRequestDispatch1").forward(request, response);
				
		//一个web资源收到客户端请求后，通知服务器去调用另外一个web资源进行处理，称之为请求转发/307。
		//　　一个web资源收到客户端请求后，通知浏览器去访问另外一个web资源进行处理，称之为请求重定向/302。
	}

}
