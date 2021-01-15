package excDao;

import java.util.Iterator;
import java.util.List;
import java.io.*;
import controller.EmployeeController;
import controller.EmployeeJobsController;
import daoImpl.iEmployeeJobsDaoimp;
import model.Employee;
import model.EmployeeJobs;

public class EmployeeJobsExec{

	EmployeeJobsController empController=null;
	
	public EmployeeJobsExec() {
		empController=new EmployeeJobsController();
	}
	
	public void getAllEmployeeskill() {
		List<EmployeeJobs> empList=empController.getAllEmployeeskill();
		for(EmployeeJobs emp:empList) {
			System.out.println(emp);
		}
	}
	
	public void getEmployeeskillById() {
		int id=0;
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter employee skill id whose record you want to view:");
			id=Integer.parseInt(reader.readLine());
		}
		catch(IOException ex){
			System.out.println(ex);
		}
		EmployeeJobs emp=empController.getEmployeeskillById(id);
		System.out.println(emp);
	}
	
	public void addEmployeeskill() {
		EmployeeJobs emp=new EmployeeJobs();
	
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Employeeskill Details:");
			
			System.out.println("Employeeid:");
			emp.setEmpid(reader.readLine());
			System.out.println("SkillId:");
			emp.setSkillid(reader.readLine());
			System.out.println("Experience:");
			emp.setExperience(reader.readLine());
			
		}catch(IOException ex){
			System.out.println(ex);
		}
		empController.addEmployeeskill(emp);
	}
	public void updateEmployeeJobs() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String Experience;
			String SkillId;
			
			System.out.println("Enter EmployeeId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			EmployeeJobs emp=empController.getEmployeeskillById(id);
			System.out.println("Enter your new Skillid:");
			SkillId=reader.readLine();
			System.out.println("Enter your new Experience:");
			Experience=reader.readLine();
			empController.updateEmployeeJobs(emp);
			System.out.println("Updation successful..");
			
			
		}
		catch(IOException ex) {
			System.out.println("SOrry entered wrong information");
		}
	}
		
		public void deleteEmployeeJobs() {
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				int id;
				System.out.println("Enter EmployeeId whose record you want to delete:");
				id=Integer.parseInt(reader.readLine());
				empController.deleteEmployeeJobs(id);
			}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}

		


}