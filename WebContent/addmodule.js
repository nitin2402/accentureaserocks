function validateform1() {

		var moduleid = document.forms["add"]["module_id"].value;
		var modulename = document.forms["add"]["module_name"].value;
		var moduledesc = document.forms["add"]["module_desc"].value;
		

		if (moduleid == null || moduleid == "") {
			alert("Please provide MODULE ID");
			return false;
		}
		if (modulename == null || modulename == "") {
			alert("Please provide MODULE NAME");
			return false;
			}
			
			if (moduledesc == null || moduledesc == "") {
				alert("Please provide MODULE DESCRIPTION");
				return false;
		}
	}

