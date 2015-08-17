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