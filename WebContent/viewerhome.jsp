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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://www.google.com/jsapi"></script>
<script src="piechart.js"></script>



</head>
<body>
<div id="ajaxResponse"/>
	<%
		HttpSession session1 = request.getSession(false);
		if (session1 == null
				|| (String) session1.getAttribute("user") == null
				|| (String) session1.getAttribute("admin") != "viewer") {
	%><jsp:forward page="home.jsp?msg=Please Login" />
	<%
		}
	%>
	<div id="templatemo_container" />
	<%@ include file="header_viewer.jsp" %> 

	<div id="templatemo_content">

		<div id="content_left">
			
		

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


		<div id="content_right">

			<div class="right_col_section_w650">

				<div class="header_01" align="center">Welcome to Viewer Page</div>

				<div>

					
				<div class="header_09"></div>

				<div>

					<div id="piechart"
						style="background-colour: red; height: 300px; width: 600px"
						onclick="clickk()"></div>
						<div class="filter" ><span style="color: brown;font-size: 16px">Filter by</span><br/>
					<a onclick="filter('billability')">Billability</a> /
					<a onclick="filter('proficiency')">Proficiency</a> /
					<a onclick="filter('expertise')">Expertise</a>
					</div>

					<div class="cleaner">&nbsp;</div>
				</div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		</div>
<%@ include file="footer.jsp" %> 
	</div>
</body>
</html> 