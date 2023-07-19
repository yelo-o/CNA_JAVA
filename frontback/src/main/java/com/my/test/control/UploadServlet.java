package com.my.test.control;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		InputStream is = request.getInputStream();
//		int readValue = -1;
//		while( (readValue = is.read()) != -1 ) {
//			System.out.print((char)readValue);
//		}
//	}
	
}
