



	$(function() {
		$('.last').click(
				function(event) {
					var email = 'chinu.mohanty@accenture.com';
					var subject = 'Feedback';
					var emailBody = 'Hi Chinu,';
					window.location = 'mailto:' + email + '?subject=' + subject
							+ '&body=' + emailBody;
				})
	});



	function validateform() {

		var name = document.forms["login"]["USERNAME"].value;
		var password = document.forms["login"]["PASSWORD"].value;

		if (name == null || name == "") {
			alert("Please provide UserName");
			return false;
		}
		if (password == null || password == "") {
			alert("Please provide Password");
			return false;
		}
	}
