package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionID = session.getId();
		long creationTime = session.getCreationTime();
		long lastAccessedTime = session.getLastAccessedTime();
		String id = request.getParameter("id");
		session.setAttribute("loginedId", id);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("세션ID = " + sessionID);
		out.print("<hr>");
		out.print("세션이 만들어진 시간 = " + creationTime);
		out.print("<hr>");
		out.print("세션 최종 사용 시간 = " + lastAccessedTime);
		out.print("<hr>");
		out.print("세션 속성 loginedId = " + session.getAttribute("loginedId"));
		out.print("<hr>");
		out.print("<a href=\"sessiontest2\">세션2</a>");
	}

}
