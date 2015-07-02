<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Talent Management Tool</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="searchrequest.js"></script> 

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

<script src="https://www.google.com/jsapi"></script>
<script>
	$("#ajaxResponse").hide();
	$("#header_02").hide();
	google.setOnLoadCallback(initialize);
	google.load("visualization", "1", {
		packages : [ "corechart" ]
	});
	function myfunction() {

		var myFunctionObj = new Object();

		var count = 0;
		var data = [];
		var options = [];

		var nASE = 10;
		var nSE = 7;
		var nSSE = 5;

		/* var nASE =parseInt(ASE);
		 var nSE = parseInt(SE);
		 var nSSE = parseInt(SSE); */
		var nTL = 3;
		var nAM = 2;
		var nM = 1;

		var rASE = 310;
		var rSE = 30;
		var rSSE = 30;

		/* var nASE =parseInt(ASE);
		 var nSE = parseInt(SE);
		 var nSSE = parseInt(SSE); */
		var rTL = 13;
		var rAM = 02;
		var rM = 1;

		var pASE = 110;
		var pSE = 17;
		var pSSE = 15;

		/* var nASE =parseInt(ASE);
		 var nSE = parseInt(SE);
		 var nSSE = parseInt(SSE); */
		var pTL = 13;
		var pAM = 12;
		var pM = 11;

		data[0] = google.visualization.arrayToDataTable([
				[ 'Designation', 'number' ], [ 'ASE', nASE ], [ 'SE', nSE ],
				[ 'SSE', nSSE ], [ 'TL', nTL ], [ 'AM', nAM ], [ 'M', nM ] ]);

		data[1] = google.visualization.arrayToDataTable([
				[ 'Designation', 'number' ], [ 'ASE', rASE ], [ 'SE', rSE ],
				[ 'SSE', rSSE ], [ 'TL', rTL ], [ 'AM', rAM ], [ 'M', rM ] ]);

		data[2] = google.visualization.arrayToDataTable([
				[ 'Designation', 'number' ], [ 'ASE', pASE ], [ 'SE', pSE ],
				[ 'SSE', pSSE ], [ 'TL', pTL ], [ 'AM', pAM ], [ 'M', pM ] ]);

		options[0] = {
			is3D : true,
			backgroundColor : '#647a2f',
			title : 'E-Strategy',
			chartArea : {
				left : 100,
				top : 50
			}
		};
		options[1] = {
			is3D : true,
			backgroundColor : '#647a2f',
			title : 'R3',
			chartArea : {
				left : 100,
				top : 50
			}
		};
		options[2] = {
			is3D : true,
			backgroundColor : '#647a2f',
			title : 'Primier',
			chartArea : {
				left : 100,
				top : 50
			}
		};
		var chart = new google.visualization.PieChart(document
				.getElementById('piechart'));

		var change = setInterval(next, 3000);
		function stop() {
			clearInterval(change);
		}
		function next() {
			if (count == 3)
				count = 0;

			var chart = new google.visualization.PieChart(document
					.getElementById('piechart'));
			chart.draw(data[count], options[count]);
			count++;
		}

		myFunctionObj.next = next;
		myFunctionObj.stop = stop;

	}

	function initialize() {

		myfunction();
		/*  	
		setInterval(next, 3000); */

	}

	Multi = new myfunction();

	function clickToStop() {
		Multi.stop();
	}

	/*  function next()
	 {
		 alert(data[0]);
	 
		 if (count==2)
			
			{count=0;}
		
		 chart.draw(data[count],options);
	 } */
</script>

<script>
	function validate(form) {
		var regExp = /^[a-zA-Z]{1,100}$/;

		var msg1 = document.getElementById("msg1");

		msg1.innerHTML = "";

		if (!regExp.test(form.search_field.value)) {
			msg1.innerHTML = "Name should be in alpha !";
			return false;
		}

	}
</script>



<script>
	$(document).ready(
			function() {

				$('#search_field').keyup(
						function(event) {
							var searchvalue = $("#search_field").val();
							$(".error").hide();
							$.ajax({
								url : "/EmployeeMSAccessDB/SearchEmployee",
								type : "POST",
								data : 'searchName=' + searchvalue,

								success : function(data) {

									$(".header_01").hide();
									$(".header_09").show();
									$(".header_09").text(
											'Search results for \"'
													+ searchvalue + '\"');
									if (data != "") {
										$("#piechart").hide();
										$("#ajaxResponse").show();
										$("#ajaxResponse").html(data);
									} else {

										$("#ajaxResponse").hide();

										$("#piechart").show().delay(1000);
										$(".header_09").hide();
										$(".header_01").show();

									}

								},
								error : function() {

								}
							});

						});
			});
</script>

</head>
<body>

<jsp:include page="/SearchRequestServlet" />


<%
		HttpSession session1 = request.getSession();
		if (session1 == null
				|| (String) session1.getAttribute("user") == null) {
	%><jsp:forward page="login.jsp?msg=Please Login " />
	<%
		}
	%> 
	
		<div id="templatemo_header">
			<div id="site_title_section">
				<div id="site_title">Talent Management Tool</div>
				<div id="slogan">The place to look back</div>
				<div class="cleaner">&nbsp;</div>
			</div>
			
			<div id="welcome_msg" style="color: yellow;float: right;
