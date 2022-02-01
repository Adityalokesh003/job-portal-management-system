package com.jpms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jpms.dao.JobApplicationRepository;
import com.jpms.entity.JobApplication;

public class JobApplicationServiceImpl implements JobApplicationService {
	@Autowired
	private JobApplicationRepository jobApplicationRepository;

	@Override
	public List<JobApplication> findAll() {
		// TODO Auto-generated method stub
		return jobApplicationRepository.findAll();
	}

}
