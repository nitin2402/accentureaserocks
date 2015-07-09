<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pyramid Optimization</title>
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

<script type='text/javascript' src='search.js'></script>




</head>
<body>
 <% 
		HttpSession session1 = request.getSession(false);
 %>
		<%-- <%-- if (session1 == null
				|| (String) session1.getAttribute("user") == null
				/*  || (String) session1.getAttribute("admin") != "admin" */ ) {
	%><jsp:forward page="login.jsp?msg=Please Login " />
	<%
		}  --%>
	    
	
	<%@ include file="header_users.jsp" %>

	<div id="templatemo_content">
	
		<%@ include file="common_left.jsp"%>
		
	<!-- 	<div id="content_left">

 
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
 -->

		<div id="content_right">

			<div class="right_col_section_w650">

				<div class="header_01">Project</div>


				<div id="search">


					<div id="scrollable" style="font-size: 14px;">
						<table class="table2">

							<thead style="font-weight: bold; position:">
								<tr class="one" style="font-weight: bold;">
									
									<td>Current Release</td>
									<td>Release Date</td>

								</tr>
							</thead>

							<tbody>
								<jstlcore:forEach items="${current}" var="item">
									<tr>
										<!-- <td><input type="text" name="currentRelease" value=""></input></td> -->


										<td><jstlcore:out value="${item.CurrentRelease}" /></td>
										<td><jstlcore:out value="${item.ProjectName}" /></td>

									</tr>
								</jstlcore:forEach>
							</tbody>
						</table>
					</div>
				</div>
								<div id="ajaxResponse"></div>
				<p class="error" style="font-size: 14px; color: red;">${message}</p>

				<div class="cleaner">&nbsp;</div>
			</div>
		<%@ include file="footer.jsp" %>     
	</div>
</body>
</html>