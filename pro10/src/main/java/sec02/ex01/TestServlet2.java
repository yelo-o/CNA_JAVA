package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first/*") //디렉터리 이름만 일치하는 URL 패턴
public class TestServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    
	    String context = request.getContextPath(); //컨텍스트 이름만 가져옵니다.
	    String url = request.getRequestURL().toString(); //전체 URL을 가져옵니다.
	    String mapping = request.getServletPath(); //서블릿 매핑 이름만 가져옵니다.
	    String uri = request.getRequestURI(); //URI를 가져옵니다.
	    
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Test Servlet2</title>");
	    out.println("</head>");
	    out.println("<body bgcolor='yellow'>");
	    out.println("<b>TestServlet2입니다.</b><br>");
	    out.println("<b>컨텍스트 이름 : "+ context + "</b><br>");
	    out.println("<b>전체 경로 : "+ url +"<b><br>");
	    out.println("<b>매핑 이름 : "+mapping+"<b><br>");
	    out.println("<b>URI : " + uri + "<b>");
	    out.println("</body>");
	    out.println("</html>");
	    out.close();
	}

}
