<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />



<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- <script>
$(document).ready(function(){
    
        $("#current").hide();
         
    });
</script>
<script>
$(document).ready(function(){
    
        $("#release").hide();
         
    });
</script>
<script>
$(document).ready(function(){
    $("#current1").click(function(){
        $("#current").toggle();
         
    });
});
</script>
<script>
$(document).ready(function(){
    $("#release1").click(function(){
        $("#release").toggle();
         
    });
});
</script> -->
<script>
	$(document).ready(function() {
		$(".header_09").hide();

	});
</script>
<script type='text/javascript' src='searchAdmin.js'></script>
</head>


<body>
	<jsp:include page="/ProjectCurrent"/>

 <%-- <% 
		HttpSession session1 = request.getSession(false);
 %>
		<%-- if (session1 == null
				|| (String) session1.getAttribute("user") == null
				/*  || (String) session1.getAttribute("admin") != "admin" */ ) {
	%><jsp:forward page="login.jsp?msg=Please Login " />
	<%
		} 
	    
	< --%>
<%@ include file="header_admin.jsp" %>  

	<div id="templatemo_content">
	
	<%@ include file="common_left.jsp"%>



		<div id="content_right">

			<div class="right_col_section_w650">

				<div class="header_01">Roll Off Checklist</div>


				<div id="search">
				<div class="text_size">
				<table>
	<tr>
		<td>1) Has user been allocated a laptop?</td>
		<td>
		<input type="radio" title="Has user been allocated a laptop?: yes" name="q0" id="q0_yes" value="yes">
		<label for="q0_yes">Yes</label> 
		<input type="radio" title="Has user been allocated a laptop?: no" name="q0" id="q0_no" value="no">
		<label for="q0_no">No</label>
		<input type="radio" title="Has user been allocated a laptop?: NA" name="q0" id="q0_na" value="na">
		<label for="q0_na">NA</label>
		</td>
	</tr>
	<tr>
		<td>2) Has user been allocated a headset?</td>
		<td>
		<input type="radio" title="Has user been allocated a headset?: yes" name="q1" id="q1_yes" value="yes">
		<label for="q1_yes">Yes</label> 
		<input type="radio" title="Has user been allocated a headset?: no" name="q1" id="q1_no" value="no">
		<label for="q1_no">No</label>
		<input type="radio" title="Has user been allocated a laptop?: NA" name="q1" id="q1_na" value="na">
		<label for="q1_na">NA</label>
		</td>
	</tr>
	<tr>
		<td>3) Desktop to be removed?</td>
		<td>
		<input type="radio" title="Desktop to be removed?: yes" name="q2" id="q2_yes" value="yes">
		<label for="q2_yes">Yes</label>
		<input type="radio" title="Desktop to be removed?: no" name="q2" id="q2_no" value="no">
		<label for="q2_no">No</label>
		<input type="radio" title="Desktop to be removed?: NA" name="q2" id="q2_na" value="na">
		<label for="q2_na">NA</label>
		</td>
	</tr>
	<tr>
		<td>4) Is Joining Bonus to be recovered ? Amount:Rs.30000</td>
		<td>
		<input type="radio" title="Is Joining Bonus to be recovered ? Amount:Rs.30000: yes" name="q3" id="q3_yes" value="yes">
		<label for="q3_yes">Yes</label>
		<input type="radio" title="Is Joining Bonus to be recovered ? Amount:Rs.30000: no" name="q3" id="q3_no" value="no">
		<label for="q3_no">No</label>
		<input type="radio" title="Is Joining Bonus to be recovered ? Amount:Rs.30000: NA" name="q3" id="q3_na" value="na">
		<label for="q3_na">NA</label>
		</td>
	</tr>
	<tr>
		<td>5) Is Relocation Allowance to be recovered ? Amount: Rs.0</td>
		<td>
		<input type="radio" title="Is Relocation Allowance to be recovered ? Amount: Rs.0: yes" name="q4" id="q4_yes" value="yes">
		<label for="q4_yes">Yes</label>
		<input type="radio" title="Is Relocation Allowance to be recovered ? Amount: Rs.0: no" name="q4" id="q4_no" value="no">
		<label for="q4_no">No</label>
		<input type="radio" title="Is Relocation Allowance to be recovered ? Amount: Rs.0: NA" name="q4" id="q4_na" value="na">
		<label for="q4_na">NA</label>
		</td>
	</tr>
	<tr>
		<td>6) Is NP Buyout to be recovered? Amount: Rs.0</td>
		<td>
		<input type="radio" title="Is NP Buyout to be recovered? Amount: Rs.0: yes" name="q5" id="q5_yes" value="yes">
		<label for="q5_yes">Yes</label>
		<input type="radio" title="Is NP Buyout to be recovered? Amount: Rs.0: no" name="q5" id="q5_no" value="no">
		<label for="q5_no">No</label>
		<input type="radio" title="Is NP Buyout to be recovered? Amount: Rs.0: NA" name="q5" id="q5_na" value="na">
		<label for="q5_na">NA</label>
		</td>
	</tr>
	<tr>
		<td>7) Is Referral Bonus to be recovered?</td>
		<td>
		<input type="radio" title="Is Referral Bonus to be recovered?: yes" name="q6" id="q6_yes" value="yes">
		<label for="q6_yes">Yes</label>
		<input type="radio" title="Is Referral Bonus to be recovered?: no" name="q6" id="q6_no" value="no">
		<label for="q6_no">No</label>
		<input type="radio" title="Is Referral Bonus to be recovered?: NA" name="q6" id="q6_na" value="na">
		<label for="q6_na">NA</label>
		</td>
	</tr>
	<tr>
		<td>8) Do you want to waive off the notice-period?(time) </td>
		<td>
		<input type="radio" title="Do you want to waive off the notice-period?(time) : yes" name="q7" id="q7_yes" value="yes">
		<label for="q7_yes">Yes</label> 
		<input type="radio" title="Do you want to waive off the notice-period?(time) : no" name="q7" id="q7_no" value="no">
		<label for="q7_no">No</label>
		<input type="radio" title="Do you want to waive off the notice-period?(time) : NA" name="q7" id="q7_na" value="na">
		<label for="q7_na">NA</label>
		</td>
	</tr>
	<tr>
		<td>9) Is NP shortfall amount to be recovered from employee? </td>
		<td>
		<input type="radio" title="Is NP shortfall amount to be recovered from employee? : yes" name="q8" id="q8_yes" value="yes">
		<label for="q8_yes">Yes</label> 
		<input type="radio" title="Is NP shortfall amount to be recovered from employee? : no" name="q8" id="q8_no" value="no">
		<label for="q8_no">No</label>
		<input type="radio" title="Is NP shortfall amount to be recovered from employee? : NA" name="q8" id="q8_na" value="na">
		<label for="q8_na">NA</label>
		</td>
	</tr>
</table>	
	</div>
	</br> 
				
	<button type="submit" value="Generate">Generate PDF</button>		

					
				
				
				</div>
				<div id="ajaxResponse"></div>
				<p class="error" style="font-size: 14px; color: red;">${message}</p>

				<div class="cleaner">&nbsp;</div>
			</div>
			<%@ include file="footer.jsp"%>
			</div>
		</div></body>
</html>