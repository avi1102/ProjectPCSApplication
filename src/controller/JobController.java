package controller;

import java.util.List;

import dao.IJobDao;
import daoImpl.JobDaoImpl;
import model.Job;

public class JobController {

	IJobDao jobDao=null;
	
	public JobController() {
		jobDao=new JobDaoImpl();
	}
	
	public List<Job> getAllJobs(){
		List<Job> jobList=jobDao.getAllJobs();
		return jobList;
	}
	
	public void addJob(Job job) {
		jobDao.addJob(job);
	}
	public Job getJobById(int id) {
		Job job=jobDao.getJobById(id);
		return job;
	}
	public void deleteJob(int id) {
		jobDao.deleteJob(id);
	}
	public void deactivateJob(Job job) {
		jobDao.deactivateJob(job);
	}
	public void activateEmployee(Job job) {
		jobDao.activateJob(job);
	}

	public void updateJob(Job job) {
		jobDao.updateJob(job);
	}
}
