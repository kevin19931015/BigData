package cn.kevin.service;

import java.util.List;

import cn.kevin.domain.Customer;
import cn.kevin.exception.IdIsNullException;
import cn.kevin.util.Page;

public interface CustomerService {
	/**
	 * 添加客户信息
	 * @param c
	 */
	void addCustomer(Customer c);
	/**
	 * 根据id删除客户
	 * @param customerId
	 */
	void delCustomer(String customerId);
	/**
	 * 更改客户信息
	 * @param c
	 * @throws IdIsNullException
	 */
	void updateCustomer(Customer c)throws IdIsNullException;
	/**
	 * 查询所有的客户信息
	 * @return
	 */
    List<Customer> findAll();
    /**
     * 根据客户id查询客户
     * @param c
     * @return
     */
    Customer findCustomerById(String customerId);
    /**
     * 返回page类
     * @param pagenum
     * @return
     */
    Page findPageReocrds(String pagenum);


}