font-size: 12px;">Welcome ${user}&nbsp;<a href="logout.jsp">Logout</a></div>

			<div id="header_section_code">"Overall approach is to maintain
				pyramid form for all designation levels as per Accenture
				compliance."</div>
		</div>
		<!-- end of header -->
		<div id="templatemo_menu">
		<ul>
		  
			<li><a href="adminhome.jsp" class="current">Home</a></li>
			<li><a href="addempvia.jsp">Admin Tools</a></li>
			<li><a href="searchrequest.jsp">Workplan</a></li>
			<li><a href="#">Projects</a></li>
			<li><a href="#">About Us</a></li>
			  <!-- <li><a href="logout.jsp">Logout</a></li>  -->
			<li><a href="#" class="last">Contact Us</a></li>
		</ul>
	</div>
	<div id="templatemo_content">

		<div id="content_left">

			<div class="content_left_section">
				<div class="content_left_section_title">Search Employee</div>
				<div class="content_left_section_content">
					<form action="#">
						Name<input type="text" id="search_field" name="search_field" />
						<input
							type="submit" value="Search" id="search_button" /> 
						<div>
							<span id="msg1">${param.msg1}</span>
						</div>

					</form>
					<div class="cleaner">&nbsp;</div>
				</div>
				<div class="cleaner">&nbsp;</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

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

			<div class="right_col_section_w650" style="height: auto">

			
				<div class="header_01" >Status of user requests</div>
				<h2 style="color:white;">Unapproved Requests</h2>
				
				<form name="actionForm" action="ActionServlet" >
					<div id="scrollable"   style="font-size: 14px;">
						
						
						<table class="table1" > 
							<thead style="font-weight:bold;position: ">
							<tr style="font-weight:bold;">
								<td>Select</td>
								<td>ReqId</td>
								<td>Team Name</td>
								<td>No_Of_ASE</td>
								<td>No_of_SE</td>
								<td>No_of_SSE</td>
								<td>comment</td>
								<td>Status</td>
							</tr>
							</thead>
						
							<tbody  >
							
							<jstlcore:forEach items="${unapproved_requests}" var="item">
								<tr>
									<td><input type="radio" name="select" value="${item.reqId}"/></td>
									<td><jstlcore:out value="${item.reqId}" /></td>
									<td><jstlcore:out value="${item.teamName}" /></td>
									<td><jstlcore:out value="${item.nASE}" /></td>
									<td><jstlcore:out value="${item.nSE}" /></td>
									<td><jstlcore:out value="${item.nSSE}" /></td>
									<td><jstlcore:out value="${item.comment}" /></td>
									<td><jstlcore:out value="${item.statusName}" /></td> 
								</tr>
							</jstlcore:forEach></tbody></table>
							</div>
						
						*Reason<textarea rows="3" cols="25" id="reason" name="reason"></textarea>
						
							<input type="submit"  name="action" value="Calculate" onclick="return validateForm()"/>
							<input type="submit" name="action" value="Accept" onclick="return validateButtonAccepted()"/>
							<input type="submit" name="action" value="Reject" onclick="return validateButtonRejected()"/>
							<input type="submit" name="action" value="OnHold" onclick="return validateButtonOnHold()"/>
							
							</form>
							
							
							<h2 style="color:white;">Approved Requests</h2>
							
					<div id="scrollable"   style="font-size: 14px;">
							<table class="table1" > 
						
							<thead style="font-weight:bold;position: ">
							<tr style="font-weight:bold;">
								<td>ReqId</td>
								<td>Team Name</td>
								<td>No_Of_ASE</td>
								<td>No_of_SE</td>
								<td>No_of_SSE</td>
								<td>comment</td>
								<td>Status</td>
							</tr>
							</thead>
						
							<tbody  >
							
							
							<jstlcore:forEach items="${approved_requests}" var="item">
								<tr>
									
									
									<td><jstlcore:out value="${item.reqId}" /></td>
									<td><jstlcore:out value="${item.teamName}" /></td>
									<td><jstlcore:out value="${item.nASE}" /></td>
									<td><jstlcore:out value="${item.nSE}" /></td>
									<td><jstlcore:out value="${item.nSSE}" /></td>
									<td><jstlcore:out value="${item.comment}" /></td>
									<td><jstlcore:out value="${item.statusName}" /></td> 
								</tr>
							</jstlcore:forEach></tbody></table>
							
			
</div>
					
<br></br>

					<div style="font-size: 14px;">
		<%-- <table>
			<tr>
				<td>PROJECT:</td>
				<td><select name="project" id="project"><jstlcore:forEach
							var="aff" items="${project}">

							<option value="${aff}">${aff}</option>
						</jstlcore:forEach></select>]</td>
			</tr>
		</table>
		 --%>
					</div>
<br/><br/>
<div style="color: red;font-size: 12px">${message}</div>

					<div class="cleaner">&nbsp;</div>
				</div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>
		
		
		</div>

</body>
</html>