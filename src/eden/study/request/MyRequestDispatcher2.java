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
		String data = "�ҽ�Eden���ҽ���18�ꡣ";
		request.setAttribute("data", data);
		
		//�ͻ��˷������Servlet��RequestDemo06֪ͨ������������ת��(forward)��test.jspҳ����д���
        request.getRequestDispatcher("/test.jsp").forward(request, response);
				
	}

}
