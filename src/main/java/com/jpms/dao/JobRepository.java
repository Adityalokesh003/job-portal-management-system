package com.jpms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpms.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}
