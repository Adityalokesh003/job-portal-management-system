package com.jpms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpms.entity.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {

}
