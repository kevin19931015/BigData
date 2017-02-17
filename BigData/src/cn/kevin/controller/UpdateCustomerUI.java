package cn.kevin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kevin.domain.Customer;
import cn.kevin.service.CustomerService;
import cn.kevin.service.impl.CustomerServiceImpl;

	public class UpdateCustomerUI extends HttpServlet{
		private CustomerService s = new CustomerServiceImpl(); 
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
			String customerID = request.getParameter("customerId");
			Customer c = s.findCustomerById(customerID);
			request.setAttribute("c", c);
			request.getRequestDispatcher("/editCustomer.jsp").forward(request, response);
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}

	}
