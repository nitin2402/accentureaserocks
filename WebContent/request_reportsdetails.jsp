<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Talent Management Tool</title>
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="admintool.js"></script> 
  <script type='text/javascript' src='search.js'></script>
  <script type='text/javascript' src='searchAdmin.js'></script>
<meta charset="utf-8">
 
</head>
<body>
	<%@ include file="header_admin.jsp" %>
	
   <%
		HttpSession session1 = request.getSession(false);
		if (session1 == null
				|| (String) session1.getAttribute("user") == null
				|| (String) session1.getAttribute("admin") != "admin") {
	%><jsp:forward page="login.jsp?msg=Please Login as an Admin" />
	<%
		}
	%> 

	<div id="templatemo_content">
		<%@ include file="common_left.jsp" %>
		<div id="content_right">
			<div class="right_col_section_w650" style="height: 300px">
				
  				<div id = "search">
  				<div id="scrollable"   style="font-size: 14px;">
  				<table class="table2" > 
							<thead style="font-weight:bold;position: ">
							<tr class="one" style="font-weight:bold;">
								<td>ReqId</td>
								<td>Team Name</td>
								<td>No of A.S.E.</td>
								<td>No of S.E.</td>
								<td>No of S.S.E.</td>
								<td>Comment</td>
								<td>Status ID</td>
								<td>Employee Id</td>
								<td>Employee Name</td>
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
				</div>
				<div id="ajaxResponse"></div>
				<div class="margin_bottom_20">&nbsp;</div>
					<div align="center"><a href="mainreports.jsp" style="color : yellow ;">BACK</a></div>
			</div>
			<div class="cleaner">&nbsp;</div>
		</div>
		
		<%@ include file="footer.jsp" %>
	</div>
</body>
</html>