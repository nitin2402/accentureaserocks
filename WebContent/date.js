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
    $("button").click(function() {
        var calendar = $("#calendar").val();
        var calendar1 = $("#calendar1").val();
    });
});



/*$('#validateForm').validate({ 
    errorPlacement: $.datepicker.errorPlacement, 
    rules: { 
        validDefaultDatepicker: { 
            required: true, 
            dpDate: true 
        }, 
        validBeforeDatepicker: { 
            dpCompareDate: ['before', '#calandar'] 
        }, 
        validAfterDatepicker: { 
            dpCompareDate: {after: '#calandar1'} 
        }
    }, 
    messages: { 
         
        validAfterDatepicker: 'Please enter a date after the date of joining' 
    }});



$(form).validate({ 
    rules: { 
        startDate: { 
            required: true, 
            dpDate: true 
        } 
    }     
});*/

