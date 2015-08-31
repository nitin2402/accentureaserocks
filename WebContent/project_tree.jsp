<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="pdfreadonly_style.css" rel="stylesheet" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="QueryData.js"></script>
<script src="https://www.google.com/jsapi"></script>
<script type='text/javascript' src='search.js'></script>
<script type='text/javascript' src='project_tree_ctrl.js'></script>
<style>
table, th, td {
	border: 0px;
}
.teamclick{
font-size:12px;
}
.moduleclick{
font-size:15px;
height:30px;
}

</style>
<script>

</script>
</head>
<body onload="populate()">
	
			<%
				 if(((String) session.getAttribute("admin") == "admin")){ 
			%>
			
			<%@ include file="header_admin.jsp"%>
			
			<%
				 } 
			%>

			
			<%
				 if(((String) session.getAttribute("admin") == "user")){ 
			%>
			
			<%@ include file="header_users.jsp"%>
			
			<%
				 } 
			%>
		
		
			<%
				 if(((String) session.getAttribute("admin") == "viewer")){ 
			%>
			
			<%@ include file="header_viewer.jsp"%>
			
			<%
				 } 
			%>
	
	
	
	<div id="templatemo_content">

		<%@ include file="common_left.jsp"%>

		<div id="content_right">

			<div class="right_col_section_w650"  style="min-height:350px">
				

					<div class="header_01">Project Structure of </div>
					<div id="search">
					<div style="width: 300px;float:left">
						<ul id="tree"></ul>
					</div>
					<div style="float:left;margin-left: -82px;" id="barGraph"></div>
					<div class="margin_bottom_20">&nbsp;</div>
				</div>
		
			<div id="ajaxResponse"></div>
<div class="margin_bottom_20">&nbsp;</div>
		</div>
			</div>

	</div>
	<%@ include file="footer.jsp"%>
	
</body>
</html>