
$(document).ready(function(){

        $("#modCss").css({
           
            	"font-weight": "bold",
            	"text-decoration": "underline"
        });
    });

	$(document).ready(function() {
		$(".header_09").hide();
	});




function validateform2() {

	if ( ( !document.getElementById('excel').checked  ) && ( !document.getElementById('manually').checked  ) ) 
	{
	 alert ( "Please choose one option" );
	 return false;
	}
}



