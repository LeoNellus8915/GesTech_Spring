function controllo_caratteri(idInput){
	
	var text = $(idInput).val();

	if(text.match(/(%|&)/)){
		$('#label-error-text').css('display', 'block');
	} 
	else {
		$('#label-error-text').css('display', 'none');
	}
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
    })
}