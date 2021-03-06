package dao;
import java.util.List;

import model.Job;

public interface IJobDao {
	
	List<Job> getAllJobs();
	void addJob(Job job);
	Job getJobById(int id);
	void updateJob(Job job);
	void deactivateJob(Job job);
	void activateJob(Job job);
	void deleteJob(int id);
}