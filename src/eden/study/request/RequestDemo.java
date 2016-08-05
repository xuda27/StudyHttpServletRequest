package eden.study.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestDemo extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//get��ʽ����  �������ñ�����Ч
//		req.setCharacterEncoding("utf-8");//���÷�������UTF-8�ı����������
		//Ϊʲô��
		//web������(tomcat)��GET��ʽ�������ύ���õĽ����ַ�����"ISO-8859-1" 
		//�������Է������Ľ��뷽ʽ�ǲ��Եģ���Ϊ������õ���UTF-8��������ȴ�õ�ISO-8859-1��
		
		//ʹ��getParameterValues��ȡ���uname��ֵ
		System.out.println("--------------------------getParameterValues");
		String []unames = req.getParameterValues("uname");
		int i = 1;
		for(String uname : unames){
			
			//get��ʽ�ύ���� Ҫͨ��String���getBytes�������б���ת��
			String uname1 = new String(uname.getBytes("iso-8859-1"),"utf-8");
			System.out.println("�û�"+(i++)+":"+uname1);
		}
		System.out.println("--------------------------getParameterMap");
		
		//ʹ��getParameterMap
		Map<String, String[]> map = req.getParameterMap();
		if(map!=null){
			Set<Entry<String, String[]>> set = map.entrySet();
			Iterator<Entry<String, String[]>> iterator = set.iterator();
			while(iterator.hasNext()){
				Entry<String, String[]> entry = iterator.next();
				System.out.println("��������"+ entry.getKey());
				String[] values = entry.getValue();
				if(values != null && values.length > 0){
					for(String v : values){
						System.out.print(v+",");
					}
				}
				System.out.println();
			}
		}
		
		System.out.println("--------------------------getParameterNames");
		//ʹ��getParameterNames
		Enumeration names = req.getParameterNames();  
        if(names != null){  
            while(names.hasMoreElements()){  
                String name = (String) names.nextElement();  
                System.out.println("������:"+name);  
                System.out.println("����ֵ:"+req.getParameter(name));  
            }  
        }  
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setHeader("content-type", "text/html;charset=UTF-8");//�����������utf-8��ʽ��
		
		//��ΪRequest���еĲ��õ���ISO8859-1���,����������Ҫ��request������������óɺ�����ҳ����ʾ�����(utf-8)һ�� ����ֻ������post����
		req.setCharacterEncoding("utf-8");	//��UTF-8��ʽ���͸�������
		
		resp.setCharacterEncoding("utf-8"); //��������UTF-8��ʽ����
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("uname");//����û�н���ȫ
		System.out.println(name);
		out.write( name );
	}
	
	
}
