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

<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script>
	$(document).ready(function() {
		$(".header_09").hide();
	});
</script>
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

	function SelectSheetNo() {
		var sheet = prompt("please enter sheet number", "1");

		$("#sheetno").val(sheet);

		if (sheet == null || sheet == "") {
			alert("please enter sheet number");
			return false;
		} else {

			return true;
		}
	}
</script> 

 <script >
var validFileExtensions = [".xlsx", ".xls"];    
function Validate(vaildateObj) {
    var getFileName = vaildateObj.getElementsByTagName("input");
  
    for (var i = 0; i < getFileName.length; i++) {
        var fileInput = getFileName[i];
        if (fileInput.type == "file")
        	  var fileName = fileInput.value;
        {
        	  if (fileName == "" ||fileName==null || fileName==0)  
                  
              {
              	alert("please select a excel file to upload");
              		return false;
              } 
        	  else{
          
            if (fileName.length > 0) {
                var isValid = false;
                for (var j = 0; j < validFileExtensions.length; j++) {
                    var extensions = validFileExtensions[j];
                    if (fileName.substr(fileName.length - extensions.length, extensions.length).toLowerCase() == extensions.toLowerCase()) {
                        isValid = true;
                       /*  alert("success"); */
                        return SelectSheetNo();
                    }
                }  
                if (!isValid) {
                    alert("Sorry " + fileName + " is invalid, allowed extensions are: " + validFileExtensions.join(", "));
                    return false;
                }
                
            }
            
            
            }
          
        }
    }
  
    
}
</script> 


</head>
<body>
<%-- 	 <jsp:include page="/fetchmodule.jsp" />  --%>

	<%-- <%

HttpSession session1 = request.getSession(false);
if (session1 == null  || (String)session1.getAttribute("user") == null || (Boolean)session1.getAttribute("admin") != true ){
    %><jsp:forward page="login.jsp?msg=Please Login as an Admin" />
	<%
}
%> --%>
	<div id="templatemo_container" />
	<div id="templatemo_header">
		<div id="site_title_section">
			<div id="site_title">Talent Management Tool</div>
			<div id="slogan">The place to look back</div>
			<div class="cleaner">&nbsp;</div>
		</div>
		<div id="welcome_msg"
			style="color: yellow; float: right; font-size: 12px;">
			Welcome ${user}&nbsp;<a href="logout.jsp">Logout</a>
		</div>
		<div id="header_section_code">"Overall approach is to maintain
			pyramid form for all designation levels as per Accenture compliance."</div>
	</div>

	<div id="templatemo_menu">
		<ul>
			<li><a href="adminhome.jsp">Home</a></li>
			<li><a href="admintool.jsp">Admin Tools</a></li>
			<li><a href="#">Workplan</a></li>
			<li><a href="#">Projects</a></li>
			<li><a href="#">About Us</a></li>
			<!-- <li><a href="logout.jsp">Logout</a></li> -->
			<li><a href="#" class="last">Contact Us</a></li>
		</ul>
	</div>

	<div id="templatemo_content">

		<div id="content_left">

			<div class="content_left_section" style="font-size: 14px">
				<div class="content_left_section_title">Tasks</div>
				<div class="content_left_section_content">
					<ul>
						<li><a href="admintool.jsp" class="current" >Add Employee </a></li>


						<li><a href="addmodulevia.jsp">Add Module</a></li>
						<li><a href="addteamvia.jsp" style="font-weight: bold; text-decoration: underline">Add Team</a></li>
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

				<div class="header_01">Select File to upload</div>


				<div>


					<div style="font-size: 14px;">
			

						<form action=" AddTeamExcel" method="post" onsubmit="return Validate(this);">
						
						Choose the Excel File to Upload:-
						<input type="file" name="file1" size="50" /> <br /> <br /> <br />
						<input type="hidden" id="sheetno" name="sheetno" />
						<br /> <input type="submit" value="SUBMIT" />
						</form>
						<br />
						
					</div>



					<div class="cleaner">&nbsp;</div>
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