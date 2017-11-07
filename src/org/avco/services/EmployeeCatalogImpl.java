package org.avco.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.avco.business.EmployeeService;
import org.avco.business.EmployeeServiceImpl;
import org.avco.vo.EmployeeBean;

//EmployeeCatalog is the service endpoint interface.
@WebService(endpointInterface="org.avco.services.EmployeeCatalog",portName="AvcoEmployeesPort", serviceName="AvcoEmployeesService")
public class EmployeeCatalogImpl implements EmployeeCatalog {

	EmployeeService employeeService = new EmployeeServiceImpl();
	
	
	public List<EmployeeBean> fetchEmployees(){
		return employeeService.fetchEmployees();
	}
	
	public List<EmployeeBean> fetchEmployees2(){
		return employeeService.fetchEmployees();
	}
	
	public EmployeeBean fetchEmployeeById(long id){
		return employeeService.fetchEmployeeById(id);
	}
}
