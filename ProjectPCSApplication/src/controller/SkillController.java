package controller;

import java.util.List;

import dao.ISkillDao;
import daoImpl.SkillDaoImpl;
import model.Skill;

public class SkillController {
	
	ISkillDao skillDao=null;
	
	public SkillController() {
		skillDao=new SkillDaoImpl();
	}
	
	public List<Skill> getAllSkills(){
		List<Skill> skillList=skillDao.getAllSkills();
		return skillList;
	}
	
	public void addSkill(Skill skill) {
		skillDao.addSkill(skill);
	}
	public Skill getSkillById(int id) {
		Skill skill=skillDao.getSkillById(id);
		return skill;
	}
	public void deleteSkill(int id) {
		skillDao.deleteSkill(id);
	}
	public void deactivateSkill(Skill skill) {
		skillDao.deactivateSkill(skill);
	}
	public void activateSkill(Skill skill) {
		skillDao.activateSkill(skill);
	}

	public void updateSkill(Skill skill) {
		skillDao.updateSkill(skill);
	}
}