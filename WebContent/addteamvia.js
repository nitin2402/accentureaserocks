function validateformteam() {

	if ( ( !document.getElementById('excel1').checked  ) && ( !document.getElementById('manually1').checked  ) ) 
	{
	 alert ( "Please choose one option" );
	 return false;
	}
}

$(function(){$("#mdl").chained("#prj");
$("#tem").chained("#mdl")});


$(document).ready(function(){
    $("#teamCss").css({
           	"font-weight": "bold",
        	"text-decoration": "underline"
    });
});

function validateform()
{
var name=document.forms["add"]["tname"].value;
var id=document.forms["add"]["project"].value;
var level=document.forms["add"]["module"].value;
var designation=document.forms["add"]["desc"].value;
if (name == null || name=="")
  {
  alert("Please provide Team Name");
  return false;
  }
if (id == null || id=="")
  {
  alert("Please provide Team ID");
  return false;
  }
if (level == null || level=="")
  {
  alert("Please provide Module Name");s
  return false;
  }
if (designation == null || designation=="")
  {
  alert("Please provide Team Description");
  return false;
  }
}
