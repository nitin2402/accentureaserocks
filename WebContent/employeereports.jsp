<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pyramid Optimization</title>
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="admintool.js"></script> 

<meta charset="utf-8">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
</head>
<body>
<%@ include file="header_admin.jsp" %>
<div id="templatemo_container" />
	<div id="templatemo_content">

		<div id="content_left">
			<div class="content_left_section" style="font-size: 14px">
				<div class="content_left_section_title">Tasks</div>
				<div class="content_left_section_content">
					<ul>
						<li><a href="admintool.jsp">Add Employee</a></li>
						<li><a href="addmodulevia.jsp">Add Module</a></li>
						<li><a href="addteam.jsp">Add Team</a></li>
					</ul>

					<div class="cleaner">&nbsp;</div>
				</div>
				<div class="cleaner">&nbsp;</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>
			<div class="content_left_section" style="font-size: 14px">
				<div class="content_left_section_title">View</div>
				<div class="content_left_section_content">
				
					<ul>
						<li><a href="viewemployee.jsp">View Employee</a></li>


						<li><a href="viewteam.jsp">View Team</a></li>
						<li><a href="viewmodule.jsp">View Module</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>

		</div>

		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<script>
 					 $(function() {
 					 $( "#datepicker1" ).datepicker();
 					 });
  				</script>
  				<div id="scrollable"   style="font-size: 14px;">
  				<table class="table2" > 
  				
							<thead style="font-weight:bold;position: ">
							<tr class="one" style="font-weight:bold;">
								<td>ReqId</td>
								<td>Team Name</td>
								<td>No_Of_ASE</td>
								<td>No_of_SE</td>
								<td>No_of_SSE</td>
								<td>comment</td>
								<td>Status ID</td>
								<td>EmployeeId</td>
								<td>EmployeeName</td>
								<td>TimeStamp</td>
							</tr>
							</thead>
						
							<tbody  >
				<jstlcore:forEach items="${ReportList}" var="item">
								<tr>
									<td><jstlcore:out value="${item.reqId}" /></td>
									<td><jstlcore:out value="${item.teamName}" /></td>
									<td><jstlcore:out value="${item.nASE}" /></td>
									<td><jstlcore:out value="${item.nSE}" /></td>
									<td><jstlcore:out value="${item.nSSE}" /></td>
									<td><jstlcore:out value="${item.comment}" /></td>
									<td><jstlcore:out value="${item.statusName}" /></td> 
									<td><jstlcore:out value="${item.empId}" /></td> 
									<td><jstlcore:out value="${item.empName}" /></td> 
									<td><jstlcore:out value="${item.timestamp}" /></td> 
								</tr>
				</jstlcore:forEach></tbody></table>
				</div>
				<p style="font-size: 14px; color: white; margin:22px"><%=request.getParameter("msg") != null ? request
					.getParameter("msg") : ""%></p>
				<div>
				<br />
				<br />
					
					<br />
					<br />
					<br />
					<br />
					<div class="notification">${message}</div>

					<div class="cleaner">&nbsp;</div>
				</div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		<div id="templatemo_content_bottom">&nbsp;</div>
		<%@ include file="footer.jsp" %>
	</div>
</body>
</html>