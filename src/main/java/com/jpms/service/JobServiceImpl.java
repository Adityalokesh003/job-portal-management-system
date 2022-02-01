package com.jpms.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpms.dao.JobRepository;
import com.jpms.entity.Job;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Job job) {
		System.out.println(job);
		entityManager.unwrap(Session.class).saveOrUpdate(job);
		System.out.println(job);

	}

	@Override
	public Optional<Job> findById(Long jobId) {
		// TODO Auto-generated method stub
		return jobRepository.findById(jobId);
	}

	@Override
	public Job update(Job job) {

		job = jobRepository.findById(job.getId()).get();
		return jobRepository.save(job);

	}

	@Override
	public void remove(Long jobId) {
		// TODO Auto-generated method stub
		jobRepository.deleteById(jobId);
	}

	@Override
	@Transactional
	public void togglePublish(Long jobId) {
		// TODO Auto-generated method stub
		Job job = jobRepository.findById(jobId).get();
		int activeToken = job.getActive();
		if (activeToken == 0) {
			activeToken = 1;
		} else {
			activeToken = 0;
		}

		job.setActive(activeToken);
		entityManager.unwrap(Session.class).saveOrUpdate(job);

	}

}
