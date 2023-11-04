<%@page import="in.co.student.enrollment.sys.bean.EnrollBean"%>
<%@page import="in.co.student.enrollment.sys.bean.CourseBean"%>
<%@page import="in.co.student.enrollment.sys.bean.CourseCategoryBean"%>
<%@page import="in.co.student.enrollment.sys.util.ServletUtility"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enroll Course List</title>
<link href="<%=SESView.APP_CONTEXT%>/css/login.css" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp"%>
	<br>
	<div class="container">
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item linkSize"><i
					class="fas fa-tachometer-alt"></i> <a class="link-dark"
					href="<%=SESView.WELCOME_CTL%>">Home</a></li>
				<li class="breadcrumb-item linkSize active" aria-current="page">
					<i class="fa fa-arrow-right" aria-hidden="true"></i> Enroll Course List
				</li>
			</ol>
		</nav>
	</div>
	<hr>
	<form method="post" action="<%=SESView.ENROLL_LIST_CTL%>">
		<div class="card">
			<h5 class="card-header"
				style="background-color: #00061df7; color: white;">Enroll Course List</h5>
			<div class="card-body">
				<div class="row g-3">
					
					<div class="col">
						<input type="text" placeholder="Search By  User Name here..."
							name="userName" class="form-control"
							value="<%=ServletUtility.getParameter("userName", request)%>">
					</div>

					<div class="col">
						<input type="text" placeholder="Search By  Course Name here..."
							name="courseName" class="form-control"
							value="<%=ServletUtility.getParameter("courseName", request)%>">
					</div>
					
				
					<div class="col">
						<input type="submit" class="btn  btn-outline-primary"
							name="operation" value="Search"></input> or <input type="submit"
							class="btn  btn-outline-secondary" name="operation"
							value="Reset">
					</div>
				</div>
				<b><font color="red"> <%=ServletUtility.getErrorMessage(request)%>
				</font></b> <b><font color="Green"> <%=ServletUtility.getSuccessMessage(request)%>
				</font></b><br>

				<table class="table table-bordered border-primary">
					<thead>
						<tr>
							
							<th scope="col">#</th>
							<th scope="col">Course Name</th>
							<th scope="col">User Name</th>
							<th scope="col">Email</th>
							<th scope="col">Contact No</th>
							<th scope="col">Enroll Date</th>
						</tr>
					</thead>
					<tbody>
						<%
						int pageNo = ServletUtility.getPageNo(request);
						int pageSize = ServletUtility.getPageSize(request);
						int index = ((pageNo - 1) * pageSize) + 1;
						int size = ServletUtility.getSize(request);
						EnrollBean bean = null;
						List list = ServletUtility.getList(request);
						Iterator<EnrollBean> iterator = list.iterator();
						while (iterator.hasNext()) {
							bean = iterator.next();
						%>
						<tr>
						
							<td scope="row"><%=index++%></td>
							<td scope="row"><%=bean.getCourseName()%></td>
							<td scope="row"><%=bean.getUserName()%></td>
							<td scope="row"><%=bean.getEmail()%></td>
							<td scope="row"><%=bean.getContactNo()%></td>
							<td scope="row"><%=bean.getEnrollDate()%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>

				<div class="clearfix">
			
					<nav aria-label="Page navigation example float-end">
						<ul class="pagination justify-content-end" style="font-size: 13px">
							<li class="page-item"><input type="submit" name="operation"
								class="page-link " <%=(pageNo == 1) ? "disabled" : ""%> value="Previous"></li>
							
							<li class="page-item"><input type="submit" name="operation"
								class="page-link "
								<%=((list.size() < pageSize) || size == pageNo * pageSize) ? "disabled" : ""%>
								value="Next"></li>
						</ul>
					</nav>
				</div>
			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
			type="hidden" name="pageSize" value="<%=pageSize%>">

			</div>

		</div>
	</form>

	<%@ include file="footer.jsp"%>
</body>
</html>