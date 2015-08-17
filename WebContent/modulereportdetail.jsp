<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Talent Management Tool</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type='text/javascript' src='search.js'></script>

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
          <div class="right_col_section_w650" style="height: auto">

			
				<div class="header_01" >Report Generated For Module</div>
					
					<h2 style="color:white;">Reports</h2>
					<div id= "search">
					<div id="scrollable"   style="font-size: 14px;">
						<table class="table2" > 
						
							<thead style="font-weight:bold;position: ">
							<tr class="one" style="font-weight:bold;">
							    <td>Module Id</td>
								<td>Module Name</td>
								<td>Project Id</td>
								<td>Module Description</td>
								<td>User Name</td>
								<td>Action</td>
								<td>Time Stamp</td>
							
							</tr>
							</thead>
						
							<tbody  >
							<jstlcore:forEach items="${ReportList}" var="item">
								<tr class="table_align">
									
									
									<td><jstlcore:out value="${item.moduleId}" /></td>
									<td><jstlcore:out value="${item.moduleName}" /></td>
									<td><jstlcore:out value="${item.projectId}" /></td>
									<td><jstlcore:out value="${item.moduleDescription}" /></td>
									<td><jstlcore:out value="${item.userName}" /></td>
									<td><jstlcore:out value="${item.action}" /></td>
									<td><jstlcore:out value="${item.timeStamp}" /></td> 
								</tr>
							</jstlcore:forEach></tbody></table>
							<p style="font-size: 14px; color: white; margin:22px"><%=request.getParameter("msg") != null ? request
					.getParameter("msg") : ""%></p>
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