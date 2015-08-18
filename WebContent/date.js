$(document).ready(function() {
    $("#calendar").datepicker({
    	yearRange: '2000:2030',
    	changeMonth: true,
    	changeYear: true
    });
    $("#calendar1").datepicker({
    	yearRange: '2000:2030',
        changeMonth: true,
        changeYear: true
        });
    $( ".datepicker" ).each(function(){
        $(this).datepicker({
        	yearRange: '2000:2030',
            changeMonth: true,
            changeYear: true
        });
    })
    $("button").click(function() {
        var calendar = $("#calendar").val();
        var calendar1 = $("#calendar1").val();
        var calendar2 = $(".datepicker").val();
        
    });
});

