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

		<div id="content_left">

			<div class="content_left_section">
				<div class="content_left_section_title">Search Employee</div>
				<div class="content_left_section_content">
					<form action="#">
						Name<input type="text" id="search_field" name="search_field" />
						<!--  <input
							type="submit" value="Search" id="search_button" /> -->
						<div>
							<span id="msg1">${param.msg1}</span>
						</div>

					</form>
					<div class="cleaner">&nbsp;</div>
				</div>
				<div class="cleaner">&nbsp;</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>
			<div class="content_left_section" style="font-size: 14px">
				<div class="content_left_section_title">Projects</div>
				<div class="content_left_section_content">
					<ul>
						<li><a href="viewEStrategy.jsp">E-Strategy</a></li>
						<li><a href="viewr3.jsp">R3</a></li>
						<li><a href="viewprimier.jsp">Primier</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>

		</div>


		
			<div id="content_right">
          <div class="right_col_section_w650" style="height: auto">

			
				<div class="header_01" >Report Generated For Module</div>
					
					<h2 style="color:white;">Reports</h2>
					<div id="scrollable"   style="font-size: 14px;">
						<table class="table2" > 
						
							<thead style="font-weight:bold;position: ">
							<tr class="one" style="font-weight:bold;">
							    <td>ModuleId</td>
								<td>ModuleName</td>
								<td>ProjectId</td>
								<td>ModuleDescription</td>
								<td>Username</td>
								<td>Action</td>
								<td>TimeStamp</td>
							
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
							<div class="margin_bottom_20">&nbsp;</div>
							
				</div>		
				<div class="cleaner">&nbsp;</div>	
</div>
						<%@ include file="footer.jsp" %> 
	</div>
</body>
</html>