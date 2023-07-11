package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductListView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list = (List<String>) request.getAttribute("list");
		
		//3) 응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>ProductListMVC</title></head>");
		out.print("<body>");
		out.print("<ul>");
		for(String prodName : list) {
			out.print("<li>");
			out.print(prodName);
			out.print("</li>");
		}
		out.print("</ul>");
		out.print("</body>");
		out.print("</html>");
	}

}
