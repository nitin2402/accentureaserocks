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
	function validateForm() {

		var myOption = -1;
		for (var i=form.select.length-1; i > -1; i--) {
		if (form.select[i].checked) {
		myOption = i; i = -1;
		}
		}
		if (myOption == -1) {
		alert("Please select to Edit");
		return false;
		}
					
	}
	</script>

<script>
	$(document).ready(function() {
		$(".header_09").hide();

	});
</script>
<script type='text/javascript' src='search.js'></script>
</head>


<body>
	<%@ include file="header_admin.jsp" %>  
	<jsp:include page="/ProjectCurrent"/>

	
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
	
	<%@ include file="common_left.jsp"%>



		<div id="content_right">

			<div class="right_col_section_w650">

				<div class="header_01">Project</div>


				<div id="search">

					<h1 id="current1" >Current Release</h1>
					<div id="scrollable" style="font-size: 14px;">
					<form name= "form" action="EditServlet" method="get">
							<table class="table2" id="current">

								<thead style="font-weight: bold; position:">
									<tr class="one" style="font-weight: bold;">
										<td></td>
										<td>Current Release</td>
										<td>Project Name</td>
										<td>Release Date</td>

									</tr>
								</thead>

								<tbody>
									<jstlcore:forEach items="${current}" var="item">
										<tr class="table_align">
											

											<td><input type="radio" name="select"
												value="${item.projectName}" /></td>
											<td><jstlcore:out value="${item.currentRelease}" /></td>
											<td><jstlcore:out value="${item.projectName}" /></td>
											<td><jstlcore:out value="${item.releaseDate}" /></td>

										</tr>
									</jstlcore:forEach>
								</tbody>
								
							</table>
							<input type="submit" name="button" onclick="return validateForm()" value="Edit"></input>
							</form>
					</div>
					
					<br/>
					<ul>
				<li><a href="Onboarding.jsp" style = "font-size: 14px">On Boarding</a>  </li>
				
				<li> <a href="RollOff.jsp" style = "font-size: 14px"> Roll off </a></li>
				</ul>
				
			<div id="welcome_msg"
			style="color: yellow; float: right; font-size: 12px;">
			<a href="AboutProjectadmin.jsp">About Project</a>
		</div>
		<div class="margin_bottom_20">&nbsp;</div>
		</div>
	<div id="ajaxResponse"></div>
				<p class="error" style="font-size: 14px; color: red;">${message}</p>

				<div class="cleaner">&nbsp;</div>
			</div>
			</div>
			<%@ include file="footer.jsp"%>
		</div>
		
		</body>
</html>