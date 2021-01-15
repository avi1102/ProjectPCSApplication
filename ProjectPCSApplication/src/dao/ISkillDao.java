package dao;

import java.util.List;

import model.Skill;

public interface ISkillDao {

	List<Skill> getAllSkills();
	void addSkill(Skill skill);
	Skill getSkillById(int id);
	void deactivateSkill(Skill skill);
	void activateSkill (Skill skill);
	void deleteSkill(int id);
	void updateSkill(Skill skill);
}
