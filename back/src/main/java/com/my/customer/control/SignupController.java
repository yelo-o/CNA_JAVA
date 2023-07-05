package com.my.customer.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/signup")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*"); //"*" 는 로컬 pc뿐만 아니라 모든 pc에서 접근이 가능하도록 함
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

//		try {
//			Thread.sleep(3*60*1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		String id = request.getParameter("userid");
		out.print(id + "가입성공");
	}

}
