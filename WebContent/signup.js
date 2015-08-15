

	function validateform() {
		var id = document.forms["registration"]["employeeid"].value;
		var username = document.forms["registration"]["newuser"].value;
		var password = document.forms["registration"]["password"].value;
		var cpassword = document.forms["registration"]["cpassword"].value;

		if (id == null || id == "") {
			alert("Please provide Employee ID");
			return false;
		}
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
		if (cpassword == null || cpassword == "") {
			alert("Please confirm Password");
			return false;
		}
		if (password != cpassword) {
			alert("Password mismatch");
			return false;
		} 
	}
