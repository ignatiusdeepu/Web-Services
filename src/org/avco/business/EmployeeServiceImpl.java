package org.avco.business;

import java.util.List;

import org.avco.dao.EmployeeDao;
import org.avco.dao.IEmployeeDao;
import org.avco.vo.EmployeeBean;

public class EmployeeServiceImpl implements EmployeeService{

	IEmployeeDao empDao = new EmployeeDao(); 
	@Override
	public List<EmployeeBean> fetchEmployees() {
		return empDao.findEmployees();
	}
	
	 public EmployeeBean fetchEmployeeById(long id){
		 return empDao.fetchEmployeeById(id);
	 }

}
