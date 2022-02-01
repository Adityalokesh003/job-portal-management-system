/**
 * 
 */
package com.jpms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpms.entity.Recruiter;

/**
 * @author adity
 *
 */
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

}
