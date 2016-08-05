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
		//��request�����д���һ������ֵ
		request.setAttribute("text", "��ã��й���");//Ϊʲô���룿
				
		//ת����RequestDispatch1���ж�ȡ
		request.getRequestDispatcher("/servlet/MyRequestDispatch1").forward(request, response);
				
		//һ��web��Դ�յ��ͻ��������֪ͨ������ȥ��������һ��web��Դ���д�����֮Ϊ����ת��/307��
		//����һ��web��Դ�յ��ͻ��������֪ͨ�����ȥ��������һ��web��Դ���д�����֮Ϊ�����ض���/302��
	}

}
