<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Seeker Dashboard</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	 
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

	<div class="container">
		<h2>Welcome to Job Seeker Dashboard ${user.firstName }</h2>
		<c:if test="${jobseekerId==null }">
	Your Profile is Not Created. Please Fill Now to be able to Apply Jobs<a
				href="${pageContext.request.contextPath }/jobseekers/showProfileForm">Create
				Profile</a>

		</c:if>




	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>