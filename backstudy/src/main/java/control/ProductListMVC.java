package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.exception.FindException;
import com.my.product.service.ProductService;

public class ProductListMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//sample data
	private ProductService service;
	public ProductListMVC() {
		service = new ProductService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1) 현재페이지 요청전달데이터 얻기
		String cp = request.getParameter("cp");
		int currentPage = 1;
		if(cp != null) {
			currentPage = Integer.parseInt(cp);
		}
		//2) 계산
		try {
			List<String> list = service.findAll(currentPage);
			String path = "/productlistview.jsp"; // "/productlistview"
			RequestDispatcher rd = request.getRequestDispatcher(path);
			request.setAttribute("list", list); 
			rd.forward(request, response);
			
		}catch(FindException e) {
			String path = "/err.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			request.setAttribute("e", e);
			rd.forward(request, response);
		}
		
		
	}

}
