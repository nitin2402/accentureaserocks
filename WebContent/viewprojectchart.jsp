<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Chart</title>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	

<link rel="stylesheet" type="text/css" href="style.css">
<script>
	$(document).ready(function()
			{
		
	$("#clickk").hide();

		$('li.teamclick').on('click', function() {
			var team = $(this).text();
			$("#piechart").hide();
			
			$.ajax({
				url : "/EmployeeMSAccessDB/FetchTeamEmployees",
				type : "POST",
				data : 'teamName=' + team,

				success : function(data) {
					$("#ajaxResponse").html(data);
					$("#clickk").show();

				},
				error : function() {

				}
			});

		});
			});

	</script>
	
	
	
<script  src="https://www.google.com/jsapi"></script>
	<script>
	google.setOnLoadCallback(initialize);
	google.load("visualization", "1", {packages:["corechart"]});
	function drawChart() {
		
		var ASE = document.getElementById("hi").rows[0].cells[1].innerHTML;
		var SE = document.getElementById("hi").rows[1].cells[1].innerHTML;
		var SSE = document.getElementById("hi").rows[2].cells[1].innerHTML;
		
	var nASE =parseInt(ASE);
	var nSE = parseInt(SE);
	var nSSE = parseInt(SSE);
	
	    var data = google.visualization.arrayToDataTable([
	        ['Designation', 'number'],
	        ['ASE',    nASE],
	        ['SE',    nSE],
	        ['SSE',  nSSE]
	    ]);

	    var options = {
	        title: ''
	    };

	    var chart = new google.visualization.PieChart(document.getElementById('piechart'));
	    chart.draw(data, options);
	}
	function initialize () {
	    $("#clickk").click(function() {
	    	$("#piechart").show();
	        drawChart();
	    });
	}

	         </script>




</head>
<body>
<%

HttpSession session1 = request.getSession(false);
if (session1 == null || (String)session1.getAttribute("user") == null){
    %><jsp:forward page="home.jsp?msg=Please Login" /><%
}
%>
	<%-- <jsp:include page="style.css"/> --%>

	<div id="test"></div>


	<div class="tree">
		<table >
			<tr>
				<td>${html1}</td>
			</tr>
			
			<tr>
				<td><p
						style="color: #666; font-family: arial, verdana, tahoma; font-size: 11px; ">Click
						a team's name to view Employee count</p></td>
			</tr>
			<tr>
			<td >
				
				</td >
			</tr>
		</table>

	</div>

	<div id="ajaxResponse"></div><br/><br/><br/>
	<a href="#"  id="clickk" >Team Statistics</a>
	 <div id="piechart"></div>  


</body>
</html>