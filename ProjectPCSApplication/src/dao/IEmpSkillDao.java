package dao;

import java.util.List;

import model.EmpSkill;

public interface IEmpSkillDao {
	List<EmpSkill> getAllEmpSkills();
	void addEmpSkill(EmpSkill empskill);
	EmpSkill getEmpSkillById(int id);
	void updateEmpSkill(EmpSkill empskill);
	void deactivateEmpSkill(EmpSkill empskill);
	void activateEmpSkill(EmpSkill empskill);
	void deleteEmpSKill(int id);
}
