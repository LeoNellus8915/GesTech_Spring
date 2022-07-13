function login()
{
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var params = {
  	"email":email,
  	"password": password
	}
	var xhttp = new XMLHttpRequest();
	
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
	}
}