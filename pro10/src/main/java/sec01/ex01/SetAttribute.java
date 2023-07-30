package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/set")
public class SetAttribute extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    String ctxMesg = "context에 바인딩됩니다.";
	    String sesMesg = "session에 바인딩됩니다.";
	    String reqMesg = "request에 바인딩됩니다.";
	    
	    ServletContext ctx = getServletContext(); //서블릿컨텍스트 객체 얻음
	    HttpSession session = request.getSession(); //http세션 객체 얻음
	    //바인딩
	    ctx.setAttribute("context", ctxMesg); //컨텍스트 바인딩
	    session.setAttribute("session", sesMesg); //세션 바인딩
	    request.setAttribute("request", reqMesg); //리퀘스트 바인딩
	    
	    out.print("바인딩을 수행합니다.");
	}

}
