


	$(document).ready(function() {
		$(".header_09").hide();
	});



 

	function validateform2(e) {

	if ( ( !document.getElementById('excel').checked ) && ( !document.getElementById('manually').checked ) ) 

	{

	alert ( "Please choose one option" );

	return false;

	}

	}

