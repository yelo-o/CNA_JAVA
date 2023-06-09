package com.my.customer.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/signup")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*"); //"*" 는 로컬 pc뿐만 아니라 모든 pc에서 접근이 가능하도록 함
		response.setContentType("application/json;charset=utf-8"); //("text/xml"); //("text/html;charset=utf-8"); //응답형식 : 표준 MIME 방식
		PrintWriter out = response.getWriter();

//		try {
//			Thread.sleep(3*60*1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		String id = request.getParameter("id");
		
		Map<String, Object> map = new HashMap<>(); //key는 String, value는 Object
		
		if(id.equals("admin")) {
//			out.print("0,");
//			out.print("이미 존재하는 아이디입니다");
			//json 문자열 형태로 응답
//			out.print("{\"status\":0, \"msg\":\"이미 존재하는 아이디입니다\"}");
			map.put("status", 0);
			map.put("msg","이미 존재하는 아이디입니다");
		}else {
//			out.print("{\"status\" : 1, \"msg\" : \"가입성공\"}");
			map.put("status", 1);
			map.put("msg", "가입성공");
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(map);
		System.out.println(jsonStr);
		out.print(jsonStr);
	}

}
