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
	var expertise=document.forms["add"]["area"].value;
	/* var att=document.forms["add"]["att"].value; */
	var email=document.forms["add"]["email"].value;

	/* validate(name);
	validate(id);
	validate(level);
	validate(designation);
	validate(expertise);
	validate(experience);
	 */
	
	if (name==null || name=="")
	  {
	  alert("Please provide Name");
	  return false;
	  }
	if (id==null || id=="")
	  {
	  alert("Please provide ID");
	  return false;
	  }
	if (level==null || level=="")
	  {
	  alert("Please provide level");s
	  return false;
	  }
	if (designation==null || designation=="")
	  {
	  alert("Please provide designation");
	  return false;
	  }
	if (expertise==null || expertise=="")
	  {
	  alert("Please provide Expertise");
	  return false;	
	  }
	if (email==null || email=="")
	  {
	  alert("Please provide Email");
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

	/* 
	if (isNumeric(level)==false)
	  {
	  alert("Invalid Level");
	  return false;
	  }
	if (isNumeric(experience)==false)
	  {
	  alert("Invalid Experience");
	  return false;
	  } */
/*	if(validate(fname)==false){
		alert("Enter valid Characters(@, . , -, (, ), #, _)");
		return false;
	}
	*/
}
	/* function cancelRegistration()
	{
		history.go(-1);
	} */
	
	
</script>
<script>
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
	<%-- <%
		HttpSession session1 = request.getSession(false);
		if (session1 == null
				|| (String) session1.getAttribute("user") == null
				|| (Boolean) session1.getAttribute("admin") != true) {
	%><jsp:forward page="login.jsp?msg=Please Login as an Admin" />
	<%
		}
	%> --%>
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
			<li><a href="admintool.jsp" style="font-weight: bold; text-decoration: underline" >Admin Tools</a></li>
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
						<li><a href="addteam.jsp">Add Team</a></li>
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

				<div class="header_01">Employee Addition</div>


				<div>

<div id="scrollable"   style="font-size: 14px;">
					
						<form name="add" action="AddEmployeeManual" method="post"
							onsubmit="return validateform()">
							<table>
								<tr>
									<td>EMPLOYEE NAME:</td>
									<td><input type="text" name="name"></input></td>

								</tr>
								<tr>
									<td>EMPLOYEE ID:</td>
									<td><input type="text" name="idno"></input></td>
								</tr>
								<tr>
									<td>EMPLOYEE LEVEL:</td>
									<td><input type="text" name="level"></input></td>
								</tr>
								<tr>
									<td>EMPLOYEE DESIGNATION:</td>
									<td><input type="text" name="desig"></input></td>
								</tr>
								<tr>
									<td>EMPLOYEE EXPERTISE:</td>

									<td><input type="text" name="area"></input></td>
								</tr>
								<tr>
									<td>CLIENT ID:</td>
									<td><input type="text" name="client"></input></td>
								</tr>
								<tr>
									<td>EMAIL:</td>
									<td><input type="text" name="email"></input></td>
								</tr>
								
								<tr>
									<td>TEAM ID:</td>
									<td><input type="text" name="Team"></input></td>
								</tr>
								
								<tr>
									<td>Proficiency Camps:</td>
									<td><input type="text" name="camps"></input></td>
								</tr>
								<tr>
									<td>Proficiency Project:</td>
									<td><input type="text" name="Project"></input></td>
								</tr>
								<tr>
									<td>Date of Joining:</td>
									<td><input type="text" name="doj"></input></td>
								</tr>
								<tr>
									<td>Last Working Date:</td>
									<td><input type="text" name="last"></input></td>
								</tr>
								<tr>
									<td>Billable:</td>
									<td><input type="text" name="bill"></input></td>
								</tr>
								<tr>
									<td>Active User:</td>
									<td><input type="text" name="active"></input></td>
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