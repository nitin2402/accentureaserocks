	$(document).ready(function() {
		$("#div2,#div1").hide();
		  $( "#accordion" ).accordion();
	});

	
	 
	 $(function(){$("#mdl").chained("#prj");
		$("#tem").chained("#mdl")});
	 
	function changeTextBox() {
		var val = $('#select').val();

		if (val === 'default') {
			$("#div2,#div1").hide();
			
		}

		else if (val === 'employee') {
			$("#div2").hide();
			$("#div1").show();
		}

		else if (val === 'designation') {
			$("#div2").show();
			$("#div1").hide();
		}
	}
	function validateform(){
		var status = document.forms["request"]["status"].value;
		var startdate = document.forms["request"]["startdate"].value;
		var enddate = document.forms["request"]["enddate"].value;
		if((status == null || status =="")&& (startdate == null|| startdate == "")&& (enddate == null || enddate == "")){
			alert("Fields cannot be empty");
			return false;
		}
		if ((Date.parse(startdate) > Date.parse(enddate))) {
	        alert("End date should be greater than Start date");
	        return false;
	    }
	}
