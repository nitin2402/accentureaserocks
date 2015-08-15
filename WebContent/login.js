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
