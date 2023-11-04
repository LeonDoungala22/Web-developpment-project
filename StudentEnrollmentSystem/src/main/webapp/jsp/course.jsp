<%@page import="in.co.student.enrollment.sys.ctl.CourseCtl"%>
<%@page import="in.co.student.enrollment.sys.util.HTMLUtility"%>
<%@page import="java.util.List"%>
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
<title>Course</title>
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
							class="text-white" href="#">Course</a></li>
					</ol>
				</nav>
			</div>
		</nav>
		<hr>

		<br>
		<div class="row">
			<div class="col-1"></div>
			<div class="col-6">
				<h3>Course</h3>
				<b><font color="red"> <%=ServletUtility.getErrorMessage(request)%>
				</font></b> <b><font color="Green"> <%=ServletUtility.getSuccessMessage(request)%>
				</font></b>
				<hr>
				<form method="post" action="<%=SESView.COURSE_CTL%>">

					<jsp:useBean id="bean" class="in.co.student.enrollment.sys.bean.CourseBean"
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
					<% List list=(List)request.getAttribute("categoryList"); %>
					<div class="form-outline mb-4">
					 <label
							class="form-label" >Category Name</label>
							<%=HTMLUtility.getList("categoryId",String.valueOf(bean.getCategoryId()),list) %>
						 <font
							color="red"><%=ServletUtility.getErrorMessage("categoryId", request)%></font>
					</div>
					
					<div class="form-outline mb-4">
					 <label
							class="form-label" >Course Code</label>
						<input type="text" 
							placeholder="Enter Course Code here.." class="form-control bd" name="courseCode"
							value="<%=DataUtility.getStringData(bean.getCourseCode())%>"> <font
							color="red"><%=ServletUtility.getErrorMessage("courseCode", request)%></font>
					</div>
					
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
							class="form-label" >StartDate</label>
						<input type="text" 
							placeholder="Enter Start Date here.." id="datepicker1" class="form-control bd" name="startDate"
							value="<%=DataUtility.getDateString(bean.getStartDate())%>" readonly="readonly"> <font
							color="red"><%=ServletUtility.getErrorMessage("startDate", request)%></font>
					</div>
					
					<div class="form-outline mb-4">
					 <label
							class="form-label" >Total Class</label>
						<input type="text" 
							placeholder="Enter Total Class here.." class="form-control bd" name="totalClass"
							value="<%=DataUtility.getStringData(bean.getTotalClass())%>"> <font
							color="red"><%=ServletUtility.getErrorMessage("totalClass", request)%></font>
					</div>
					
					<div class="form-outline mb-4">
					 <label
							class="form-label" >Timing</label>
						<input type="text" 
							placeholder="Enter Timing here.." class="form-control bd" name="timing"
							value="<%=DataUtility.getStringData(bean.getTiming())%>"> <font
							color="red"><%=ServletUtility.getErrorMessage("timing", request)%></font>
					</div>
					
					<div class="form-outline mb-4">
					 <label
							class="form-label" >Cost</label>
						<input type="text" 
							placeholder="Enter Cost here.." class="form-control bd" name="cost"
							value="<%=DataUtility.getStringData(bean.getCost())%>"> <font
							color="red"><%=ServletUtility.getErrorMessage("cost", request)%></font>
					</div>
					
					<div class="form-outline mb-4">
					 <label
							class="form-label" >Status</label>
						<input type="text" 
							placeholder="Enter Name here.." class="form-control bd" name="status"
							value="<%=DataUtility.getStringData(bean.getStatus())%>"> <font
							color="red"><%=ServletUtility.getErrorMessage("status", request)%></font>
					</div>
					
					<div class="form-outline mb-4">
					 <label
							class="form-label" >Description</label>
						<textarea rows="4" cols="4" 
							placeholder="Enter Description here.." class="form-control bd" name="description"
							><%=DataUtility.getStringData(bean.getDescription())%></textarea><font
							color="red"><%=ServletUtility.getErrorMessage("description", request)%></font>
					</div>

					
					<!-- Submit button -->
					<input type="submit" class="btn btn-primary  mb-4" name="operation"
						value="<%=CourseCtl.OP_SAVE%>">&nbsp;&nbsp; <input
						type="submit" class="btn btn-primary  mb-4" name="operation"
						value="<%=CourseCtl.OP_RESET%>">
				</form>
			</div>
			<div class="col-5"></div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>