package com.jpms.service;

import java.util.Optional;

import com.jpms.entity.JobSeeker;

public interface JobSeekerService {

	JobSeeker findByUserId(Long id);

	Optional<JobSeeker> findById(Long recruiterId);

	JobSeeker save(JobSeeker jobSeeker, long userId);

}
