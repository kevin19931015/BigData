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
			//������ݣ���֤���ݣ����ݻ��ԣ�������ʾ
			CustomerFormbean formbean = Formbean.fillFormbean(CustomerFormbean.class, request);
			if(!formbean.validate()){
				request.setAttribute("formbean", formbean);
				request.getRequestDispatcher("/editCustomer.jsp").forward(request, response);
				return;
			}
			//���ģ�� formbean-->>javabean
			Customer c = new Customer();
			ConvertUtils.register(new DateLocaleConverter(),Date.class);
			BeanUtils.copyProperties(c, formbean);
			//���ý������⴦��
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
			//�������ݵ����ݿ�
			s.updateCustomer(c);
			request.setAttribute("message", "�޸ĳɹ�");
			request.getRequestDispatcher("/Message.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", "������æ");
			request.getRequestDispatcher("/Message.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

