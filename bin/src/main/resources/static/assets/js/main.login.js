$(document).ready(function() {

	$("#fm-login").submit(function(e) {
		var passwordMD5 = $.MD5($("#password").val());
		$("#fm-login").append(
			$('<input>', { type: 'hidden', id: 'passwordMD5', name: 'passwordMD5', value: passwordMD5 })
		);
		$("#password").val($("#password").attr("placeholder"));
	});
});