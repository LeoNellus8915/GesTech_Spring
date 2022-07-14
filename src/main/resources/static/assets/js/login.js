function login() {
	var params = {
		"email": $("#email").val(),
		"password": $("#password").val()
	}


	$.ajax({
		type: "POST",
		url: 'login',
		data: params,
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(respose) {
			console.log(respose)
		}
	});


	/*var xhttp = new XMLHttpRequest();
	
	xhttp.open("POST", 'login', true);
	xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xhttp.send(JSON.stringify(params));
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var login = xhttp.responseText;
			var dati = login.split(",");
			if (dati[0] == 1)
				window.open("home.jsp", "_self");
			else
				alert("Credenziali Sbagliate");
			localStorage.setItem("nome_utente", dati[1]);
		}
	}*/
}