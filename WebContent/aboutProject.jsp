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
<script type='text/javascript' src='search.js'></script>
<style>
table, th, td {
    border: 0px; 
}
</style>
</head>


<body>
 <%
		HttpSession session1 = request.getSession(false);

		if (session1 == null

		|| (String) session1.getAttribute("user") == null

		|| (String) session1.getAttribute("admin") == "viewer") {
	%><jsp:forward page="login.jsp?msg=Please Login " />

	<%
		}
	%>
	<%
	if ((String) session1.getAttribute("admin") == "admin") {
%>
<%@ include file="header_admin.jsp" %>  
<%
	}
%>
<%
	if ((String) session1.getAttribute("admin") == "user") {
%>
<%@ include file="header_users.jsp" %> 
<%
	}
%>
	<div id="templatemo_content">
	
	<%@ include file="common_left.jsp"%>

				
		<div id="content_right">

			<div class="right_col_section_w650">

				<div class="header_01">About Project
						<div id="welcome_msg"
			style="color: yellow; float: right; font-size: 12px;">
			<a href="ProjectUser.jsp">Back</a>
		</div>
				</div>
				<div style="font-size: 14px;">
				<p>Following projects have been taken under ARISTOS:</p>
				<ul><li><b><u>E-Strategy</u></b></li>
	E-Strategy is one of the projects under ARISTOS.It includes E-Ordering , E-Status , Testing , Registration and MnM. 
				
				<br/><br/>
				<li><b><u>R3</u></b></li>
				R3 includes BIDR3-1 and BIDR3-2.
	BID: provides a single storefront (BID) where customers can easily find or be presented with relevant products and solutions based on their business needs. 
					<br/><br/>
				<li><b><u>Premier</u></b></li>
	Premier Enterprise Portal  is an online (web) portal of AT&T Mobility for B2B sales and support
    Premier architecture is based upon ATG framework and products
	Benefits for customers :
	Easier to purchase services, devices and accessories through personalization and targeted offers
	Bundled and custom offers
                               Sold across all states in the US.
                               It includes Premier1 , Premier2 , Premier3 , Premier4 and Premier5.

				
				</ul>
				
				</div>
			
		
				

				<div id="search">

					
				</div>
								<div id="ajaxResponse"></div>
				<p class="error message">${message}</p>

				<div class="cleaner">&nbsp;</div>
			</div>
			</div>
			<%@ include file="footer.jsp"%>
		</div></body>
</html>