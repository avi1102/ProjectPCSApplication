package controller;

import java.util.List;

import dao.IEmployeeDao;
import daoImpl.EmployeeDaoImpl;
import model.Employee;

public class EmployeeController {

	IEmployeeDao empDao=null;
	
	public EmployeeController() {
		empDao=new EmployeeDaoImpl();
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> empList=empDao.getAllEmployees();
		return empList;
	}
	
	public void addEmployee(Employee emp) {
		empDao.addEmployee(emp);
	}
	public Employee getEmployeeById(int id) {
		Employee emp=empDao.getEmployeeById(id);
		return emp;
	}
	
	public void deleteEmployee(int id) {
		empDao.deleteEmployee(id);
	}
	public void deactivateEmployee(Employee emp) {
		empDao.deactivateEmployee(emp);
	}
	public void activateEmployee(Employee emp) {
		empDao.activateEmployee(emp);
	}

	public void updateEmployee(Employee emp) {
		empDao.updateEmployee(emp);
		
	}


}