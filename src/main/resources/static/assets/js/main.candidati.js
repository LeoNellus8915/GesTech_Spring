function tutteLeRisorse()
{
	var arrayRow = [];
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/tutte-le-risorse",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(dati) {
			console.log(dati);
			for (var c=0; c<dati.length; c++){
				var b1 = '<a href="visualizza-candidato?idRisorsa='+dati[c].at(0)+'"><i class="icon-eye mr-3"></i></a>';
				var b2 = '<a href="modifica-candidato?idRisorsa='+dati[c].at(0)+'"><i class="icon-pencil"></i></a>';
				arrayRow.push([dati[c].at(1), dati[c].at(2), dati[c].at(3), dati[c].at(4), dati[c].at(5), dati[c].at(6), b1 + b2]);
				/*
				dati[0] -> id
				dati[1] -> Data e Ora
				dati[2] -> Nome e Cognome
				dati[3] -> Città
				dati[4] -> Ruolo
				dati[5] -> Skill Principale
				dati[6] -> Esito Colloquio
				*/
			}
			$('#tabellaRicerca thead tr')
        	.clone(true)
        	.addClass('filters')
        	.appendTo('#tabellaRicerca thead');
			$('#tabellaRicerca').DataTable({				
				data: arrayRow,
				createdRow: function(row, dati) 				
				{
					console.log(dati);
				    if (dati[5] == 'Inaffidabile')
				        $(row).css('background-color', '#f08080');
				},
				orderCellsTop: true,
        		fixedHeader: true,
        		initComplete: function () {
           		var api = this.api();
           		api
                .columns()
                .eq(0)
                .each(function (colIdx) {
                    // Set the header cell to contain the input element
                    
                    var cell = $('.filters th').eq(
                        $(api.column(colIdx).header()).index()
                    );
                    var title = $(cell).text();
                   if(colIdx != 6) {  // Controlla l'id della colonna per non creare l'input type AZIONI
					 $(cell).html('<input type="text" placeholder="' + title + '" />');
					} else {
						$(cell).text("");  // Per non duplicare il th AZIONI
					}
                   
                    // On every keypress in this input
                    $(
                        'input',
                        $('.filters th').eq($(api.column(colIdx).header()).index())
                    )
                        .off('keyup change')
                        .on('change', function (e) {
                            // Get the search value
                            $(this).attr('title', $(this).val());
                            var regexr = '({search})'; //$(this).parents('th').find('select').val();
 
                            var cursorPosition = this.selectionStart;
                            // Search the column for that value
                            api
                                .column(colIdx)
                                .search(
                                    this.value != ''
                                        ? regexr.replace('{search}', '(((' + this.value + ')))')
                                        : '',
                                    this.value != '',
                                    this.value == ''
                                )
                                .draw();
                        })
                        .on('keyup', function (e) {
                            e.stopPropagation();
 
                            $(this).trigger('change');
                            $(this)
                                .focus()[0]
                                .setSelectionRange(cursorPosition, cursorPosition);
                        });
                });
        },
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

function stampaCommenti(){
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/stampa-commenti?idRisorsa="+$("#id").val(),
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(dati){
			for (var c = 0; c < dati.length; c++)
			{
				$('<span/>',{
					value: dati[c].at(0) + dati[c].at(1),
				    class: 'data_nomecognome_commenti',
				    text: dati[c].at(0) + "   " + dati[c].at(1),
				}).appendTo('#commento');
				$('<p/>',{
					value: dati[c].at(2),
				    class: 'testo_commenti',
				    text: dati[c].at(2),
				}).appendTo('#commento');
			}
		}
	})
}



