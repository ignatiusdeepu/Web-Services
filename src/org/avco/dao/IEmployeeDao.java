package org.avco.dao;

import java.util.List;

import org.avco.vo.EmployeeBean;

public interface IEmployeeDao {

	public List<EmployeeBean> findEmployees();
	
	 EmployeeBean fetchEmployeeById(long id);
}
