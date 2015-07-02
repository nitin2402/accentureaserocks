function validateformteam() {

	if ( ( !document.getElementById('excel1').checked  ) && ( !document.getElementById('manually1').checked  ) ) 
	{
	 alert ( "Please choose one option" );
	 return false;
	}
}