//accordion	
$(document).ready(function() {
		$("#div2,#div1").hide();
		  $( "#accordion" ).accordion();
	});

$(document).ready(function() {
	$("#div2,#div1").hide();
	  $( "#accordion" ).accordion();
});
	 
	//drop down
	 
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
	

	
	 //chained drop down project-module-team
	 $(function(){$("#mdl").chained("#prj");
		$("#tem").chained("#mdl")});
	 
	//calendar
	function validateform()
	{
	
	
	var from = $("#calendar,#calendar2,#calendar4,#calendar6,#calendar8").val(); 
	var to = $("#calendar1,#calendar3,#calendar5,#calendar7,#calendar9").val();


	if(Date.parse(from) > Date.parse(to)){
	   alert("Last Date Of Working must be after Date Of Joining");
	   return false;
	}
	}
