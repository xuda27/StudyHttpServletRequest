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
		//get方式请求  这样设置编码无效
//		req.setCharacterEncoding("utf-8");//设置服务器以UTF-8的编码接收数据
		//为什么？
		//web服务器(tomcat)对GET方式的数据提交采用的解码字符集是"ISO-8859-1" 
		//所以明显服务器的解码方式是不对的，因为编码采用的是UTF-8，而解码却用的ISO-8859-1。
		
		//使用getParameterValues获取多个uname的值
		System.out.println("--------------------------getParameterValues");
		String []unames = req.getParameterValues("uname");
		int i = 1;
		for(String uname : unames){
			
			//get方式提交数据 要通过String类的getBytes方法进行编码转换
			String uname1 = new String(uname.getBytes("iso-8859-1"),"utf-8");
			System.out.println("用户"+(i++)+":"+uname1);
		}
		System.out.println("--------------------------getParameterMap");
		
		//使用getParameterMap
		Map<String, String[]> map = req.getParameterMap();
		if(map!=null){
			Set<Entry<String, String[]>> set = map.entrySet();
			Iterator<Entry<String, String[]>> iterator = set.iterator();
			while(iterator.hasNext()){
				Entry<String, String[]> entry = iterator.next();
				System.out.println("参数名："+ entry.getKey());
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
		//使用getParameterNames
		Enumeration names = req.getParameterNames();  
        if(names != null){  
            while(names.hasMoreElements()){  
                String name = (String) names.nextElement();  
                System.out.println("参数名:"+name);  
                System.out.println("参数值:"+req.getParameter(name));  
            }  
        }  
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setHeader("content-type", "text/html;charset=UTF-8");//设置浏览器以utf-8形式打开
		
		//因为Request域中的采用的是ISO8859-1码表,所以我们需要将request的容器码表设置成和我们页面显示的码表(utf-8)一样 这样只适用于post请求
		req.setCharacterEncoding("utf-8");	//以UTF-8形式发送给服务器
		
		resp.setCharacterEncoding("utf-8"); //服务器以UTF-8形式回送
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("uname");//参数没有接受全
		System.out.println(name);
		out.write( name );
	}
	
	
}
