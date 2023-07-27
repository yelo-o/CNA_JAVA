package com.momo.customer.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.customer.dto.Histories;
import com.momo.customer.dto.History;
import com.momo.customer.service.CustomerService;

@WebServlet("/historylist")
public class HisotryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
	public HisotryListServlet() {
		service = CustomerService.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Histories histories = service.getHistoryList();
		List<History> hList = new ArrayList<History>();
		hList.add(histories.getH1());
		hList.add(histories.getH2());
		hList.add(histories.getH3());
		request.setAttribute("list", hList);
		
		String path = "/jsp/historylistresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
