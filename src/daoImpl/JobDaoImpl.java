package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IJobDao;
import model.Job;

public class JobDaoImpl implements IJobDao {
	Connection conn=null;

	public JobDaoImpl() {
		conn=JDBCConnection.getDBConnection();
	}
	
	@Override
	public List<Job> getAllJobs() {
		List<Job> jobList=new ArrayList<Job>();
		try {
			String query="select * from Job";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(query);
			if(rst!=null) {
				while(rst.next()) {
					Job job=new Job();
					job.setJobId(rst.getInt(1));
					job.setJobTitle(rst.getString(2));
					job.setJobDescription(rst.getString(3));
					job.setCompanyName(rst.getString(4));
					job.setLocation(rst.getString(5));
					job.setKeySkill(rst.getString(6));
					job.setSalary(rst.getInt(7));
					job.setExperience(rst.getInt(8));
					job.setActive(rst.getString(9));
					jobList.add(job);
				}
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return jobList;

	}

	@Override
	public void addJob(Job job) {
		try {
			String query="insert into Job(JobTitle, JobDescription, CompanyName, Location, KeySkill, Salary, Experience, Active) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1,job.getJobTitle());
			pst.setString(2,job.getJobDescription());
			pst.setString(3,job.getCompanyName());
			pst.setString(4,job.getLocation());
			pst.setString(5,job.getKeySkill());
			pst.setInt(6,job.getSalary());
			pst.setInt(7,job.getExperience());
			pst.setString(8,job.getActive());
			int i=pst.executeUpdate();
			if(i==1) {
				System.out.println("1 record inserted...");
			}
			else {
				System.out.println("Insertion failed...");
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	public Job getJobById(int id) {
		Job job=new Job();
		try {
			String query="select * from Job where JobId=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery(query);
			if(rst!=null) {
				while(rst.next()) {
					job.setJobId(rst.getInt(1));
					job.setJobTitle(rst.getString(2));
					job.setJobDescription(rst.getString(3));
					job.setCompanyName(rst.getString(4));
					job.setLocation(rst.getString(5));
					job.setKeySkill(rst.getString(6));
					job.setSalary(rst.getInt(7));
					job.setExperience(rst.getInt(8));
					job.setActive(rst.getString(9));
					
				}
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return job;
	}

	@Override
	public void updateJob(Job job) {
		try {
			String query = "UPDATE Job SET jobDescription=?, keySkill=?, salary=?, experience=? WHERE JobId=?";
		
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, job.getJobDescription());
			statement.setString(2, job.getKeySkill());
			statement.setInt(3, job.getSalary());
			statement.setInt(4, job.getExperience());
			statement.setInt(5, job.getJobId());
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing Job  was updated successfully!");
			}
			else {
				System.out.println("updation failed...");
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	public void deactivateJob(Job job) {
		try {
			PreparedStatement pst=conn.prepareStatement("update Job set Active=? where JobId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, job.getJobId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Job deactivated...");
			}
			else {
				System.out.println("updation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	@Override
	public void activateJob(Job job) {
		try {
			PreparedStatement pst=conn.prepareStatement("update Job set Active=? where JobId=?");
			pst.setString(1, "Active");
			pst.setInt(2, job.getJobId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Job Activated...");
			}
			else {
				System.out.println("updation failed...");
			}			
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	public void deleteJob(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("delete from Job where JobId=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Job deleted...");
			}
			else {
				System.out.println("deletion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	

}
