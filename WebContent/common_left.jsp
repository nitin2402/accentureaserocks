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
<script type="text/javascript" src="jquery-1.3.2.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
    $('#active_page a').each(function(index) {
        if(this.href.trim() == window.location)
            $(this).addClass("selected");
    });
});
</script>

<style>
.selected {      
  	text-decoration: underline !important;
    font-weight: bold !important; 
}
</style>



	
	
</head>
<body>

	<div id="content_left">
	<%
				 if( ((String) session.getAttribute("admin") == "user")|| ((String) session.getAttribute("admin") == "admin")){ 
			%>
			
			<div class="content_left_section">
				<div class="content_left_section_title">Search Employee</div>
				<div class="content_left_section_content">
					<form action="#">
						<span style="font-size: 14px">Name</span><input type="text" id="search_field" name="search_field" />
						<!--  <input
							type="submit" value="Search" id="search_button" /> -->
						<div>
							<span id="msg1">${param.msg1}</span>
						</div>

					</form>
					<div class="cleaner">&nbsp;</div>
					<br/>
				</div>
				<div class="cleaner">&nbsp;</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>
			
			<div class="content_left_section" style="font-size: 14px">
				<div class="content_left_section_title">Projects</div>
				<div class="content_left_section_content" >
				<ul id="active_page">
					<li><a href="project_tree.jsp?projectId=PR01" id="EstrategyCss">E-Strategy</a></li>
						<li><a href="project_tree.jsp?projectId=PR02" id="R3Css">R3</a></li>
						<li><a href="project_tree.jsp?projectId=PR03" id="PrimierCss">Premier</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>
			
<%
				 } 
			%>
		
		<%
				 if ((String) session.getAttribute("admin") == "viewer") { 
			%>

			<div class="content_left_section" style="font-size: 14px">				
				<div class="content_left_section_title">View</div>
				<div class="content_left_section_content">
				
					
					<ul>
						<li><a href="viewemployee_user.jsp" >View Employee</a></li>
						<li><a href="viewteam_user.jsp">View Team</a></li>
						<li><a href="viewmodule_user.jsp" >View Module</a></li>
					</ul>
				</div>

		
			<div class="content_left_section" style="font-size: 14px">
				<div class="content_left_section_title">Projects</div>
				<div class="content_left_section_content">
					<ul>
					<li><a href="project_tree.jsp?projectId=PR01" id="EstrategyCss">E-Strategy</a></li>
						<li><a href="project_tree.jsp?projectId=PR02" id="R3Css">R3</a></li>
						<li><a href="project_tree.jsp?projectId=PR03" id="PrimierCss">Premier</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			
				</div>		
			</div>
						<div class="margin_bottom_20">&nbsp;</div>
		
			<%
				 } 
			%>
</div>
</body>
</html>