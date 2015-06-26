


	$(document).ready(function() {
		$(".header_09").hide();
	});



 
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

	function validateform2() {

	if ( ( !document.getElementById('excel').checked ) && ( !document.getElementById('manually').checked ) ) 

	{

	alert ( "Please choose one option" );

	return false;

	}

	}

