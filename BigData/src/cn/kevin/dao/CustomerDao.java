package cn.kevin.dao;

import java.util.List;

import cn.kevin.domain.Customer;
import cn.kevin.exception.IdIsNullException;

public interface CustomerDao {
	/**
	 * ��ӿͻ���Ϣ
	 * @param c
	 */
	void addCustomer(Customer c);
	/**
	 * ����idɾ���ͻ�
	 * @param customerId
	 */
	void delCustomer(String customerId);
	/**
	 * ���Ŀͻ���Ϣ
	 * @param c
	 * @throws IdIsNullException
	 */
	void updateCustomer(Customer c)throws IdIsNullException;
	/**
	 * ��ѯ���еĿͻ���Ϣ
	 * @return
	 */
    List<Customer> findAll();
    /**
     * ���ݿͻ�id��ѯ�ͻ�
     * @param c
     * @return
     */
    Customer findCustomerById(String customerId);
    /**
     * ��ѯ��ҳ����
     * @return
     */
    List<Customer> findOnePageCustomer(int pageIndex,int pageSize);
    /**
     * �������
     * @return
     */
    int getTotalCount();

}
