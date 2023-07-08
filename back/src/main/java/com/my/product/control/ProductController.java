package com.my.product.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.product.dto.Product;

@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//CORS 응답 허용
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8"); //응답형식 : 표준MIME방식//"text/html;charset=utf-8"

		PrintWriter out = response.getWriter();
		Product p = new Product();
		
		if(request.getParameter("prodNo").equals("C0001")) {
//			out.print("{\"prodNo\":\"C0001\", \"prodName\":\"아이스아메리카노\", \"prodPrice\":2000}");
			p.setProdNo("C0001");
			p.setProdName("아이스아메리카노");
			p.setProdPrice(2000);
		} else if(request.getParameter("prodNo").equals("C0002")) {
//			out.print("{\"prodNo\":\"C0002\", \"prodName\":\"따뜻한아메리카노\", \"prodPrice\":1500}");
			p.setProdNo("C0002");
			p.setProdName("따뜻한아메리카노");
			p.setProdPrice(1500);
		} else if(request.getParameter("prodNo").equals("C0003")) {
//			out.print("{\"prodNo\":\"C0003\", \"prodName\":\"사케라또 아포가토\", \"prodPrice\":3000}");
			p.setProdNo("C0003");
			p.setProdName("사케라또 아포가토");
			p.setProdPrice(3000);
		} else if(request.getParameter("prodNo").equals("C0004")) {
//			out.print("{\"prodNo\":\"C0004\", \"prodName\":\"리저브 나이트로\", \"prodPrice\":4000}");
			p.setProdNo("C0004");
			p.setProdName("리저브 나이트로");
			p.setProdPrice(4000);
		}

		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(p);
		System.out.println(jsonStr);
		out.print(jsonStr);
	}
}
