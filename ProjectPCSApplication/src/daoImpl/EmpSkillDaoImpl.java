package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IEmpSkillDao;
import model.EmpSkill;

public class EmpSkillDaoImpl implements IEmpSkillDao {
	
	Connection conn=null;
	
	public EmpSkillDaoImpl() {
		conn=JDBCConnection.getDBConnection();
	}

	@Override
	public List<EmpSkill> getAllEmpSkills() {
		List<EmpSkill> empskillList=new ArrayList<EmpSkill>();
		try {
			String query="select * from EmpSkill";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(query);
			if(rst!=null) {
				while(rst.next()) {
					EmpSkill empskill=new EmpSkill();
					empskill.setEsId(rst.getInt(1));
					empskill.setEmployeeId(rst.getInt(2));
					empskill.setSkillId(rst.getInt(3));
					empskill.setExperience(rst.getInt(4));
					empskillList.add(empskill);
				}
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return empskillList;
	}

	@Override
	public void addEmpSkill(EmpSkill empskill) {
		try {
			String query="insert into EmpSkill(EmployeeId, SkillId, Experience) values(?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,empskill.getEmployeeId());
			pst.setInt(2,empskill.getSkillId());
			pst.setInt(3,empskill.getExperience());
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
	public EmpSkill getEmpSkillById(int id) {
		EmpSkill empskill=new EmpSkill();
		try {
			String query="select * from EmpSkill where EsId=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery(query);
			if(rst!=null) {
				while(rst.next()) {
					empskill.setEsId(rst.getInt(1));
					empskill.setEmployeeId(rst.getInt(2));
					empskill.setSkillId(rst.getInt(3));
					empskill.setExperience(rst.getInt(4));
					
				}
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return empskill;
	}

	@Override
	public void updateEmpSkill(EmpSkill empskill) {
		try {
			String query = "UPDATE EmpSkill SET experience=? WHERE EsId=?";
		
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, empskill.getExperience());
			statement.setInt(2,empskill.getEsId());		 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing Employee Skill was updated successfully!");
			}
			else {
				System.out.println("updation failed...");
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	public void deactivateEmpSkill(EmpSkill empskill) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void activateEmpSkill(EmpSkill empskill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmpSKill(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("delete from EmpSkill where EmpSkillId=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Employee Skill deleted...");
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
