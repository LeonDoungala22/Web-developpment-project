<%@page import="in.co.student.enrollment.sys.ctl.CourseCategoryCtl"%>
<%@page import="in.co.student.enrollment.sys.util.DataUtility"%>
<%@page import="in.co.student.enrollment.sys.util.ServletUtility"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Category</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<br />
		<nav class="navbar navbar-expand-lg navbar-light "
			style="background-color: #1266f1;">
			<div class="container-fluid">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a class="text-white"
							href="<%=SESView.WELCOME_CTL%>">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page"><a
							class="text-white" href="#">Course Category</a></li>
					</ol>
				</nav>
			</div>
		</nav>
		<hr>

		<br>
		<div class="row">
			<div class="col-1"></div>
			<div class="col-6">
				<h3>Course Category</h3>
				<b><font color="red"> <%=ServletUtility.getErrorMessage(request)%>
				</font></b> <b><font color="Green"> <%=ServletUtility.getSuccessMessage(request)%>
				</font></b>
				<hr>
				<form method="post" action="<%=SESView.COURSE_CATEGORY_CTL%>">

					<jsp:useBean id="bean" class="in.co.student.enrollment.sys.bean.CourseCategoryBean"
						scope="request"></jsp:useBean>

					<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
						type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
					<input type="hidden" name="modifiedBy"
						value="<%=bean.getModifiedBy()%>"> <input type="hidden"
						name="createdDatetime"
						value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
					<input type="hidden" name="modifiedDatetime"
						value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">

					<!-- Email input -->
					<div class="form-outline mb-4">
					 <label
							class="form-label" >Name</label>
						<input type="text" 
							placeholder="Enter Name here.." class="form-control bd" name="name"
							value="<%=DataUtility.getStringData(bean.getName())%>"> <font
							color="red"><%=ServletUtility.getErrorMessage("name", request)%></font>
					</div>
					
					<div class="form-outline mb-4">
					 <label
							class="form-label" >Description</label>
						<input type="text" 
							placeholder="Enter Description here.." class="form-control bd" name="description"
							value="<%=DataUtility.getStringData(bean.getDescription())%>"> <font
							color="red"><%=ServletUtility.getErrorMessage("description", request)%></font>
					</div>

					
					<!-- Submit button -->
					<input type="submit" class="btn btn-primary  mb-4" name="operation"
						value="<%=CourseCategoryCtl.OP_SAVE%>">&nbsp;&nbsp; <input
						type="submit" class="btn btn-primary  mb-4" name="operation"
						value="<%=CourseCategoryCtl.OP_RESET%>">
				</form>
			</div>
			<div class="col-5"></div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>