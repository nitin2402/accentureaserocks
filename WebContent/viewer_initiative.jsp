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
<link href="pdfreadonly_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <%
		HttpSession session1 = request.getSession(false);
		if (session1 == null
				|| (String) session1.getAttribute("user") == null
				/* || (String) session1.getAttribute("admin") != "admin" */) {
	%><jsp:forward page="login.jsp?msg=Please Login as an Admin" />
	<%
		}
	%> 
	
	<%@ include file="header_viewer.jsp" %>  

	<div id="templatemo_content">

			<%@ include file="common_left.jsp" %>  

		 <div id="content_right">

			<div class="right_col_section_w650">

				<div class="header_01">Initiatives</div>
					<div class="container">
					 	<iframe name="docframe" id="dframe" src="C:\Users\sachin.a.bhardwaj\Downloads\apache-tomcat-7.0.62-windows-x86\apache-tomcat-7.0.62\webapps\data\Sample3.pdf" width="600" height="400" frameborder="0" ></iframe>
					</div>  
					
				
				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		
		<div id="templatemo_content_bottom">&nbsp;</div>
		<div id="templatemo_footer">
			Copyright © 2015 <a href="www.accenture.com">Accenture</a>
		</div>
	</div>
</body>
</html>