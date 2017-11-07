package org.avco.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


//Root Element indicates the element is the root of the whole xml structure.
//xmlType -> we can customize the element using the attributes of the xmltype.
@XmlRootElement(name="Employee")
@XmlType(propOrder={"id","ssn","firstName","lastName"})
public class EmployeeBean {

	private String firstName;
	private String lastName;
	private String ssn;
	private long id;
	private List<EmployeeAddressBean> addressBean = new ArrayList<EmployeeAddressBean>();
	
	@XmlElement(name="FirstName")
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<EmployeeAddressBean> getAddressBean() {
		return addressBean;
	}
	public void setAddressBean(List<EmployeeAddressBean> addressBean) {
		this.addressBean = addressBean;
	}
	
	
	
}
