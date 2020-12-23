package dao;

import java.util.List;

import model.EmpJob;

public interface IEmpJobDao {
	
	List<EmpJob> getAllEmpJobs();
	void addEmpJob(EmpJob empjob);
	EmpJob getEmpJobById(int id);
	void updateEmpJob(EmpJob empjob);
	void deactivateEmpJob(EmpJob empjob);
	void activateEmpJob(EmpJob empjob);
	void deleteEmpJob(int id);
}
