package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.exception.FindException;
import com.my.product.service.ProductService;


public class ProductListMC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService service;
	public ProductListMC() {
		service = new ProductService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1) 요청전달데이터 얻기 현재페이지 
		String cp = request.getParameter("cp");
		int currentPage = 1;
		if(cp != null) {
			currentPage = Integer.parseInt(cp);
		}
		//2) 계산 
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		//jackson data-bind 라이브러리의 writeValueAsString() : java객체 -> json문자열
		ObjectMapper mapper = new ObjectMapper();
		
		List<String> list;
		try {
			list = service.findAll(currentPage);
			String jsonStr = mapper.writeValueAsString(list);
			out.print(jsonStr);
		} catch (FindException e) {
			String msg = e.getMessage();
			Map<String, String> map = new HashMap<>();
			map.put("msg", msg);
			String jsonStr = mapper.writeValueAsString(map);
			out.print(jsonStr);
		}
		
	}

}
