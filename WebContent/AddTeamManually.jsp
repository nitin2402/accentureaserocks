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

<!-- <script>
	$(document).ready(function() {
		$(".header_09").hide();
		
	
	});
	
	

</script> -->
<script type="text/javascript">
	$(function() {
		$('.last').click(
				function(event) {
					var email = 'chinu.mohanty@accenture.com';
					var subject = 'Feedback';
					var emailBody = 'Hi Chinu,';
					window.location = 'mailto:' + email + '?subject=' + subject
							+ '&body=' + emailBody;
				});
	});
</script>


<script>

	function validateform()
	{
	
	var name=document.forms["add"]["name"].value;
	var id=document.forms["add"]["idno"].value;
	var level=document.forms["add"]["level"].value;
	var designation=document.forms["add"]["desig"].value;


	if (name==null || name=="")
	  {
	  alert("Please provide Team Name");
	  return false;
	  }
	if (id==null || id=="")
	  {
	  alert("Please provide Team ID");
	  return false;
	  }
	if (level==null || level=="")
	  {
	  alert("Please provide Module Name");s
	  return false;
	  }
	if (designation==null || designation=="")
	  {
	  alert("Please provide Team Description");
	  return false;
	  }
	
	
	    var filter = /^[a-zA-Z0-9._-]+@accenture.com$/;
	    var filter2 = /^[0-9]{8}$/;
	    var filter3 = /^[0-9]{1,2}$/;
	    if (filter.test(email)) {
	       
	    }
	    else {
	    	alert("Enter Valid Email");
	        return false;
	    }
	    if (att.length == 6) {
	        
	    }
	    else {
	    	alert("Enter Valid ATT ID ");
	        return false;
	    }
	    if (filter2.test(id)) {
	      
	    }
	    else {
	    	alert("Enter Valid Employee Id");
	        return false;
	    }
	    if (filter3.test(level)) {
		       
	    }
	    else {
	    	alert("Enter Valid Level");
	        return false;
	    }​

function isNumeric(value) {
	  if (value=="" || value == null || !value.toString().match(/^[-]?\d*\.?\d*$/))
	  { return false;
	  }
	  return true;
	}		
	
	function validate(str){
		var pattern=/^[a-zA-Z0-9@.-()#_]{2,50}$/;
		if(str != pattern)
			{
			alert("Enter valid Characters(@, . , -, (, ), #, _)");
			}
		return Pattern.test(str); 
		
	}
</script>

</head>
<body>

	<div id="templatemo_container" />
	<div id="templatemo_header">
		<div id="site_title_section">
			<div id="site_title">Pyramid Optimization</div>
			<div id="slogan">The place to look back</div>
			<div class="cleaner">&nbsp;</div>
		</div>

		<div id="header_section_code">"Overall approach is to maintain
			pyramid form for all designation levels as per Accenture compliance."</div>
	</div>

	<div id="templatemo_menu">
		<ul>
			<li><a href="adminhome.jsp">Home</a></li>
			<li><a href="admintool.jsp" >Admin Tools</a></li>
			<li><a href="#">Workplan</a></li>
			<li><a href="#">Projects</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="logout.jsp">Logout</a></li>
			<li><a href="#" class="last">Contact Us</a></li>
		</ul>
	</div>

	<div id="templatemo_content">

		<div id="content_left">

			
			<div class="content_left_section" style="font-size: 14px">
				<div class="content_left_section_title">Tasks</div>
				<div class="content_left_section_content">
					<ul>
						<li><a href="addempmanually.jsp">Add Employee </a></li>


						<li><a href="addmodule.jsp">Add Module</a></li>
						<li><a href="AddTeamManually.jsp" style="font-weight: bold; text-decoration: underline">Add Team</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>
			<div class="content_left_section" style="font-size: 14px">
				<div class="content_left_section_title">View</div>
				<div class="content_left_section_content">
					
					<ul>
						<li><a href="viewemployee.jsp">View Employees</a></li>


						<li><a href="viewteam.jsp">View Teams</a></li>
						<li><a href="viewmodule.jsp">View Module</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>
			<div class="margin_bottom_20">&nbsp;</div>

		</div>

		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Team Addition</div>


				<div>

<div id="scrollable"   style="font-size: 14px;">
					
						<form name="add" action="AddTeamManual" method="post"
							onsubmit="return validateform()">
							<table>
								<tr>
									<td>TEAM NAME:</td>
									<td><input type="text" name="Tname"></input></td>

								</tr>
								<tr>
									<td>TEAM ID:</td>
									<td><input type="text" name="Tno"></input></td>
								</tr>
								<tr>
									<td>MODULE ID:</td>
									<td><input type="text" name="Mname"></input></td>
								</tr>
								<tr>
									<td>TEAM DESCRIPTION:</td>
									<td><input type="text" name="desc"></input></td>
								</tr>
								</table>
							<input class="submit" type="submit" value="Submit"></input> <input
								type="reset" value="Reset" id="clear" name="clear"></input><br />
							<br /> <span style="color: green"> <%-- <%=request.getParameter("msg") != null ? request
					.getParameter("msg") : ""%> --%></span><br />

						</form>
					</div>



					<div class="cleaner">&nbsp;</div>
				</div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		<div id="templatemo_content_bottom">&nbsp;</div>
		<div id="templatemo_footer">Copyright © 2015 <a href="www.accenture.com">Accenture</a>
		</div>
	</div>
</body>
</html>