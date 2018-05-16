package com.herrj.dao;

import java.util.List;
import com.herrj.model.Employee;

public interface EmployeeDAO {

	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer employeeId);

	public Employee updateEmployee(Employee employee);
	//Gets employee
	public Employee getEmployee(int employeeid);
}
