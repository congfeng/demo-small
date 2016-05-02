$(function(){
	$.ajax({
		type: 'POST',
		dataType: 'json',
		url: '/profile/login',
		data: {username:'admin',password:'admin'},
		success: function(data){
			console.log(data);
		}
	});
	$.ajax({
		type: 'POST',
		dataType: 'json',
		url: '/profile/info',
		success: function(data){
			console.log(data);
			$('#portrait').attr('src',data.userPortrait);
		}
	});
})
