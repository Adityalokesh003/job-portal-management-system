<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Suggested Jobs</title>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
	<ul class="nav">
		<c:if test="${jobseekerId!=null }">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page"
				href="${pageContext.request.contextPath}/jobseekers/${jobseekerId}">Home</a></li>

			<li class="nav-item"><a class="nav-link" aria-current="page"
				href="${pageContext.request.contextPath}/jobseekers/${jobseekerId}/showUpdateProfileForm">Job Seeker
					Profile</a></li>





			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/jobseekers/${jobseekerId}/job-applications/">
					Job Applications </a></li>
			<li><form:form
					action="${pageContext.request.contextPath }/logout" method="POST">
					<input type="submit" value="Logout">
				</form:form></li>
		</c:if>



	</ul>

		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th scope="col">Job Role</th>
					<th scope="col">Locations</th>
					<th scope="col">Salary Information</th>
					<th scope="col">Experience Req</th>
					<th scope="col">Skills Required</th>
					<th scope="col">Posted date</th>


				</tr>
			</thead>

			<c:forEach var="job" items="${jobs }">
				<tbody>
					<tr>
						<td>${job.jobRole }</td>
						<td>${job.locations }</td>
						<td>${job.salaryInfo }</td>
						<td>${job.requiredExperience }</td>
						<td>${job.skillsRequired }</td>
						<td>${job.postedDate }</td>
						<td><a href="${pageContext.request.contextPath }/jobseekers/${jobseekerId}/jobs/apply">Apply</a></td>

					</tr>

				</tbody>


			</c:forEach>

		</table>



	</div>

</body>
</html>