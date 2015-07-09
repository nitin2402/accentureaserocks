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

<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<!-- <script>
	$(document).ready(function() {
		$(".header_09").hide();
		
	
	});
	
	

</script> -->



<script>

	function validateform()
	{
	
	var name=document.forms["add"]["name"].value;
	var id=document.forms["add"]["idno"].value;
	var level=document.forms["add"]["level"].value;
	var designation=document.forms["add"]["desig"].value;
	var expertise=document.forms["add"]["area"].value;

	var email=document.forms["add"]["email"].value;

	var cams=document.forms["add"]["camps"].value;
	
	var from = $("#calendar").val(); 
	var to = $("#calendar1").val();
	
  if (name==null || name=="")
	  {
	  alert("Please provide Name");
	  return false;
	  }
		if (id==null || id=="")
	  {
	  alert("Please provide Employee ID");
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
	if (cams==null || cams=="")
	  {
	  alert("Please provide Proficiency in CAMS");
	  return false;
	  }  
	if (from == "" || from == null){
		alert("Please enter Date Of joining");
		return false;
	}

	if(Date.parse(from) > Date.parse(to)){
	   alert("Last Date Of Working must be after Date Of Joining");
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
	    if (client.length == 6) {
	        
	    }
	    else {
	    	alert("Enter Valid Client Id ");
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
	    } 

	    
	/* var from = $("#calendar").val(); 
	var to = $("#calendar1").val(); */
	
	/* if (from == "" || from == null){
		alert("Please enter Date Of joining");
		return false;
	}

	if(Date.parse(from) > Date.parse(to)){
	   alert("Last Date Of Working must be after Date Of Joining");
	   return false;
	} */
	
	}
	
</script>

<!-- <script>
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
</script> -->

<script type="text/javascript">

        var specialKeys = new Array();

        specialKeys.push(8); //Backspace

        function IsNumeric1(e) {

            var keyCode = e.which ? e.which : e.keyCode

            var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);

            document.getElementById("error").style.display = ret ? "none" : "inline";

            return ret;

        }

    </script>

<link rel='stylesheet' type='text/css'
	href='http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css' />
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>



<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>


<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type='text/javascript' src='date.js'></script>
<script type="text/javascript" src="js/jquery.ui.datepicker.validation.js"></script>
<link href="calendar.css" rel="stylesheet" />
<script type='text/javascript' src='search.js'></script>
</head>
<body> <jsp:include page="/TeamListServlet" /> 
	
	<%@ include file="header_admin.jsp" %>
	<%
		HttpSession session1 = request.getSession(false);

		if (session1 == null

		|| (String) session1.getAttribute("user") == null

		|| (String) session1.getAttribute("admin") != "admin") {
	%><jsp:forward page="login.jsp?msg=Please Login as an Admin" />

	<%
		}
	%>
	

	<div id="templatemo_content">

			<%@ include file="common_left_admintool.jsp"%>

		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Employee Addition</div>


				<div id="search">

					<div id="scrollable" style="font-size: 14px;">

						<form name="add" action="AddEmployeeManual" method="post"
							onsubmit="return validateform()">
							<table>
								<tr>
									<td>EMPLOYEE NAME:</td>
									<td><input type="text" name="name"></input></td>

								</tr>
								<tr>
									<td>EMPLOYEE ID:</td>
									<td><input type="text" name="idno"
										onkeypress="return IsNumeric1(event);"></input></td>
									<span id="error" style="color: Black; display: none">
										*Input digits (0 - 9)</span>

								</tr>
								<tr>
									<td>EMPLOYEE LEVEL:</td>
									<td><input type="text" name="level"
										onkeypress="return IsNumeric1(event);"></input></td>
									<span id="error" style="color: Black; display: none">
										*Input digits (0 - 9)</span>

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
									<td>TEAM</td>
									<td><select name="Team" style="width: 143px">
											<jstlcore:forEach items="${teamList}" var="item">

												<option value="${item}">
													<jstlcore:out value="${item}"></jstlcore:out></option>


											</jstlcore:forEach>

									</select></td>
								</tr>
								<tr>
									<td>PROFICIENCY CAMS:</td>
									<td><input type="text" name="camps"></input></td>
								</tr>
								<tr>
									<td>PROFICIENCY PROJECT:</td>
									<td><input type="text" name="Project"></input></td>
								</tr>
								<tr>
									<td>DATE OF JOINING:</td>
									<td><input type="text" name="doj" id="calendar"></input></td>
								</tr>
								<tr>
									<td>LAST WORKING DATE:</td>
									<td><input type="text" name="last" id="calendar1"></input></td>
								</tr>
								<tr>
									<td>BILLABLE:</td>
									<td>
										<!-- <input type="text" name="bill"></input> --> <select
										type="text" name="bill" style="width: 143px">
											<option value="" disabled="disabled" selected="selected">Select</option>
											<option value="YES">YES</option>
											<option value="NO">NO</option>
											<option value="NA">NA</option>
									</select>
									</td>
								</tr>
								<tr>
									<td>ACITVE USER:</td>
									<td><input type="text" name="active" value="YES"></input></td>
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

					<div id="ajaxResponse"></div>
					<p class="error" style="font-size: 14px; color: red;">${message}</p>
				<div class="cleaner">&nbsp;</div>
				</div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		<%@ include file="footer.jsp" %>     
		</div>
	</div>
</body>
</html>