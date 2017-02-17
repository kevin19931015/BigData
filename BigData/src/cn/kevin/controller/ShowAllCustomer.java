package cn.kevin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kevin.service.CustomerService;
import cn.kevin.service.impl.CustomerServiceImpl;
import cn.kevin.util.Page;

public class ShowAllCustomer extends HttpServlet{
	private CustomerService s = new CustomerServiceImpl(); 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//List<Customer> cs = s.findAll();
		//request.setAttribute("cs", cs);
		//request.getRequestDispatcher("/ListCustomers.jsp").forward(request, response);
		
		String pagenum = request.getParameter("pagenum");
		Page page = s.findPageReocrds(pagenum);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/ListCustomers.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
