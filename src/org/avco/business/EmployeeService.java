package org.avco.business;

import java.util.List;

import org.avco.vo.EmployeeBean;

public interface EmployeeService {

	 List<EmployeeBean> fetchEmployees();
	 
	 EmployeeBean fetchEmployeeById(long id);
}
