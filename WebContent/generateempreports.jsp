<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Talent Management Tool</title>
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="admintool.js"></script> 
<meta charset="utf-8" />
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
  <script type='text/javascript' src='searchAdmin.js'></script>
  <script type='text/javascript' src='search.js'></script>
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
  <script>
  function validateform(){
		var moduleName = document.forms["request"]["status"].value;
		var startDate = document.forms["request"]["startdate"].value;
		var endDate = document.forms["request"]["enddate"].value;
		if((status == null || status =="")&& (startdate == null|| startdate == "")&& (enddate == null || enddate == "")){
			alert("Fields cannot be empty");
			return false;
		}
	}
  </script>
</head>
<body>
<%@ include file="header_admin.jsp" %>
	<div id="templatemo_content">
	<%@ include file="common_left.jsp" %>
		<div id="content_right">
			<div class="right_col_section_w650" style="height: auto;">
				<div class="header_01">Reports Generated for Requests </div>
				<script>
 					 $(function() {
 					 $( "#datepicker1" ).datepicker();
 					 });
  				</script>
				<div id="search">
				<form  name ="request" action="EmployeeReportServlet" method="post"  onsubmit ="return validateform()">
				<table>
				<tr>
				<td>PLEASE SELECT THE STATUS &nbsp;&nbsp;</td>
				<td>
				<select name="status">
					<option value="">--Please select--</option>
 				 	<option value="pending">Pending</option>
  					<option value="onhold">OnHold</option>
 				 	<option value="accepted">Accepted</option>
					<option value="rejected">Rejected</option>
				</select>
				</td>
				</tr>
				<tr>
				<td>START DATE:<td> <input type="text" id="datepicker" name="startdate" /></td></td>
				</tr>
				<tr>
				<td>END DATE: <td><input type="text" id="datepicker1" name="enddate" /></td></td>
				</tr>
				</table>
				<br />
				<br />
				<button type="submit" value="Submit" style="margin-left:100px">Generate Report</button>
				</form>
				<br />
				<br />
					<br /> 
					<br />
					<br />
					<br />
					<div class="notification">${message}</div>
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