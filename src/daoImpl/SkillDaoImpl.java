package daoImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.ISkillDao;
import model.Skill;

public class SkillDaoImpl implements ISkillDao{

	Connection conn=null;
	public SkillDaoImpl() {
		conn=JDBCConnection.getDBConnection();
	}
	
	@Override
	public List<Skill> getAllSkills() {
		List<Skill> skillList=new ArrayList<Skill>();
		try {
			String query="select * from Skill";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(query);
			if(rst!=null) {
				while(rst.next()) {
					Skill skill=new Skill();
					skill.setSkillId(rst.getInt(1));
					skill.setSkillName(rst.getString(2));
					skill.setSkillDescription(rst.getString(3));
					skill.setActive(rst.getString(4));
					skillList.add(skill);
				}
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return skillList;
		
	}

	@Override
	public void addSkill(Skill skill) {
		try {
			String query="insert into Skill(SkillName, SkillDescription, Active) values(?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1, skill.getSkillName());
			pst.setString(2, skill.getSkillDescription());
			pst.setString(3, skill.getActive());
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
	public Skill getSkillById(int id) {
		Skill skill=new Skill();
		try {
			String query="select * from Skill where SkillId=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery(query);
			if(rst!=null) {
				while(rst.next()) {
					skill.setSkillId(rst.getInt(1));
					skill.setSkillName(rst.getString(2));
					skill.setSkillDescription(rst.getString(3));
					skill.setActive(rst.getString(4));
			}
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return skill;
	}

	@Override
	public void updateSkill(Skill skill) {
		try {
			String query = "UPDATE Skill SET skillDescription=? WHERE SkillId=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1,skill.getSkillDescription());
			statement.setInt(2, skill.getSkillId());
			int rowsUpdated = statement.executeUpdate();
			if(rowsUpdated > 0) {
				System.out.println("An existing Skill was updated successfully!");
			}
			else {
				System.out.println("Updation Failed...");
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	public void deactivateSkill(Skill skill) {
		try {
			
			PreparedStatement pst=conn.prepareStatement("update Skill set Active=? where SkillId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, skill.getSkillId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Skill deactivated...");
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
	public void activateSkill(Skill skill) {
		try {
			
			PreparedStatement pst=conn.prepareStatement("update Skill set Active=? where SkillId=?");
			pst.setString(1, "Active");
			pst.setInt(2, skill.getSkillId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Skill Activated...");
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
	public void deleteSkill(int id) {
		try {
			
			PreparedStatement pst=conn.prepareStatement("delete from Skill where SkillId=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Skill deleted...");
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