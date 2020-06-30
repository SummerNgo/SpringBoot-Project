$(document).ready(function(){

	   var v = $('#approveflag').text() ;
	   alert(v);
	   if(v == 1){
		   $("#approvedSuccessful").modal();
	   }
	
});