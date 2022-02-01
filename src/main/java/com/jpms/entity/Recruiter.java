package com.jpms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "recruiter")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Recruiter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private long id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "company_name", nullable = false)
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String companyName;

	@Column(name = "contact_number", nullable = false)
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Pattern(regexp = "^\\+91[0-9]{10}", message = "Enter valid phone number")
	private String contactNumber;

	@OneToMany(mappedBy = "postedBy", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.LAZY)
	private List<Job> jobsPosted;

	public Recruiter() {

	}

	public Recruiter(String companyName, String contactNumber, List<Job> jobsPosted) {
		this.companyName = companyName;
		this.contactNumber = contactNumber;
		this.jobsPosted = jobsPosted;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public List<Job> getJobsPosted() {
		return jobsPosted;
	}

	public void setJobsPosted(List<Job> jobsPosted) {
		this.jobsPosted = jobsPosted;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Recruiter [id=" + id + ", companyName=" + companyName + ", contactNumber=" + contactNumber + "]";
	}

}
