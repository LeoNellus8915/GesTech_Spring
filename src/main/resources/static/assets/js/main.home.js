function controllo_caratteri(idInput){
	
	var text = $(idInput).val();

	if(text.match(/(%|&)/)){
		$('#label-error-text').css('display', 'block');
	} 
	else {
		$('#label-error-text').css('display', 'none');
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
				
				$('<div/>',{
				    class: 'col-4 card_avvisi',
				    id: "div_avvisi" + c,
				}).appendTo('#stampaAvvisi');
			
				$('<span/>',{
					value: dati[c].data,
				    class: 'data_ora_avvisi',
				    text: dati[c].data,
				}).appendTo('#div_avvisi' + c);
				
				$('<a>',{
					href: 'cancella-avviso?idAvviso='+dati[c].id,
					id: dati[c].id,
				}).appendTo('#div_avvisi' + c);
				$('#div_avvisi' + c).append('<i class="icon icon-delete red-text s-18"></i>');
				$('#div_avvisi' + c).append('</a>');
				
				$('<p/>',{
					value: dati[c].titolo,
				    class: 'titolo_avvisi',
				    text: dati[c].titolo,
				}).appendTo('#div_avvisi' + c);
				
				$('<p/>',{
					value: dati[c].note,
				    class: 'testo_avvisi',
				    text: dati[c].note,
				}).appendTo('#div_avvisi' + c);
				
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
				
				$('<span/>',{
					value: split_finale,
				    class: 'ruolo_avvisi',
				    text: split_finale,
				}).appendTo('#div_avvisi' + c);
			}
		},
	});
}

function controlloCheckbox()
{
	var contatore = 0;
	$("#form").one("submit", function (e) {
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
			alert("Selezionare almeno una checkbox");
			e.preventDefault();
		}
    });
}