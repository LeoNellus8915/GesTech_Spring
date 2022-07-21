function tutteLeRisorse()
{
	var arrayRow = [];
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/tutte-le-risorse",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(dati) {
			for (var c=0; c<dati.length; c++){
				var b1 = '<a href="visualizza-candidati?idRisorsa='+dati[c].at(0)+'" onclick="setStorage('+dati[c].at(0)+')"><i class="icon-eye mr-3"></i></a>';
				var b2 = '<a href="modifica-candidati?idRisorsa='+dati[c].at(0)+'" onclick="setStorage('+dati[c].at(0)+')"><i class="icon-pencil"></i></a>';
				arrayRow.push([dati[c].at(1), dati[c].at(2), dati[c].at(3), dati[c].at(4), dati[c].at(5), b1 + b2]);
				/*
				dati[0] -> id
				dati[1] -> Data e Ora
				dati[2] -> Nome e Cognome
				dati[3] -> Città
				dati[4] -> Ruolo
				dati[5] -> SkillPrincipale
				*/
			}
			$('#tabellaRicerca').DataTable({
				data: arrayRow,
				language: {
            		"lengthMenu": "Schermo _MENU_ record per pagina",
            		"zeroRecords": "Nessun riscontro",
            		"info": "Visualizzazione della pagine _PAGE_ di _PAGES_",
            		"infoEmpty": "Nessun riscontro disponibile",
            		"infoFiltered": "(filtered from _MAX_ total records)",
            		"paginate":
            		{
						"previous": "Precedente",
						"next": "Prossima"
					},
            		"search": "Cerca"
				}
			});	      			
		},
	});
}

