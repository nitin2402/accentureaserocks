<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />



<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	
<script>
	$(document).ready(function() {
		$(".header_09").hide();

	});
</script>
<script type='text/javascript' src='searchAdmin.js'></script>
</head>


<body>

	
 <%-- <% 
		HttpSession session1 = request.getSession(false);
 %>
		<%-- if (session1 == null
				|| (String) session1.getAttribute("user") == null
				/*  || (String) session1.getAttribute("admin") != "admin" */ ) {
	%><jsp:forward page="login.jsp?msg=Please Login " />
	<%
		} 
	    
	< --%>
<%@ include file="header_admin.jsp" %>  

	<div id="templatemo_content">
	
	<%@ include file="common_left.jsp"%>



		<div id="content_right">

			<div class="right_col_section_w650">

				<div class="header_01">Edit Current Release</div>
				
					<div id="search">
				<form name="edit" action="EditCurrent" method="post">
					<jstlcore:forEach items="${select1}" var="list">
						
							<table>
								<tr>
									<td>Project Name</td>
									<td><input type="text" value="${list.projectName}"
										disabled="disabled" style="width: 200px;" /> <input
										type="hidden" name="ProjectName" value="${list.projectName}" /></td>
								</tr>
								<tr>
									<td>Current Release</td>
									<td><input type="text" name="CurrentRelease"
										value="${list.currentRelease}" style="width: 200px;" /></td>

								</tr>
								<tr>
									<td>Release Date</td>
									<td><input type="text" name="ReleaseDate"
										value="${list.releaseDate}" style="width: 200px;" /></td>

								</tr>
								<tr>
									
								</tr>
							</table>
	</jstlcore:forEach>
	
					<input type="submit" value="Change" /> <br/>
	</form>

				
				
				<div class="margin_bottom_20">&nbsp;</div>
				</div>
			<div id="ajaxResponse"></div>

			<div class="cleaner">&nbsp;</div>
		</div>
		</div>
		<%@ include file="footer.jsp"%>
		</div>
		
		</body>
</html>