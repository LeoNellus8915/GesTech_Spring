$(function() {
    $( "p" ).text( "The DOM is now loaded and can be manipulated." );
  });

function controllo_caratteri(id_input){
	var text = document.getElementById(id_input).value;

	if(text.match(/(%|&)/)){
		document.getElementById("label-error-text").style.display = "block";
	} 
	else {
		document.getElementById("label-error-text").style.display = "none";
	}
	
}

function stampaAvvisi()
{
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/stampa-avvisi",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(dati){
			for (var c = 0; c < dati.length; c++)
			{
				var split_finale = "";
				
				const div = document.createElement("div");
				div.classList.add('col-4', 'card_avvisi');
				div.id = "div_avvisi" + c;
				//document.getElementById("stampaAvvisi").appendChild(div);
				$("#stampaAvvisi").append(div);
			
				const dataOra = document.createElement("span");
				dataOra.value = dati[c].data;
				dataOra.innerHTML = dati[c].data;
				dataOra.classList.add('data_ora_avvisi');
				document.getElementById('div_avvisi' + c).appendChild(dataOra);
				
				const icona = document.createElement("i");
				icona.innerHTML = '<a href="cancella-avviso?idAvviso='+dati[c].id+'"><i class="icon icon-delete red-text s-18"></i>';
				document.getElementById('div_avvisi' + c).appendChild(icona);
				
				const titolo = document.createElement("p");
				titolo.value = dati[c].titolo;
				titolo.innerHTML = dati[c].titolo;
				titolo.classList.add('titolo_avvisi');
				document.getElementById('div_avvisi' + c).appendChild(titolo);
				
				const avviso = document.createElement("p");
				avviso.value = dati[c].note;
				avviso.innerHTML = dati[c].note;
				avviso.classList.add('testo_avvisi');
				document.getElementById('div_avvisi' + c).appendChild(avviso);
				
				var split = dati[c].ruoli.split(",")
				if(split.length != 1)
				{
					split_finale = split[0].substring(1) + split[split.length-1].slice(0, -1);
				}
				else
				{
					split_finale = split[0].substring(1);
					split_finale = split_finale.slice(0, -1);
				}
				const ruolo = document.createElement("span");
				ruolo.value = split_finale;
				ruolo.innerHTML = split_finale;
				ruolo.classList.add('ruolo_avvisi');
				document.getElementById('div_avvisi' + c).appendChild(ruolo);
			}
		},
	});
}

function controlloCheckbox()
{
	var contatore = 0;
	$("#form").on("submit", function (e) {
		if ($("#admin").prop('checked'))
			contatore++;
		if ($("#recruiter").prop('checked'))
			contatore++;
		if ($("#commerciale").prop('checked'))
			contatore++;
		if ($("#dipendente").prop('checked'))
			contatore++;
		if ($("#tutti").prop('checked'))
			contatore++;
			
		if (contatore != 0)
			$("#form").submit();
		else
		{
			alert("Selezionare almeno una checkbox'");
			e.preventDefault();
		}
    });
}