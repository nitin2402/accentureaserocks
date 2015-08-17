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
