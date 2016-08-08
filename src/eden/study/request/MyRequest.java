package eden.study.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���ڳ��û�ÿͻ�����Ϣ�ķ���
 * @author eden
 *
 */
public class MyRequest extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("���ؿͻ��˷�������ʱ������URL(��ַ):");
		System.out.println(request.getRequestURL());
		
		System.out.print("�����������е���Դ�����֣�");
		System.out.println(request.getRequestURI());
		
		System.out.print("�����������еĲ�������:");
		System.out.println(request.getQueryString());
		
		System.out.print("���ط�������Ŀͻ��������IP��ַ�������ߵ�ip����");
		System.out.println(request.getRemoteAddr());
		
		System.out.print("���ط�������Ŀͻ��˵���������Ҫ��dns��ע�ᣬ�粻�Ƿ���ip����");
		System.out.println(request.getRemoteHost());
		
		System.out.print("���ؿͻ�����ʹ�õ�����˿ں�:");
		System.out.println(request.getRemotePort());
		
		System.out.print("����web��������IP��ַ��");
		System.out.println(request.getLocalAddr());
		
		System.out.print("����web����������������");
		System.out.println(request.getLocalName());
		
		System.out.print("�õ�����URL��ַ��ʹ�õķ�����post��get����");
		System.out.println(request.getMethod());
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
