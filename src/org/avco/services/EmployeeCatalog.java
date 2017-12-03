package org.avco.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.avco.exception.InvalidInputException;
import org.avco.vo.EmployeeBean;

//name -> corresponds to name attribute in portType element of WSDL.
//namespace ==> package in java world.(WSDL is encapsulated in definitions tag and this tag has targetnamespace. This namespace ensures that all the types in the WSDL are not
//going to be overriden by another WSDL of the same type. 
//The types are isolated by grouping into namespace (or package in java world). By default namespace is autoderived from package in reverse order.

@WebService(name="AvcoEmployees", targetNamespace="http://avcoemployees.com")
@SOAPBinding(style=Style.DOCUMENT)
//
public interface EmployeeCatalog {

	//action property allows us to give a name to the action.(soapAction)
	//operation name changes the operation name.
	@WebMethod(action="fetch_employee", operationName="findAllEmployee")
	List<EmployeeBean> fetchEmployees();

	//Exclude a webmethod from being published as an operation of webservice.
	//@WebMethod(exclude=true)
	//List<EmployeeBean> fetchEmployees2();

	@WebMethod(action="fetch_employee_id", operationName="findEmployeeById")
	@WebResult(name="Employee")
	EmployeeBean fetchEmployeeById(@WebParam(partName="lookupInput") long id) throws InvalidInputException;

}