package org.avco.business;

import java.util.List;

import org.avco.dao.EmployeeDao;
import org.avco.dao.IEmployeeDao;
import org.avco.exception.InvalidInputException;
import org.avco.vo.EmployeeBean;

public class EmployeeServiceImpl implements EmployeeService{

	IEmployeeDao empDao = new EmployeeDao(); 
	@Override
	public List<EmployeeBean> fetchEmployees() {
		return empDao.findEmployees();
	}
	
	 public EmployeeBean fetchEmployeeById(long id) throws InvalidInputException{
		 if(id==0){
			 throw new InvalidInputException("Invalid Input for id : "+id, "100");
		 }
		 return empDao.fetchEmployeeById(id);
		 //make soap req to exchange rate provider
		 //get the response ffrom the provider.
		 //do the necessary processing.
	 }

}
