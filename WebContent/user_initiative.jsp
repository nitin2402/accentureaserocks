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

<script type="text/javascript" src='search.js'></script>
</head>

<body>
	<%-- <jsp:include page="/FetchbudgetDetail" /> --%>
	<input type="hidden" id="backup" name="backup" value="0"></input>

	<%
		HttpSession session1 = request.getSession();
		if (session1 == null
				|| (String) session1.getAttribute("user") == null) {
	%><jsp:forward page="login.jsp?msg=Please Login " />
	<%
		}
	%> 
	<%@ include file="header_users.jsp" %>

	<div id="templatemo_content">

		<%@ include file="common_left.jsp" %>  

		 <div id="content_right">

			<div class="right_col_section_w650" style="height:auto;">

				<div class="header_01">Initiative</div>

				<div id="search">
				<div style="height: 350px">
				<object data='Docs/Sample3.pdf#' 
       					 type='application/pdf' 
       					 width='100%' 
      					  height='100%'>

						<p>No file uploaded.</p>

				</object>
				</div>
				</div>
				<div id="ajaxResponse"></div>

				<div class="cleaner">&nbsp;</div>
			</div>
		</div>
	<%@ include file="footer.jsp" %> 
	</div>
</body>
</html>