function validateform(){
	var moduleName = document.forms["modulereport"]["moduleName"].value;
	var startDate = document.forms["modulereport"]["startDate"].value;
	var endDate = document.forms["modulereport"]["endDate"].value;
	if((moduleName == null || moduleName =="")&& (startDate == null|| startDate == "")&& (endDate == null || endDate == "")){
		alert("Fields cannot be empty");
		return false;
	}
	
}