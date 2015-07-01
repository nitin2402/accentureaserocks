$(document).ready(function() {
    $("#calendar").datepicker();
    $("#calendar1").datepicker();
    $("button").click(function() {
        var calendar = $("#calendar").val();
        var calendar1 = $("#calendar1").val();
    });
});