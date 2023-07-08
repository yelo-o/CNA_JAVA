package com.my.product.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.product.dto.Product;

@WebServlet("/productlist")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=utf-8"); //응답형식 : 표준MIME방식//"text/html;charset=utf-8"
		//CORS 응답 허용
		response.setHeader("Access-Control-Allow-Origin", "*");
		//응답형식 지정
		//TODO
		
		PrintWriter out = response.getWriter();
//		out.print("[\r\n"
//				+ "{\"prodNo\":\"C0001\", \"prodName\":\"아이스아메리카노\",      \"prodPrice\":1000}, \r\n"
//				+ "{\"prodNo\":\"C0002\", \"prodName\":\"따뜻한아메리카노\", \"prodPrice\":1000}, \r\n"
//				+ "{\"prodNo\":\"C0003\", \"prodName\":\"사케라또 아포가토\",            \"prodPrice\":1500}, \r\n"
//				+ "{\"prodNo\":\"C0004\", \"prodName\":\"리저브 나이트로\",      \"prodPrice\":1500}\r\n"
//				+ "]");
		
		List<Product> list = new ArrayList<>();
		Product p = new Product("C0001", "아이스아메리카노", 2000);
		list.add(p);
		list.add(new Product("C0002", "따뜻한아메리카노", 1500));
		list.add(new Product("C0003", "사케라또 아포가토", 3000));
		list.add(new Product("C0004", "리저브 나이트로", 4000));
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(list);
		System.out.println(jsonStr);
		out.print(jsonStr);
	}
}
