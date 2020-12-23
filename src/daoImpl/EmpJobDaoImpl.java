package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IEmpJobDao;
import model.EmpJob;

public class EmpJobDaoImpl implements IEmpJobDao {

Connection conn=null;
	
	public EmpJobDaoImpl() {
		conn=JDBCConnection.getDBConnection();
	}

	@Override
	public List<EmpJob> getAllEmpJobs() {
		List<EmpJob> empjobList=new ArrayList<EmpJob>();
		try {
			String query="select * from EmpJob";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(query);
			if(rst!=null) {
				while(rst.next()) {
					EmpJob empjob=new EmpJob();
					empjob.setEjId(rst.getInt(1));
					empjob.setEmployeeId(rst.getInt(2));
					empjob.setJobId(rst.getInt(3));
					empjob.setRecruited(rst.getString(4));
					empjobList.add(empjob);
				}
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return empjobList;
	}

	@Override
	public void addEmpJob(EmpJob empjob) {
		try {
			String query="insert into EmpJob(EmployeeId, JobId, Recruited) values(?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,empjob.getEmployeeId());
			pst.setInt(2,empjob.getJobId());
			pst.setString(3,empjob.getRecruited());
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
	public EmpJob getEmpJobById(int id) {
		EmpJob empjob=new EmpJob();
		try {
			String query="select * from EmpJob where EjId=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery(query);
			if(rst!=null) {
				while(rst.next()) {
					empjob.setEjId(rst.getInt(1));
					empjob.setEmployeeId(rst.getInt(2));
					empjob.setJobId(rst.getInt(3));
					empjob.setRecruited(rst.getString(4));
					
				}
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return empjob;
	}

	@Override
	public void updateEmpJob(EmpJob empjob) {
		try {
			String query = "UPDATE EmpJob SET recruited=? WHERE EjId=?";
		
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, empjob.getRecruited());
			statement.setInt(2,empjob.getEjId());		 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing Employee Job was updated successfully!");
			}
			else {
				System.out.println("updation failed...");
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	public void deactivateEmpJob(EmpJob empjob) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void activateEmpJob(EmpJob empjob) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmpJob(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("delete from EmpJob where EmpJobId=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Employee Job deleted...");
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
