
/*	$(function() {
		$('.last').click(
				function(event) {
					var email = 'chinu.mohanty@accenture.com';
					var subject = 'Feedback';
					var emailBody = 'Hi Chinu,';
					window.location = 'mailto:' + email + '?subject=' + subject
							+ '&body=' + emailBody;
				});
	}); */
	function validateform() {
		//var pat =  /^[a-z]+$/;
		
		//var numbers = /^[0-9]+$/; 
		var id = document.forms["registration"]["employeeid"].value;
		var username = document.forms["registration"]["newuser"].value;
		var password = document.forms["registration"]["password"].value;
		var cpassword = document.forms["registration"]["cpassword"].value;

		if (id == null || id == "") {
			alert("Please provide Employee ID");
			return false;
		}

		//if(!id.match(numbers)) 
			//{	alert('Please input numeric characters only'); 
              //  return false; 

				//}

			
		
		if (username == null || username == "") {
			alert("Please provide username");
			return false;
		}
		
		if (password == null || password == "") {
			alert("Please provide Password");
			return false;
		}
		if (password.length < 6) {
			alert("password should contain atleast 6 digits");
			return false;
		}
		/* var filter3 = /^[a-zA-Z0-9!@#$%^&*]{6,16}$/;
	    if (filter3.test(password)) {
	       
	    }
	    else {
	    	alert("password should contain one number and one special character ");
	        return false;
	    } */
		if (cpassword == null || cpassword == "") {
			alert("Please confirm Password");
			return false;
		}
		if (password != cpassword) {
			alert("Password mismatch");
			return false;
		}
		
		
		
		
		 
	}
