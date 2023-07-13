package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String opt = request.getParameter("opt");
		if(opt == null) {
			PrintWriter out = response.getWriter();
			out.print("<a href=\"cookietest?opt=add&n=c&v=one\">쿠키추가</a>");
			out.print("<br>");

			out.print("<a href=\"cookietest?opt=view\">쿠키목록</a>");
			out.print("<br>");
			
			out.print("<a href=\"cookietest?opt=remove&n=c\">쿠키삭제</a>");
			out.print("<br>");
		}else if("add".equals(opt)) {
			//1. 쿠키 생성 : 쿠키이름, 값설정
			//2. 쿠키를 응답헤더에 추가
//			Cookie c = new Cookie("c1", "one");
//			response.addCookie(c);

			String n = request.getParameter("n"); //c
			String v = request.getParameter("v"); //one
			
			Cookie c2 = new Cookie(n,v);//1.쿠키생성

			//2.쿠키유효구간 설정
			c2.setMaxAge(60);
			response.addCookie(c2);//3.쿠키를 응답헤더에 추가

		}else if("view".equals(opt)) {
			//요청헤더의 쿠키얻기
			Cookie[] cs = request.getCookies();
			if(cs!=null) {
				for(Cookie c:cs) {
					System.out.println("쿠키이름 : " + c.getName() + ", 값 : " + c.getValue());
				}
			}else {
				System.out.println("쿠키없음");
			}
		}else if("remove".equals(opt)) {
			//쿠키삭제
			String n = request.getParameter("n");
			Cookie c3 = new Cookie(n, "three");
			c3.setMaxAge(0);
			response.addCookie(c3);
		}
	}
}
