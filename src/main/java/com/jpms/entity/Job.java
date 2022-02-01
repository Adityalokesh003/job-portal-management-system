
package com.jpms.entity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "active", nullable = false)
	private int active;

	@Column(name = "job_role", nullable = false)
	@NotNull(message = "Cannot be Empty")
	@Size(min = 1, message = "required field")
	private String jobRole;

	@Column(name = "job_description", nullable = false)
	@NotNull(message = "Cannot be Empty")
	@Size(min = 1, message = "required field")
	private String jobDescription;

	@Column(name = "locations", nullable = false)
	@NotNull(message = "Cannot be Empty")
	@Size(min = 1, message = "required field")
	private String locations;

	@Column(name = "req_experience", nullable = false)
	@NotNull(message = "Cannot be Empty")
	@Size(min = 1, message = "required field")
	private String requiredExperience;

	@Column(name = "salary_info", nullable = true)
	@NotNull(message = "Cannot be Empty")
	@Size(min = 1, message = "required field")
	private String salaryInfo;

	@Column(name = "skills_required", nullable = true)
	@NotNull(message = "Cannot be Empty")
	private String skillsRequired;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "recruiter_id")
	private Recruiter postedBy;

	@Column(name = "posted_date", nullable = false)
	private LocalDate postedDate = LocalDate.now(ZoneId.of("GMT+05:30"));

	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, mappedBy = "job")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private JobSeeker awardedTo;

	@OneToMany(mappedBy = "job", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<JobApplication> jobApplications;

	public Job() {
	}

	public Job(int active, String jobRole, String jobDescription, String locations, String requiredExperience,
			String salaryInfo, String skillsRequired, LocalDate postedDate) {
		this.active = active;
		this.jobRole = jobRole;
		this.jobDescription = jobDescription;
		this.locations = locations;
		this.requiredExperience = requiredExperience;
		this.salaryInfo = salaryInfo;
		this.skillsRequired = skillsRequired;
		this.postedDate = postedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

	public String getRequiredExperience() {
		return requiredExperience;
	}

	public void setRequiredExperience(String requiredExperience) {
		this.requiredExperience = requiredExperience;
	}

	public String getSalaryInfo() {
		return salaryInfo;
	}

	public void setSalaryInfo(String salaryInfo) {
		this.salaryInfo = salaryInfo;
	}

	public String getSkillsRequired() {
		return skillsRequired;
	}

	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}

	public Recruiter getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(Recruiter postedBy) {
		this.postedBy = postedBy;
	}

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

	public JobSeeker getAwardedTo() {
		return awardedTo;
	}

	public void setAwardedTo(JobSeeker awardedTo) {
		this.awardedTo = awardedTo;
	}

	public List<JobApplication> getJobApplications() {
		return jobApplications;
	}

	public void setJobApplications(List<JobApplication> jobApplications) {
		this.jobApplications = jobApplications;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", active=" + active + ", jobRole=" + jobRole + ", jobDescription=" + jobDescription
				+ ", locations=" + locations + ", requiredExperience=" + requiredExperience + ", salaryInfo="
				+ salaryInfo + ", skillsRequired=" + skillsRequired + ", postedDate=" + postedDate + "]";
	}

}
