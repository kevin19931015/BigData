package cn.kevin.dao;

import java.util.List;

import cn.kevin.domain.Customer;
import cn.kevin.exception.IdIsNullException;

public interface CustomerDao {
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
     * 查询单页数据
     * @return
     */
    List<Customer> findOnePageCustomer(int pageIndex,int pageSize);
    /**
     * 获得总数
     * @return
     */
    int getTotalCount();

}
