package com.jpms.service;

import java.util.List;
import java.util.Optional;

import com.jpms.entity.Job;

public interface JobService {

	List<Job> findAll();

	void save(Job job);

	Optional<Job> findById(Long jobId);

	Job update(Job job);

	void remove(Long jobId);

	void togglePublish(Long jobId);

	List<Job> findByLocationsContaining(String location);

}
