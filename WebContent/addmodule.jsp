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

<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="addmodule.js"></script> 
<script>
	$(document).ready(function() {
		$(".header_09").hide();
	});
</script>
<script >
$(document).ready(function(){

        $("#modCss").css({
           
            	"font-weight": "bold",
            	"text-decoration": "underline"
        });
    });

	</script>


<script type='text/javascript' src='search.js'></script>
</head>
<body>


<%@ include file="header_admin.jsp" %>
	<%

HttpSession session1 = request.getSession(false);
if (session1 == null || (String)session1.getAttribute("user") == null || (String)session1.getAttribute("admin") != "admin" ){
    %><jsp:forward page="login.jsp?msg=Please Login as an Admin" /><%
}
%>
	

	<div id="templatemo_content">

		<%@ include file="common_left_admintool.jsp" %>
		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Module Addition</div>


				<div id="search">


					<div style="font-size: 14px;">
						<jsp:include page="/fetchproject.jsp" />
						<form name="add" action="AddModule" onsubmit="return validateform1()" >						 
							<table>
					
									
								<tr>
									<td>MODULE NAME:</td>
									<td><input type="text" name="modulename" id="module_name"></input></td>
								</tr>
								<tr>
									<td>MODULE DESCRIPTION:</td>
									<td><input type="text" name="moduledesc" id="module_desc"></input></td>
								</tr>
								<tr>
									<td>PROJECT:</td>
									<td> <select name="project1">
															<jstlcore:forEach var="proj" items="${project}">

												<option value="${proj}"> ${proj} </option>

									</jstlcore:forEach>
									</select>
									</td>
			</tr> 
								<tr>
									<td><input type="submit" value="SUBMIT" ></input></td>
								
									 <td><input type="reset" value="RESET" name="clear" ></input></td>
								</tr>
									 

									
							</table>
							
					
						</form>

						<br /> <br /> <!-- <a href="editmodule.jsp" style="font-weight: normal;margin-left:500px">Edit module</a> -->
					</div>
					
								
  <p class = "message"><%=request.getParameter("message") != null ? request
					.getParameter("message") : ""%>${message}</p>



					<div class="cleaner">&nbsp;</div>
				</div>
<div id="ajaxResponse"></div>
				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		<%@ include file="footer.jsp" %>
	</div>


</body>
</html>