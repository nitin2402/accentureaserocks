$(document).ready(function(){

        $("#modCss").css({
           
            	"font-weight": "bold",
            	"text-decoration": "underline"
        });
    });
var validFileExtensions = [".xlsx"];    
function Validate(vaildateObj) {
    var getFileName = vaildateObj.getElementsByTagName("input");
  

	    for (var i = 0; i < getFileName.length; i++) {
	var fileInput = getFileName[i];
	if (fileInput.type == "file")
		var fileName = fileInput.value;
	{
		if (fileName == "" || fileName == null || fileName == 0)

		{
			alert("please select a excel file to upload");
			return false;
		} else {

			if (fileName.length > 0) {
				var isValid = false;
				for (var j = 0; j < validFileExtensions.length; j++) {
					var extensions = validFileExtensions[j];
					if (fileName.substr(
							fileName.length - extensions.length,
							extensions.length).toLowerCase() == extensions
							.toLowerCase()) {
						isValid = true;
						alert("PLEASE ENSURE THAT THE PROJECT names are correct.YOU MAY REFER TO SHEET 2 OF THE ABOVE LINK.");
						// return SelectSheetNo();
						return true;
					}
				}
				if (!isValid) {
					alert("Sorry " + fileName
							+ " is invalid, allowed extensions are: "
							+ validFileExtensions.join(", "));
					return false;
				}

			}

		}

	}
}

}