package cn.kevin.service.impl;

import java.util.List;
import java.util.UUID;

import cn.kevin.dao.CustomerDao;
import cn.kevin.dao.daoImpl.CustomerDaoImpl;
import cn.kevin.domain.Customer;
import cn.kevin.exception.IdIsNullException;
import cn.kevin.service.CustomerService;
import cn.kevin.util.Page;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao dao = new CustomerDaoImpl();
	@Override
	public void addCustomer(Customer c) {
		c.setId(UUID.randomUUID().toString());
		dao.addCustomer(c);
	}
	@Override
	public void delCustomer(String customerId) {
		dao.delCustomer(customerId);
	}
	@Override
	public void updateCustomer(Customer c) throws IdIsNullException {
		dao.updateCustomer(c);
	}
	@Override
	public List<Customer> findAll() {
		return dao.findAll();
	}
	@Override
	public Customer findCustomerById(String customerId) {
		return dao.findCustomerById(customerId);
	}
	@Override
	public Page findPageReocrds(String pagenum) {
		int num=1;
		if(pagenum!=null&&!"".equals(pagenum.trim())){
			num = Integer.parseInt(pagenum);
		}
		int totalRecords = dao.getTotalCount();
		Page page = new Page(num, totalRecords);
		List<Customer> records = dao.findOnePageCustomer(page.getStartIndex(), page.getPageSize());
		page.setRecords(records);
		return page;
	}

}
