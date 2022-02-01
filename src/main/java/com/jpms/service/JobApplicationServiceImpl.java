package com.jpms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpms.dao.JobApplicationRepository;
import com.jpms.entity.JobApplication;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {
	@Autowired
	private JobApplicationRepository jobApplicationRepository;

	@Override
	public List<JobApplication> findAll() {
		// TODO Auto-generated method stub
		return jobApplicationRepository.findAll();
	}

}
