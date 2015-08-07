function validateform(){
	/*var teamName = document.forms["teamreport"]["teamName"].value;
	var startDate = document.forms["teamreport"]["startDate"].value;
	var endDate = document.forms["teamreport"]["endDate"].value;
	if((teamName == null || teamName == "") && (startDate == null || startDate == "") && (endDate == null || endDate == "")){
		alert("Fields cannot be empty");
		return false;
	}
	*/
	if ((Date.parse(startDate) > Date.parse(endDate))) {
        alert("End date should be greater than Start date");
        return false;
    }
	
}