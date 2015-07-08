<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Talent Management Tool</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="searchrequest.js"></script> 

</head>
<body>
<jsp:include page="/SearchRequestServlet" />
 <%
		HttpSession session1 = request.getSession(false);
		if (session1 == null
				|| (String) session1.getAttribute("user") == null
				/* || (String) session1.getAttribute("admin") != "admin" */) {
	%><jsp:forward page="login.jsp?msg=Please Login as an Admin" />
	<%
		}
	%> 
	
<%@ include file="header_admin.jsp" %>  

	<div id="templatemo_content">

		<div id="content_left">

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

			
				<div class="header_01" >Status of user requests</div>
				<h2 style="color:white;">Unapproved Requests</h2>
				
				<form name="actionForm" action="ActionServlet" >
					<div id="scrollable"   style="font-size: 14px;">
						
						
						<table class="table2" > 
							<thead style="font-weight:bold;position: ">
							<tr class="one" style="font-weight:bold;">
								<td>Select</td>
								<td>ReqId</td>
								<td>Team Name</td>
								<td>No_Of_ASE</td>
								<td>No_of_SE</td>
								<td>No_of_SSE</td>
								<td>comment</td>
								<td>Status</td>
							</tr>
							</thead>
						
							<tbody  >
							
							<jstlcore:forEach items="${unapproved_requests}" var="item">
								<tr>
									<td><input type="radio" name="select" value="${item.reqId}" <jstlcore:if test="${item.statusName == 'Rejected'}">disabled</jstlcore:if>	/></td>
									<td><jstlcore:out value="${item.reqId}" /></td>
									<td><jstlcore:out value="${item.teamName}" /></td>
									<td><jstlcore:out value="${item.nASE}" /></td>
									<td><jstlcore:out value="${item.nSE}" /></td>
									<td><jstlcore:out value="${item.nSSE}" /></td>
									<td><jstlcore:out value="${item.comment}" /></td>
									<td><jstlcore:out value="${item.statusName}" /></td> 
								</tr>
							</jstlcore:forEach></tbody></table>
							</div>
							<br />
						<div>
						*Reason &nbsp; <textarea rows="3" cols="25" id="reason" name="reason"></textarea>
						
						</div>
						<br />
							<input type="submit"  name="action" value="Calculate" onclick="return validateForm()"/>
							<input type="submit" name="action" value="Accept" onclick="return validateButtonAccepted()"/>
							<input type="submit" name="action" value="Reject" onclick="return validateButtonRejected()"/>
							<input type="submit" name="action" value="OnHold" onclick="return validateButtonOnHold()"/>
							
							</form>
							<br />
							
						<div style="color: blue;font-size: 12px">${reqId}  ${result}</div>

						<br />
							<h2 style="color:white;">Approved Requests</h2>
							
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
								<td>Status</td>
							</tr>
							</thead>
						
							<tbody  >
							
							
							<jstlcore:forEach items="${approved_requests}" var="item">
								<tr>
									
									
									<td><jstlcore:out value="${item.reqId}" /></td>
									<td><jstlcore:out value="${item.teamName}" /></td>
									<td><jstlcore:out value="${item.nASE}" /></td>
									<td><jstlcore:out value="${item.nSE}" /></td>
									<td><jstlcore:out value="${item.nSSE}" /></td>
									<td><jstlcore:out value="${item.comment}" /></td>
									<td><jstlcore:out value="${item.statusName}" /></td> 
								</tr>
							</jstlcore:forEach></tbody></table>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		
		<div id="templatemo_content_bottom">&nbsp;</div>
		<div id="templatemo_footer">
			Copyright © 2015 <a href="www.accenture.com">Accenture</a>
		</div>
	</div>
	</div>
</body>
</html>