package cn.kevin.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.kevin.dao.CustomerDao;
import cn.kevin.domain.Customer;
import cn.kevin.exception.DaoException;
import cn.kevin.exception.IdIsNullException;
import cn.kevin.util.JdbcUtil;

public class CustomerDaoImpl implements CustomerDao {
	@Override
	public void addCustomer(Customer c) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("insert into customer (ID,NAME,GENDER,BIRTHDAY,PHONENUMBER,EMAIL,HOBBY,TYPE,DESCRIPTION) values (?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, c.getId());
			stmt.setString(2, c.getName());
			stmt.setString(3, c.getGender());
			stmt.setDate(4, new java.sql.Date(c.getBirthday().getTime()));
			stmt.setString(5, c.getPhoneNumber());
			stmt.setString(6, c.getEmail());
			stmt.setString(7, c.getHobby());
			stmt.setString(8, c.getType());
			stmt.setString(9, c.getDescription());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}
	@Override
	public void delCustomer(String customerId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("delete from customer where ID=?");
			stmt.setString(1, customerId);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}
	@Override
	public void updateCustomer(Customer c) throws IdIsNullException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("update customer set NAME=?,GENDER=?,BIRTHDAY=?,PHONENUMBER=?,EMAIL=?,HOBBY=?,TYPE=?,DESCRIPTION=? where ID=?");
			stmt.setString(9, c.getId());
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getGender());
			stmt.setDate(3, new java.sql.Date(c.getBirthday().getTime()));
			stmt.setString(4, c.getPhoneNumber());
			stmt.setString(5, c.getEmail());
			stmt.setString(6, c.getHobby());
			stmt.setString(7, c.getType());
			stmt.setString(8, c.getDescription());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}
	@Override
	public List<Customer> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Customer> cs = new ArrayList<Customer>();
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("select ID,NAME,GENDER,BIRTHDAY,PHONENUMBER,EMAIL,HOBBY,TYPE,DESCRIPTION from customer");
			rs = stmt.executeQuery();
			while(rs.next()){
				Customer c = new Customer();
				c.setId(rs.getString("ID"));
				c.setName(rs.getString("NAME"));
				c.setGender(rs.getString("GENDER"));
				c.setBirthday(rs.getDate("BIRTHDAY"));
				c.setEmail(rs.getString("EMAIL"));
				c.setPhoneNumber(rs.getString("PHONENUMBER"));
				c.setHobby(rs.getString("HOBBY"));
				c.setType(rs.getString("TYPE"));
				c.setDescription(rs.getString("DESCRIPTION"));
				cs.add(c);
			}
			return cs;
		} catch (Exception e) {
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}
	@Override
	public Customer findCustomerById(String customerId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("select ID,NAME,GENDER,BIRTHDAY,PHONENUMBER,EMAIL,HOBBY,TYPE,DESCRIPTION from customer where ID=?");
			stmt.setString(1, customerId);
			rs = stmt.executeQuery();
			if(rs.next()){
				Customer c = new Customer();
				c.setId(rs.getString("ID"));
				c.setName(rs.getString("NAME"));
				c.setGender(rs.getString("GENDER"));
				c.setBirthday(rs.getDate("BIRTHDAY"));
				c.setEmail(rs.getString("EMAIL"));
				c.setPhoneNumber(rs.getString("PHONENUMBER"));
				c.setHobby(rs.getString("HOBBY"));
				c.setType(rs.getString("TYPE"));
				c.setDescription(rs.getString("DESCRIPTION"));
				return c;
			}else{
				return null;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}
	@Override
	public List<Customer> findOnePageCustomer(int startIndex,int pageSize) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Customer> cs = new ArrayList<Customer>();
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("select ID,NAME,GENDER,BIRTHDAY,PHONENUMBER,EMAIL,HOBBY,TYPE,DESCRIPTION from customer limit ?,?");
			stmt.setInt(1, startIndex);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			while(rs.next()){
				Customer c = new Customer();
				c.setId(rs.getString("ID"));
				c.setName(rs.getString("NAME"));
				c.setGender(rs.getString("GENDER"));
				c.setBirthday(rs.getDate("BIRTHDAY"));
				c.setEmail(rs.getString("EMAIL"));
				c.setPhoneNumber(rs.getString("PHONENUMBER"));
				c.setHobby(rs.getString("HOBBY"));
				c.setType(rs.getString("TYPE"));
				c.setDescription(rs.getString("DESCRIPTION"));
				cs.add(c);
			}
			return cs;
		} catch (Exception e) {
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}
	@Override
	public int getTotalCount() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("select count(*) from customer");
			rs = stmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}else{
				return 0;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}
}
