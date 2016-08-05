package eden.study.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyRequestDispatcher2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data = "我叫Eden，我今年18岁。";
		request.setAttribute("data", data);
		
		//客户端访问这个Servlet后，RequestDemo06通知服务器将请求转发(forward)到test.jsp页面进行处理
        request.getRequestDispatcher("/test.jsp").forward(request, response);
				
	}

}
