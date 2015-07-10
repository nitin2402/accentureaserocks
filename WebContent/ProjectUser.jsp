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
$(document).ready(function(){
    
        $("#current").hide();
         
    });
</script>
<script>
$(document).ready(function(){
    
        $("#release").hide();
         
    });
</script>
<script>
$(document).ready(function(){
    $("#current1").click(function(){
        $("#current").toggle();
         
    });
});
</script>
<script>
$(document).ready(function(){
    $("#release1").click(function(){
        $("#release").toggle();
         
    });
});
</script>
<script>
	$(document).ready(function() {
		$(".header_09").hide();

	});
</script>
<script type='text/javascript' src='search.js'></script>
</head>


<body>
	<jsp:include page="/ProjectCurrent"/>
	<jsp:include page="/ProjectRelease"/>
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
<%@ include file="header_users.jsp" %>  

	<div id="templatemo_content">
	
	<%@ include file="common_left_admintool.jsp"%>



		<div id="content_right">

			<div class="right_col_section_w650">

				<div class="header_01">Project</div>


				<div id="search">

					<h1 id="current1" ><a href="#"> Current Release</a></h1>
					<div id="scrollable" style="font-size: 14px;">
						<table class="table2" id="current">

							<thead style="font-weight: bold; position:" >
								<tr class="one" style="font-weight: bold;">
									
									<td>Current Release</td>
									<td>Project Name</td>

								</tr>
							</thead>
						
							<br/>
							<tbody>
								<jstlcore:forEach items="${current}" var="item">
									<tr>
										<!-- <td><input type="text" name="currentRelease" value=""></input></td> -->

								
										<td><jstlcore:out value="${item.currentRelease}" /></td>
										<td><jstlcore:out value="${item.projectName}" /></td>

									</tr>
								</jstlcore:forEach>
							</tbody>
						</table>
					</div>
					<h1 id="release1">
						<a href="#"> Release Date </a>
					</h1>
					<div id="scrollable" style="font-size: 14px;">
						<table class="table2" id="release">

							<thead style="font-weight: bold; position:">
								<tr class="one" style="font-weight: bold;">

									<td>Current Release</td>
									<td>Release Date</td>

								</tr>
							</thead>

							<br />
							<tbody>
								<jstlcore:forEach items="${release}" var="item">
									<tr>
										<!-- <td><input type="text" name="currentRelease" value=""></input></td> -->


										<td><jstlcore:out value="${item.currentRelease}" /></td>
										<td><jstlcore:out value="${item.releaseDate}" /></td>

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
			<%@ include file="footer.jsp"%>
		</div></body>
</html>