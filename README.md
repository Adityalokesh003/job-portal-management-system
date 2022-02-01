Job Portal Management System


Goal : Developing a SaaS Application to advertise Jobs based on the Skills and Location

Technologies Used :  Java EE, Spring Boot, MySQL (Database) , Spring Data JPA ,Spring Security (User Roles), Hibernate Validator, Bootstrap (Front design)


Database Architecture

User : 
•	This is used for login purpose and session management
•	Fields like username and password will be used by spring security

Roles : 
•	We have 2 main roles : RECRUITER and JOB_SEEKER
•	ADMIN role can be implemented to verify and manage recruiters

Recruiter:
•	Recruiter and User will have ONE-TO-ONE Relation
•	Recruiters can do CRUD on Jobs and Also can manage Job Application received for a given Job

Job : 
•	They can be created by only recruiters
•	Job and Recruiter will have MANY TO ONE Relation
•	Job and Job Application will have ONE TO MANY Relation
•	They will be advertised to Job Seekers based on location and skills




Job Seeker
•	Job Seeker is also a type of User
•	Job Seeker cannot access Jobs and Recuiter CRUD
•	Job Seeker can apply Job Applications for Jobs 
•	Job Seeker and Job Application will have ONE TO MANY Relation

Job Application

•	Job Applications Can be accessed by Job Seeker
•	Recruiter can review Job Applications

I have Used Maven for dependency management and Git for version control
