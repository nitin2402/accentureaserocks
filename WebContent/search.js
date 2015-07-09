
	$(document).ready(
			function(e) {

				$('#search_field').keyup(
						function(event) {
							var searchvalue = $("#search_field").val();
							$(".error").hide();
							$.ajax({
								url : "/TMT/SearchEmployee",
								type : "POST",
								data : 'searchName=' + searchvalue,

								success : function(data) {

									$(".header_01").hide();
									$(".header_09").show();
									$(".header_09").text(
											'Search results for \"'
													+ searchvalue + '\"');
							if (data != "") {
										$("#search").hide();
										 $("#ajaxResponse").show();
										$("#ajaxResponse").html(data); 
									} else {

										 $("#ajaxResponse").hide(); 

										$("#search").show().delay(1000);
										$(".header_09").hide();
										$(".header_01").show();

									} 

								},
								error : function() {

								}
							});

						});
			});
