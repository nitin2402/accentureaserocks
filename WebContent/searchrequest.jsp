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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="searchrequest.js"></script> 
<script type='text/javascript' src='searchAdmin.js'></script>
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

		<%@ include file="common_left.jsp" %>  
		<div id="content_right">
				
			<div class="right_col_section_w650" style="height: auto" >
					<div id="search" style="font-size: 14px;">
			
				<div class="header_01" >Status of user requests</div>
				<h2 style="color:white;">Unapproved Requests</h2>
				
				<form name="actionForm" action="ActionServlet" >
					<div id="scrollable"   style="font-size: 14px;">
						
						
						<table class="table2" > 
							<thead style="font-weight:bold;position: ">
							<tr class="one table_align" style="font-weight:bold;">
								<td>Select</td>
								<td>Request ID</td>
								<td>Team Name</td>
								<td>No of A.S.E.</td>
								<td>No of S.E.</td>
								<td>No of S.S.E.</td>
								<td>Comment</td>
								<td>Status</td>
							</tr>
							</thead>
						
							<tbody  >
							
							<jstlcore:forEach items="${unapproved_requests}" var="item">
								<tr class="table_align">
									<td><input type="radio" name="select" value="${item.reqId}" <jstlcore:if test="${item.statusName == 'Rejected'}">disabled</jstlcore:if>	/></td>
									<td><jstlcore:out value="${item.reqId}" /></td>
									<td><jstlcore:out value="${item.teamName}"  /></td>
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
						Reason &nbsp; <textarea rows="3" cols="25" id="reason" name="reason"></textarea>
						[Mandatory for Rejecting or OnHolding Request]
						</div>
						
						<br />
							<input type="submit"  name="action" value="Continue" onclick="return validateForm()"/>
							<input type="submit" name="action" value="Reject" onclick="return validateButtonRejected()"/>
							<input type="submit" name="action" value="OnHold" onclick="return validateButtonOnHold()"/>
							<input type="reset" value="Reset"/>
							</form>
							<br />
							
						<div class="message">${reqId}  ${result}</div>

						<br />
							<h2 style="color:white;">Approved Requests</h2>
							
					<div id="scrollable"   style="font-size: 14px;">
							<table class="table2" > 
						
							<thead style="font-weight:bold;position: ">
							<tr class="one table_align" style="font-weight:bold;">
								<td>Request ID</td>
								<td>Team Name</td>
								<td>No of A.S.E.</td>
								<td>No of S.E.</td>
								<td>No of S.S.E.</td>
								<td>Comment</td>
								<td>Status</td>
							</tr>
							</thead>
						
							<tbody  >
							
							
							<jstlcore:forEach items="${approved_requests}" var="item">
								<tr class="table_align">
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
		</div>
				<div id="ajaxResponse"></div>
				<div class="cleaner">&nbsp;</div>
		</div>
		<div class="margin_bottom_20">&nbsp;</div>
	</div>
	
	<%@ include file="footer.jsp" %>  
	</div>
</body>
</html>