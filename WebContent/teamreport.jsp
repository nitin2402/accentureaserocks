<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Talent Management Tool</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<script src="teamreport.js"></script> 
 
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
</script>

<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

 <link rel='stylesheet' type='text/css'
	href='http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css' />
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js">
</script>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
 
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type='text/javascript' src='date.js'></script>
<script type="text/javascript" src="js/jquery.ui.datepicker.validation.js"></script>
<link href="calendar.css" rel="stylesheet" />
</head>

<body>

	 <jsp:include page="/TeamListServlet" /> 
	 
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

				<div class="header_01">Generate a Team Report</div>

				<div>
				<form name="teamreport" action="TeamReport" method="post" onsubmit ="return validateform()" >
				<p> PLEASE SELECT THE TEAM &nbsp; &nbsp;<select name="teamName">
				<option value="">--Please select--</option>
												<jstlcore:forEach items="${teamList}" var="item">
							
								<option	value="${item}"> <jstlcore:out value="${item}" ></jstlcore:out></option>
									
							
							</jstlcore:forEach>
														
												</select></p>
				<p> START DATE: <input type="text" id="calendar" name="startDate" style="margin-left:83px"/></p>
				<p>END DATE: <input type="text" id="calendar1" name="endDate" style="margin-left:95px" /></p>
				<br />
				<button type="submit" value="Submit" style="margin-left:90px">Generate Report</button>
				</form>
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
			<%@ include file="footer.jsp" %> 
		
	</div>
</body>
</html>