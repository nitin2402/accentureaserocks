
	$(document).ready(
			function(e) {

				$('#search_field').keyup(
						function(event) {
							var searchvalue = $("#search_field").val();
							$(".error").hide();
							$.ajax({
								url : "/TMT/SearchEmployeeAdmin",
								type : "POST",
								data : 'searchName=' + searchvalue,

								success : function(data) {

									$(".header_01").hide();
									$(".header_09").show();
									$(".header_09").text(
											'Search results for \"'
													+ searchvalue + '\"');
							if (data != "") {
								count=4;
								if(data=="Please Login"){
									alert("Session Expired..Please Login");
									window.location = "login.jsp";
								}else{
									$("#search").hide();
									 $("#ajaxResponse").show();
									$("#ajaxResponse").html(data); 
								}
									} else {

										 $("#ajaxResponse").hide(); 

											$("#search").show();
											count=0;
											$(".header_09").hide();
											$(".header_01").show();


									} 

								},
								error : function() {

								}
							});

						});
			});
