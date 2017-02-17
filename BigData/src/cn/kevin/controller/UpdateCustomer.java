package cn.kevin.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import cn.kevin.domain.Customer;
import cn.kevin.formbean.CustomerFormbean;
import cn.kevin.service.CustomerService;
import cn.kevin.service.impl.CustomerServiceImpl;
import cn.kevin.util.Formbean;

public class UpdateCustomer extends HttpServlet{
	private CustomerService s = new CustomerServiceImpl(); 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		try {
			request.setCharacterEncoding("UTF-8");
			//填充数据，验证数据，数据回显，错误提示
			CustomerFormbean formbean = Formbean.fillFormbean(CustomerFormbean.class, request);
			if(!formbean.validate()){
				request.setAttribute("formbean", formbean);
				request.getRequestDispatcher("/editCustomer.jsp").forward(request, response);
				return;
			}
			//填充模型 formbean-->>javabean
			Customer c = new Customer();
			ConvertUtils.register(new DateLocaleConverter(),Date.class);
			BeanUtils.copyProperties(c, formbean);
			//爱好进行特殊处理
			String[] hobbies = formbean.getHobbies();
			if(hobbies!=null&&!"".equals(hobbies)){
				StringBuffer sb = new StringBuffer();
				for(int i=0;i<hobbies.length;i++){
					if(i>0){
						sb.append(",");
					}
					sb.append(hobbies[i]);
				}
				c.setHobby(sb.toString());
			}
			//更新数据到数据库
			s.updateCustomer(c);
			request.setAttribute("message", "修改成功");
			request.getRequestDispatcher("/Message.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", "服务器忙");
			request.getRequestDispatcher("/Message.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

