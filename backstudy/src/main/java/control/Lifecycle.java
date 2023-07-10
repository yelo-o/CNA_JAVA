package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Lifecycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String aFileRealPath;

	public Lifecycle() {
		super();
	}

	
	private String developer;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext sc = this.getServletContext();
		developer = sc.getInitParameter("developer");

		String fileName = this.getInitParameter("fileName");
		//		aFileRealPath = sc.getRealPath("a.txt"); //이런식으로 직접 쓰는 것보다
		aFileRealPath = sc.getRealPath(fileName); //web.xml 파일의 파라미터값을 가져오는게 좋다.
		System.out.println("a.txt 파일의 실제경로 : " + aFileRealPath);
		System.out.println("init() 호출됨");
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출됨, 총개발자 : " + developer );
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(aFileRealPath);
			Scanner sc = new Scanner(fis);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try {
					fis.close();
				}catch(Exception e) {
				}
			}
		}
		//--------------------------------------
		
		System.out.println("request.getContextPath() = " + request.getContextPath()); // "/backstudy"
		System.out.println("request.getRequestURI() = " + request.getRequestURI());// "/backstudy/life"
		System.out.println("request.getServletContext() = " +  request.getServletContext()); // ServletContext api를 톰캣에서 구성한 이름 
		System.out.println("request.getServletPath() = " + request.getServletPath()); // "/life"
		
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			String value = request.getHeader(name);
			System.out.println("request header name = " + name + ", value = " + value);
		}
		System.out.println("request.getContentType() = " + request.getContentType()); 
		//요청전달데이터 얻기
		String tValue = request.getParameter("t"); 			// "~/life?t=ab"  "~/life?t="    "~/life"   
		System.out.println("요청전달데이터 t = " + tValue); // "ab"              ""            null
		
		//getParameter는 한가지만 얻어옴 -> 모두 얻기 위해 getParameterValues 사용
		String[] cValues =                   //"~/life?c=1&c=2" //"~life"
				request.getParameterValues("c");  //   {1,2}            null
		if(cValues != null) {
			for(String cValue : cValues) {
				System.out.println("요청전달데이터 c = " + cValue);
			}
		}
		//------------------------------
		//-----응답형식지정 : MIME
		response.setContentType("text/html;charset=utf-8"); //"application/json"
		//응답출력스트림얻기
		PrintWriter out = response.getWriter();
		out.print("<h1>WELCOME</h1>");
		out.print("<h3>김민규입니다</h3>"); //네트워크 비용을 고려하여 println() 보다는 print()를 쓰는 것이 좋다
		out.print(new Date());
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
