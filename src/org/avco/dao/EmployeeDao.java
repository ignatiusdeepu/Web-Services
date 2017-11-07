package org.avco.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.avco.vo.EmployeeBean;

public class EmployeeDao implements IEmployeeDao{

	private static String url = "jdbc:mysql://localhost:3306/avcoconsulting";

	public List<EmployeeBean> findEmployees() {
		// TODO Auto-generated method stub
		List<EmployeeBean> empList = new ArrayList<EmployeeBean>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		EmployeeBean employeeBean = null;
		// 1. Load the driver.
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 2. Obtain the connection.
			connection = DriverManager.getConnection(url, "root", "");

			StringBuffer sb = new StringBuffer("select t1.ID as EMPID,FIRST_NAME,LAST_NAME,SSN from EMPLOYEE t1");

			// 3. Create a statement.
			statement = connection.prepareStatement(sb.toString());
			// int i = statement2.executeUpdate(sb.toString());
			// 4. execute the statement.
			resultSet = statement.executeQuery();
			// 5.Iterate thru the resultset.
			while(resultSet.next()){
				employeeBean = new EmployeeBean();
				employeeBean.setId(resultSet.getLong("EMPID"));
				employeeBean.setFirstName(resultSet.getString("FIRST_NAME"));
				employeeBean.setLastName(resultSet.getString("LAST_NAME"));
				employeeBean.setSsn(resultSet.getString("SSN"));
				empList.add(employeeBean);
			}
			// 6. finally close the resources.

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				/*
				 * if(resultSet!=null){ resultSet.close(); }
				 */
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return empList;
	}
	
	 public EmployeeBean fetchEmployeeById(long id){
			// TODO Auto-generated method stub
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			EmployeeBean employeeBean = null;
			// 1. Load the driver.
			try {
				Class.forName("com.mysql.jdbc.Driver");

				// 2. Obtain the connection.
				connection = DriverManager.getConnection(url, "root", "");

				StringBuffer sb = new StringBuffer("select t1.ID as EMPID,FIRST_NAME,LAST_NAME,SSN from EMPLOYEE t1 where ID=?");

				// 3. Create a statement.
				preparedStatement = connection.prepareStatement(sb.toString());
				preparedStatement.setLong(1, id);
				// 4. execute the statement.
				resultSet = preparedStatement.executeQuery();
				// 5.Iterate thru the resultset.
				while(resultSet.next()){
					employeeBean = new EmployeeBean();
					employeeBean.setId(resultSet.getLong("EMPID"));
					employeeBean.setFirstName(resultSet.getString("FIRST_NAME"));
					employeeBean.setLastName(resultSet.getString("LAST_NAME"));
					employeeBean.setSsn(resultSet.getString("SSN"));
				}
				// 6. finally close the resources.

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				try {
					/*
					 * if(resultSet!=null){ resultSet.close(); }
					 */
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return employeeBean;
		}
}
