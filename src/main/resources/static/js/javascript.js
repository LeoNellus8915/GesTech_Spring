function stopLoader() {
	
}
document.addEventListener("DOMContentLoaded", function(){
    document.getElementById("loader").style.display = "none";
});


function controllo_caratteri(id_input){
	var text = document.getElementById(id_input).value;

	if(text.match(/(%|&)/)){
		console.log("VALORI NON AMMESSI");
		document.getElementById("label-error-text").style.display = "block";
	} 
	else {
		document.getElementById("label-error-text").style.display = "none";
	}
	
}



function controlla()
{
	var e1 = document.getElementById("password").value;
	var e2 = document.getElementById("password2").value;
	if (e1 != e2) {
		alert('Le password non coincidono!');
	}
}
function bustepaga()
{
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", 'Servlet_Ricerca', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "lettura_mese/,");
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta = xhttp.responseText;
			date = risposta.split(", ");

			if (date[1] != "null")
				document.getElementById('Gennaio').style.color = "red";
			if (date[2] != "null")
				document.getElementById('Febbraio').style.color = "red";
			if (date[3] != "null")
				document.getElementById('Marzo').style.color = "red";
			if (date[4] != "null")
				document.getElementById('Aprile').style.color = "red";
			if (date[5] != "null")
				document.getElementById('Maggio').style.color = "red";
			if (date[6] != "null")
				document.getElementById('Giugno').style.color = "red";
			if (date[7] != "null")
				document.getElementById('Luglio').style.color = "red";
			if (date[8] != "null")
				document.getElementById('Agosto').style.color = "red";
			if (date[9] != "null")
				document.getElementById('Settembre').style.color = "red";
			if (date[10] != "null")
				document.getElementById('Ottobre').style.color = "red";
			if (date[11] != "null")
				document.getElementById('Novembre').style.color = "red";
			if (date[12] != "null")
				document.getElementById('Dicembre').style.color = "red";

			if (date[1] != "null")
				document.getElementById("1").innerHTML = date[1];
			if (date[2] != "null")
				document.getElementById("2").innerHTML = date[2];
			if (date[3] != "null")
				document.getElementById("3").innerHTML = date[3];
			if (date[4] != "null")
				document.getElementById("4").innerHTML = date[4];
			if (date[5] != "null")
				document.getElementById("5").innerHTML = date[5];
			if (date[6] != "null")
				document.getElementById("6").innerHTML = date[6];
			if (date[7] != "null")
				document.getElementById("7").innerHTML = date[7];
			if (date[8] != "null")
				document.getElementById("8").innerHTML = date[8];
			if (date[9] != "null")
				document.getElementById("9").innerHTML = date[9];
			if (date[10] != "null")
				document.getElementById("10").innerHTML = date[10];
			if (date[11] != "null")
				document.getElementById("11").innerHTML = date[11];
			if (date[12] != "null")
				document.getElementById("12").innerHTML = date[12];
		}
	}
}
async function invio(mese, pdf)
{
	var xhttp = new XMLHttpRequest();

	var mese_corrente = document.getElementById(mese);
	var colore = window.getComputedStyle(mese_corrente).color;

	if (colore != "rgb(255, 0, 0)")
	{
		var conferma = confirm("Stai scaricando il pdf del mese di " + mese + ". Verra segnato l'orario del download.");
		if (conferma == true)
		{
			document.getElementById(pdf).click();

			xhttp.open("POST", 'Servlet_Ricerca', true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send("Servlet=" + "scrittura_mese/," + mese);

			await sleep(1000);
			bustepaga();
		}
	}
	else
		document.getElementById(pdf).click();
}
function sleep(ms)
{
	return new Promise(resolve => setTimeout(resolve, ms));
}
function certificazione_unica()
{
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", 'Servlet_Ricerca', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "lettura_anno/,");
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta = xhttp.responseText;
			date = risposta.split(", ");

			if (date[1] != "null")
				document.getElementById('2019').style.color = "red";
			if (date[2] != "null")
				document.getElementById('2020').style.color = "red";
			if (date[3] != "null")
				document.getElementById('2021').style.color = "red";
			if (date[4] != "null")
				document.getElementById('2022').style.color = "red";

			if (date[1] != "null")
				document.getElementById("1").innerHTML = date[1];
			if (date[2] != "null")
				document.getElementById("2").innerHTML = date[2];
			if (date[3] != "null")
				document.getElementById("3").innerHTML = date[3];
			if (date[4] != "null")
				document.getElementById("4").innerHTML = date[4];
		}
	}
}
async function invio2(anno, pdf)
{
	var xhttp = new XMLHttpRequest();

	var anno_corrente = document.getElementById(anno);
	var colore = window.getComputedStyle(anno_corrente).color;

	if (colore != "rgb(255, 0, 0)")
	{
		var conferma = confirm("Stai scaricando il pdf dell'anno " + anno + ". Verra segnato l'orario del download.");
		if (conferma == true) {
			document.getElementById(pdf).click();

			xhttp.open("POST", 'Servlet_Ricerca', true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send("Servlet=" + "scrittura_anno/," + anno);
			await sleep(1000);
			certificazione_unica();
		}
	}
	else
		document.getElementById(pdf).click();
}
function add(div, controllo, bottone, remove)
{
	var dato = document.forms["profilo"][controllo].value;
	if ((document.getElementById(div).style.display == "none") && (dato != ""))
	{
		document.getElementById(div).removeAttribute('style');
		document.getElementById(remove).removeAttribute('style');
		if (document.getElementById(bottone) != null)
			document.getElementById(bottone).removeAttribute('style');
	}
}
function remove(input, div, piu, meno)
{
	document.getElementById(input).value = '';
	document.getElementById(div).style.display = 'none';
	document.getElementById(meno).style.display = 'none';
	if (document.getElementById(piu) != null)
		document.getElementById(piu).style.display = 'none';
}
function setStorage(id)
{
	localStorage.setItem("dato", id);
}

function ricerca()
{
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", 'Servlet', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "ricerca");

	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta = xhttp.responseText;
			profili = risposta.split(", ");
			profili.pop();
			profili.shift();
			var arrayRow = [];
			for (var c = 0; c < profili.length ; c++)
			{
				valori = profili[c].split("#");
				var b1 = '<a href="sola_lettura.jsp" id='+valori[0]+' onclick="setStorage('+valori[0]+')"><i class="icon-eye mr-3"></i></a>';
				var b2 = '<a href="stampa_profilo.jsp" id='+valori[0]+' onclick="setStorage('+valori[0]+')"><i class="icon-pencil"></i></a>';
				/*var a1 = document.createElement('a');
				a1.href = "sola_lettura.jsp";
				a1.id = valori[0];
				a1.onclick = function()
				{
					localStorage.setItem("dato", this.id);
				}
				var i1 = document.createElement('i');
				i1.className = "icon-eye mr-3";
				a1.appendChild(i1);
				
				var a2 = document.createElement('a');
				a2.href = "stampa_profilo.jsp";
				a2.id = valori[0];
				a2.onclick = function()
				{
					localStorage.setItem("dato", this.id);
				}
				var i2 = document.createElement('i');
				i2.className = "icon-pencil";
				a2.appendChild(i2);*/
				arrayRow.push([valori[1], valori[2], valori[3], valori[4], valori[5], b1 + b2, valori[6]]);
			}
			$('#tabella_ricerca thead tr')
        	.clone(true)
        	.addClass('filters')
        	.appendTo('#tabella_ricerca thead');
			$('#tabella_ricerca').DataTable({
				data: arrayRow,
				createdRow: function(row, valori)
				{
				    if (valori[6] == 'Inaffidabile')
				        $(row).addClass('rosso_tabella_ricerca');
				},
				
				orderCellsTop: true,
        		fixedHeader: true,
        		initComplete: function () {
           		var api = this.api();
 
           		// For each column
            	api
                .columns()
                .eq(0)
                .each(function (colIdx) {
                    // Set the header cell to contain the input element
                    
                    var cell = $('.filters th').eq(
                        $(api.column(colIdx).header()).index()
                    );
                    var title = $(cell).text();
                   if(colIdx != 5) {  // Controlla l'id della colonna per non creare l'input type AZIONI
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
		}
	}
}


/*function ricerca()
{
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", 'Servlet', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "ricerca");

	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta = xhttp.responseText;
			profili = risposta.split(", ");
			for (var c = 1; c < profili.length - 1; c++)
			{
				const paragrafo = document.createElement("p");
				paragrafo.id = c;
				paragrafo.onclick = function()
				{
					window.open("stampa_profilo.jsp", "_self");
					localStorage.setItem("dato", this.id);
				}
				paragrafo.innerText = profili[c];
				document.getElementById("curriculum").appendChild(paragrafo);
			}
		}
	}
}*/
function stampa_profilo()
{
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", 'Servlet_Ricerca', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "stampa_profilo/," + localStorage.getItem("dato"));
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			
			var risposta_profilo = xhttp.responseText;
			profilo = risposta_profilo.split(", #");    // cambiano tutti i riferimenti pr modifica al Db
			
			menu_cascata2(profilo[7], profilo[15], profilo[16], profilo[17], profilo[18], profilo[19], profilo[21], profilo[22], 
						  profilo[23], profilo[26], profilo[11]);
			
			document.getElementById("id").value = profilo[1];
			document.getElementById("nome_cognome").value = profilo[2];
			document.getElementById("recapito").value =  profilo[3];  // Controllo se profilo[] è null, se lo è campo vuoto
			document.getElementById("email").value = profilo[4];
			document.getElementById("profilo_linkedin").value = profilo[5];
			document.getElementById("citta_di_allocazione").value = profilo[6];            // profilo[4]!=="null"?profilo[4]:"";
			
			//document.getElementById("ruolo").value = profilo[15];   // 7
			document.getElementById("competenza_principale").value = profilo[8];
			
			document.getElementById("data_colloquio").value = profilo[9];
			document.getElementById("anno_colloquio").value = profilo[10];
			//document.getElementById("esito_colloquio").value = profilo[11];
			
			document.getElementById("fonte_reperimento").value = profilo[12];
			
			document.getElementById("costo_giornaliero").value = profilo[13];
			document.getElementById("possibilita_lavorativa").value = profilo[14];
			
			/*document.getElementById("skill").value = profilo[15];
			document.getElementById("tech_1").value = profilo[16];   // prima tech
			document.getElementById("tech_2").value = profilo[17];
			document.getElementById("tech_3").value = profilo[18];
			document.getElementById("tech_4").value = profilo[19];*/
			document.getElementById("skill_campo_libero").value = profilo[20];
			
			/*document.getElementById("lingua_1").value = profilo[21];
			document.getElementById("lingua_2").value = profilo[22];
			document.getElementById("lingua_3").value = profilo[23];*/
			
			document.getElementById("competenze_totali").value = profilo[24];
			document.getElementById("certificazioni").value = profilo[25];
			//document.getElementById("seniority").value = profilo[26];
			
			
			var x=0;
			for(var i=29; i < profilo.length-1; i++)
			{
				const paragrafo = document.createElement("span");
				paragrafo.id = i;
				paragrafo.innerText = profilo[i] + "  ";
				if(x==0 || x==1){
					paragrafo.classList.add('ruolo_data_commenti');
				}
				if(x==2){
					paragrafo.classList.add('testo_commenti');
				}
				document.getElementById("commenti").appendChild(paragrafo);
				x++;
				if(x==2)
				{
					const br = document.createElement("p");
					document.getElementById("commenti").appendChild(br);
				}
				if(x==3)
				{
					const br = document.createElement("hr");
					document.getElementById("commenti").appendChild(br);
					x=0;
				}
			}
				
			localStorage.setItem("nome_cognome", profilo[2]);
			localStorage.setItem("array", profilo);
		}
	}
}
function stampa_profilo_lettura()
{
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", 'Servlet_Ricerca', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "stampa_profilo/," + localStorage.getItem("dato"));
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta_profilo = xhttp.responseText;
			profilo = risposta_profilo.split(", #");    // cambiano tutti i riferimenti pr modifica al Db
			document.getElementById("id").value = profilo[1];
			
			document.getElementById("nome_cognome").innerHTML = profilo[2]// Home > Ricerca > Nome&Cognome
			document.getElementById("nome_cognome").value = profilo[2]// Home > Ricerca > Nome&Cognome
			
			document.getElementById("recapito").innerHTML =  profilo[3];  // Controllo se profilo[] è null, se lo è campo vuoto
			document.getElementById("email").innerHTML = profilo[4]
			document.getElementById("profilo_linkedin").href = profilo[5];
			document.getElementById("citta_di_allocazione").innerHTML = profilo[6];            // profilo[4]!=="null"?profilo[4]:"";
			
			document.getElementById("ruolo_profilo").innerHTML = profilo[7];
			document.getElementById("competenza_principale").innerHTML = profilo[8];
			
			document.getElementById("data_colloquio").innerHTML = profilo[9];
			document.getElementById("anno_colloquio").innerHTML = profilo[10];
			document.getElementById("esito_colloquio").innerHTML = profilo[11];
			
			document.getElementById("fonte_reperimento").innerHTML = profilo[12];
			
			document.getElementById("costo_giornaliero").innerHTML = profilo[13];
			document.getElementById("possibilita_lavorativa").innerHTML = profilo[14];
			
			document.getElementById("skill_1").innerHTML = profilo[15];
			document.getElementById("skill_2").innerHTML = profilo[16];   // prima tech
			document.getElementById("skill_3").innerHTML = profilo[17];
			document.getElementById("skill_4").innerHTML = profilo[18];
			document.getElementById("skill_5").innerHTML = profilo[19];
			document.getElementById("skill_campo_libero").innerHTML = profilo[20];
			
			document.getElementById("lingua_1").innerHTML = profilo[21];
			document.getElementById("lingua_2").innerHTML = profilo[22];
			document.getElementById("lingua_3").innerHTML = profilo[23];
			
			document.getElementById("competenze_totali").innerHTML = profilo[24];
			document.getElementById("certificazioni").innerHTML = profilo[25];
			document.getElementById("seniority").innerHTML = profilo[26];
			
			document.getElementById("data_inserimento").innerHTML = profilo[27];
			
			localStorage.setItem("nome_cognome", profilo[2]);
			localStorage.setItem("array", profilo);
			
			var x=0;
			for(var i=29; i < profilo.length-1; i++)
			{
				const paragrafo = document.createElement("span");
				paragrafo.id = i;
				paragrafo.innerText = profilo[i] + "  ";
				if(x==0 || x==1){
					paragrafo.classList.add('ruolo_data_commenti');
				}
				if(x==2){
					paragrafo.classList.add('testo_commenti');
				}
				document.getElementById("commento").appendChild(paragrafo);
				x++;
				if(x==2)
				{
					const br = document.createElement("p");
					document.getElementById("commento").appendChild(br);
				}
				if(x==3)
				{
					const br = document.createElement("hr");
					document.getElementById("commento").appendChild(br);
					x=0;
				}
			}	
		}
	}
}
function cerca()
{
	var ricerca = document.getElementById("ricerca").value;
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", 'Servlet_Ricerca', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "ricerca/," + ricerca);
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta = xhttp.responseText;
			profili = risposta.split(", ");
			const paragrafo = document.createElement("p");
			paragrafo.id = risposta[4];
			paragrafo.onclick = function()
			{
				window.open("stampa_profilo.jsp", "_self");
				localStorage.setItem("dato", this.id);
			}
			paragrafo.innerText = profili[1];
			document.getElementById("curriculum").innerHTML = " ";
			document.getElementById("curriculum").appendChild(paragrafo);
		}
	}
}
function scarica()
{
	var nome_cognome = localStorage.getItem("nome_cognome");
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", 'Servlet_Ricerca', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "scaricaCv/," + nome_cognome);
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta = xhttp.responseText;
			app = risposta.split("\\");
			file = app[app.length-1];
			alert(app[app.length-1]);
			
			var pdf = document.createElement("a");
			pdf.id = file;
			pdf.href = risposta;
			pdf.download = nome_cognome;
			pdf.type="hidden";
			document.getElementById("scarica_cv").appendChild(pdf);
			document.getElementById(file).click();
			}
		}
}

function genera_cv()
{
	var nome_cognome = localStorage.getItem("nome_cognome");
	var doc = new jsPDF();
	var img = new Image();

	
	img.src="Immagini/logo_pdf.png";
	var categorie = ["", "Nome e Cognome:", "Recapito: ",  "Email: ", "Profilo Linkedin: ", "Citta': ", "Ruolo: ", "Competenza Principale: ", "Data Colloquio: ", 
	"Anno Colloquio: ", "Esito Colloquio: ", "Fonte Reperimento: ", "Costo Giornaliero: ", "Possibilita' Lavorativa: ", "Skill: ",
	"Tech1: ", "Tech2: ", "Tech3: ", "Tech4: ", "Tech (Campo Libero): ", "Lingua1: ", "Lingua2: ", "Lingua3: ", "Competenze Totali: ", "Certificazioni: ",
	"Seniority: "];
	str = localStorage.getItem("array");
	array = str.split(",");
	array.pop();
	array.shift();
	var c=40;
	doc.setFontSize(14);
	doc.setFont('helvetica');
    doc.setFontType('bold');
    doc.text("Recruiter: ", 100, 10);
	doc.text(localStorage.getItem("nome_utente"), 100, 20);
	doc.addImage(img, 'PNG', 10, 5, 60, 19);
	doc.setDrawColor(255,215,0);
	doc.setLineWidth(1);
	doc.line(20, 30, 190, 30);
	
	for(let i=1; i<26;i++)
		if(array[i]!="" && array[i]!=" ")
		{
			doc.text(categorie[i] + " " + array[i], 20, c);
			doc.setTextColor(110, 110, 110, 1);
			c+=10;
		}
	doc.save(nome_cognome +  '_Cv.pdf')
}
function menu_cascata()
{
	menu_cascata_ruolo_profilo();  //ex skill
	menu_cascata_lingue();
	menu_cascata_seniority();
	menu_cascata_skill();  // ex tech
	menu_cascata_esito_colloquio();
}
function menu_cascata_lingue()
{
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", 'Servlet', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "get_lingua");
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta_lingua = xhttp.responseText;
			lingue = risposta_lingua.split(", ");
			lingue.pop();
			lingue.shift();
			for (var c = 0; c < lingue.length; c++)
			{
				const lingua = document.createElement("option");
				lingua.value = lingue[c];
				lingua.innerHTML = lingue[c];
				document.getElementById('lingua_1').appendChild(lingua);
				
				const lingua2 = document.createElement("option");
				lingua2.value = lingue[c];
				lingua2.innerHTML = lingue[c];
				document.getElementById('lingua_2').appendChild(lingua2);
				
				const lingua3 = document.createElement("option");
				lingua3.value = lingue[c];
				lingua3.innerHTML = lingue[c];
				document.getElementById('lingua_3').appendChild(lingua3);
			}
		}
	}
}
function menu_cascata_seniority()
{
	var xhttp = new XMLHttpRequest();
	
	xhttp.open("POST", 'Servlet', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "get_seniority");
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta_seniority = xhttp.responseText;
			seniority = risposta_seniority.split(", ");
			seniority.pop();
			seniority.shift();
			for (var c = 0; c < seniority.length; c++)
			{
				const senior = document.createElement("option");
				senior.value = seniority[c];
				senior.innerHTML = seniority[c];
				document.getElementById('seniority').appendChild(senior);
			}
		}
	}
}
function menu_cascata_ruolo_profilo()  // ex Skill
{
	var xhttp = new XMLHttpRequest();
	
	xhttp.open("POST", 'Servlet', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "get_ruolo_profilo");
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta_ruolo_profilo = xhttp.responseText;
			ruolo_profilo = risposta_ruolo_profilo.split(", ");
			ruolo_profilo.pop();
			ruolo_profilo.shift();
			for (var c = 0; c < ruolo_profilo.length; c++)
			{
				const ruolo_profili = document.createElement("option");
				ruolo_profili.value = ruolo_profilo[c];
				ruolo_profili.innerHTML = ruolo_profilo[c];
				document.getElementById('ruolo_profilo').appendChild(ruolo_profili);
			}
		}
	}
}
function menu_cascata_esito_colloquio()
{
	var xhttp = new XMLHttpRequest();
	
	xhttp.open("POST", 'Servlet', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "get_esito_colloquio");
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta_esito_colloqui = xhttp.responseText;
			esito_colloqui = risposta_esito_colloqui.split(", ");
			esito_colloqui.pop();
			esito_colloqui.shift();
			for (var c = 0; c < esito_colloqui.length; c++)
			{
				const esito_colloquio = document.createElement("option");
				esito_colloquio.value = esito_colloqui[c];
				esito_colloquio.innerHTML = esito_colloqui[c];
				document.getElementById('esito_colloquio').appendChild(esito_colloquio);
			}
		}
	}
}
function menu_cascata_skill()  // ex tech
{
	var xhttp = new XMLHttpRequest();
	
	xhttp.open("POST", 'Servlet', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "get_skill");
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta_skill = xhttp.responseText;
			skill = risposta_skill.split(", ");
			skill.pop();
			skill.shift();
			for (var c = 0; c < skill.length; c++)
			{
				const skills = document.createElement("option");
				skills.value = skill[c];
				skills.innerHTML = skill[c];
				document.getElementById('skill_1').appendChild(skills);  // sostituito input_tech1
				
				const skills2 = document.createElement("option");
				skills2.value = skill[c];
				skills2.innerHTML = skill[c];
				document.getElementById('skill_2').appendChild(skills2);
				
				const skills3 = document.createElement("option");
				skills3.value = skill[c];
				skills3.innerHTML = skill[c];
				document.getElementById('skill_3').appendChild(skills3);
				
				const skills4 = document.createElement("option");
				skills4.value = skill[c];
				skills4.innerHTML = skill[c];
				document.getElementById('skill_4').appendChild(skills4);
				
				const skills5 = document.createElement("option");
				skills5.value = skill[c];
				skills5.innerHTML = skill[c];
				document.getElementById('skill_5').appendChild(skills5);
			}
		}
	}
}
function register()
{
	var password = document.getElementById('password').value;
	if (password != document.getElementById('conferma_password').value)
		alert("Le due password non coincidono");
	else
	{
		var nome_cognome = document.getElementById("nome_cognome").value;
		var email = document.getElementById("email").value;
		var ruolo = document.getElementById("ruolo").value;
		
		var xhttp = new XMLHttpRequest();
		
		xhttp.open("POST", 'Servlet_Ricerca', true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send("Servlet=" + "register/," + nome_cognome + "/," + email + "/," + ruolo + "/," + password);
		xhttp.onreadystatechange = function()
		{
			if (this.readyState == 4 && this.status == 200)
			{
				var register = xhttp.responseText;
				if (register[0] == 1)
				{
					alert ("Registrazione effettuata con successo");
					window.open("home.jsp", "_self");
				}
				else
					alert ("Email già esistente");
			}
		}
	}
}
function login()
{
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	
	var xhttp = new XMLHttpRequest();
	
	xhttp.open("POST", 'Servlet_Ricerca', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "login/," + email + "/," + password);
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
function menu_cascata_ruolo()
{
	var xhttp = new XMLHttpRequest();
	
	xhttp.open("POST", 'Servlet', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "get_ruolo");
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta_ruolo = xhttp.responseText;
			ruoli = risposta_ruolo.split(", ");
			ruoli.pop();
			ruoli.shift();
			for (var c = 0; c < ruoli.length; c++)
			{
				const ruolo = document.createElement("option");
				ruolo.value = ruoli[c];
				ruolo.innerHTML = ruoli[c];
				document.getElementById('ruolo').appendChild(ruolo);
			}
		}
	}
}
function errore()
{
	window.open("index.jsp", "_self");
}
function menu_cascata2(ruolo_profilo, skill_1, skill_2, skill_3, skill_4, skill_5, lingua1, lingua2, lingia3, seniority, esito_colloquio_1)
{
	menu_cascata_ruolo_profilo2(ruolo_profilo);
	menu_cascata_lingue2(lingua1, lingua2, lingia3);
	menu_cascata_seniority2(seniority);
	menu_cascata_skill2(skill_1, skill_2, skill_3, skill_4, skill_5);
	menu_cascata_esito_colloquio2(esito_colloquio_1);
}


function menu_cascata_lingue2(lingua_1, lingua_2, lingua_3)
{
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", 'Servlet', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "get_lingua");
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta_lingua = xhttp.responseText;
			lingue = risposta_lingua.split(", ");
			lingue.pop();
			lingue.shift();
			for (var c = 0; c < lingue.length; c++)
			{
				const lingua = document.createElement("option");
				lingua.value = lingue[c];
				lingua.innerHTML = lingue[c];
				if (lingue[c] == lingua_1)
					lingua.selected = true;
				document.getElementById('lingua_1').appendChild(lingua);
				
				const lingua2 = document.createElement("option");
				lingua2.value = lingue[c];
				lingua2.innerHTML = lingue[c];
				if (lingue[c] == lingua_2)
					lingua2.selected = true;
				document.getElementById('lingua_2').appendChild(lingua2);
				
				const lingua3 = document.createElement("option");
				lingua3.value = lingue[c];
				lingua3.innerHTML = lingue[c];
				if (lingue[c] == lingua_3)
					lingua3.selected = true;
				document.getElementById('lingua_3').appendChild(lingua3);
			}
		}
	}
}


function menu_cascata_seniority2(seniority_1)
{ 
	var xhttp = new XMLHttpRequest();
	
	xhttp.open("POST", 'Servlet', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "get_seniority");
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta_seniority = xhttp.responseText;
			seniority = risposta_seniority.split(", ");
			seniority.pop();
			seniority.shift();
			for (var c = 0; c < seniority.length; c++)
			{
				const senior = document.createElement("option");
				senior.value = seniority[c];
				senior.innerHTML = seniority[c];
				if (seniority[c] == seniority_1)
					senior.selected = true;
				document.getElementById('seniority').appendChild(senior);
			}
		}
	}
}


function menu_cascata_ruolo_profilo2(ruolo_profilo_1)
{
	var xhttp = new XMLHttpRequest();
	
	xhttp.open("POST", 'Servlet', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "get_ruolo_profilo");
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta_ruolo_profilo = xhttp.responseText;
			ruolo_profilo = risposta_ruolo_profilo.split(", ");
			ruolo_profilo.pop();
			ruolo_profilo.shift();
			for (var c = 0; c < ruolo_profilo.length; c++)
			{
				const ruolo_profili = document.createElement("option");
				ruolo_profili.value = ruolo_profilo[c];
				ruolo_profili.innerHTML = ruolo_profilo[c];
				if (ruolo_profilo[c] == ruolo_profilo_1)
					ruolo_profili.selected = true;
				document.getElementById('ruolo_profilo').appendChild(ruolo_profili);
			}
		}
	}
}


function menu_cascata_esito_colloquio2(esito_colloquio_1)
{ 
	var xhttp = new XMLHttpRequest();
	
	xhttp.open("POST", 'Servlet', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "get_esito_colloquio");
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta_esito_colloqui = xhttp.responseText;
			esito_colloqui = risposta_esito_colloqui.split(", ");
			esito_colloqui.pop();
			esito_colloqui.shift();
			for (var c = 0; c < esito_colloqui.length; c++)
			{
				const esito_colloquio = document.createElement("option");
				esito_colloquio.value = esito_colloqui[c];
				esito_colloquio.innerHTML = esito_colloqui[c];
				//alert(esito_colloquio_1[1]);
				if (esito_colloqui[c] == esito_colloquio_1)
					esito_colloquio.selected = true;
				document.getElementById('esito_colloquio').appendChild(esito_colloquio);
			}
		}
	}
}

function menu_cascata_skill2(skill_1, skill_2, skill_3, skill_4, skill_5)
{ 
	var xhttp = new XMLHttpRequest();
	
	xhttp.open("POST", 'Servlet', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "get_skill");
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta_skill = xhttp.responseText;
			skill = risposta_skill.split(", ");
			skill.pop();
			skill.shift();
			for (var c = 0; c < skill.length; c++)
			{
				const skills_1 = document.createElement("option");
				skills_1.value = skill[c];
				skills_1.innerHTML = skill[c];
				if (skill[c] == skill_1)
					skills_1.selected = true;
				document.getElementById('skill_1').appendChild(skills_1);
				
				const skills_2 = document.createElement("option");
				skills_2.value = skill[c];
				skills_2.innerHTML = skill[c];
				if (skill[c] == skill_2)
					skills_2.selected = true;
				document.getElementById('skill_2').appendChild(skills_2);
				
				const skills_3 = document.createElement("option");
				skills_3.value = skill[c];
				skills_3.innerHTML = skill[c];
				if (skill[c] == skill_3)
					skills_3.selected = true;
				document.getElementById('skill_3').appendChild(skills_3);
				
				const skills_4 = document.createElement("option");
				skills_4.value = skill[c];
				skills_4.innerHTML = skill[c];
				if (skill[c] == skill_4)
					skills_4.selected = true;
				document.getElementById('skill_4').appendChild(skills_4);
				
				const skills_5 = document.createElement("option");
				skills_5.value = skill[c];
				skills_5.innerHTML = skill[c];
				if (skill[c] == skill_5)
					skills_5.selected = true;
				document.getElementById('skill_5').appendChild(skills_5);
			}
		}
	}
}
function controlla()
{
	if (document.getElementById('password').value != document.getElementById('conferma_password').value)
		alert("Le due password non coincidono");
}	
function cambia_password()
{
	var password = document.getElementById('password').value;
	if (password != document.getElementById('conferma_password').value)
		alert("Le due password non coincidono");
	else
	{
		var xhttp = new XMLHttpRequest();
	
		xhttp.open("POST", 'Servlet_Ricerca', true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send("Servlet=" + "cambia_password/," + password);
		xhttp.onreadystatechange = function()
		{
			if (this.readyState == 4 && this.status == 200)
			{
				var risposta = xhttp.responseText;
				if (risposta[0] == 1)
				{
					window.open("ricerca.jsp", "_self");
					alert("Password Aggiornata");
				}
				else
					alert("La password è la stessa di prima");
			}
		}
	}
}
function elimina()
{
	var conferma = confirm("Sicuro di voler eliminare il profilo di " + document.getElementById("nome_cognome").value + "?");
	if (conferma == true)
	{
		var xhttp = new XMLHttpRequest();
		var id = document.getElementById("id").value;

		xhttp.open("POST", 'Servlet_Ricerca', true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send("Servlet=" + "elimina_profilo/," + id);
		xhttp.onreadystatechange = function()
		{
			if (this.readyState == 4 && this.status == 200)
			{
				var risposta = xhttp.responseText;
				if (risposta[0] == 1)
				{
					window.open("ricerca.jsp", "_self");
					alert("Profilo eliminato con successo");
				}
			}
		}
	}
}

function stampa_avvisi()
{
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", 'Servlet_Ricerca', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "stampa_avvisi");
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta_avvisi = xhttp.responseText;
			avvisi = risposta_avvisi.split("**,");
			avvisi.pop();
			avvisi.shift();
			
			for (var c = 0; c < avvisi.length; c++)
			{
				
				const div = document.createElement("div");
				div.classList.add('col-4', 'card_avvisi');
				div.id = "div_avvisi" + c;
				document.getElementById("stampa_avvisi").appendChild(div);
				
				avvisi_split = avvisi[c].split("*")
				
				const data = document.createElement("span");
				data.value = avvisi_split[0];
				data.innerHTML = avvisi_split[0];
				data.classList.add('data_ora_avvisi');
				document.getElementById('div_avvisi' + c).appendChild(data);
				
				const icona = document.createElement("i");
				icona.innerHTML = '<a href="#"><i class="icon icon-delete red-text s-18" onclick="elimina_avviso('+avvisi_split[3]+')"></i>';
				document.getElementById('div_avvisi' + c).appendChild(icona);
				
				const titolo = document.createElement("p");
				titolo.value = avvisi_split[1];
				titolo.innerHTML = avvisi_split[1];
				titolo.classList.add('titolo_avvisi');
				document.getElementById('div_avvisi' + c).appendChild(titolo);
				
				const avv = document.createElement("p");
				avv.value = avvisi_split[2];
				avv.innerHTML = avvisi_split[2];
				avv.classList.add('testo_avvisi');
				document.getElementById('div_avvisi' + c).appendChild(avv);
				
				const destinatari = document.createElement("span");
				
				var destinatari_split = avvisi_split[4].split(".")
				
				for(var i=0; i<destinatari_split.length;i++){
					if(destinatari_split[i] != ""){
						const ruolo = document.createElement("span");
						ruolo.value = destinatari_split[i] + " ";
						ruolo.innerHTML = destinatari_split[i];
						ruolo.classList.add('destinatari_avvisi');
						//document.getElementById('destinatari').appendChild(ruolo);
						destinatari.appendChild(ruolo);
					}
				}
				
				document.getElementById('div_avvisi' + c).appendChild(destinatari);
				
				/*const destinatari = document.createElement("p");
				var destinatari_split = avvisi_split[4].split(".")
				var value = " ";
				for(var i=0; i<destinatari_split.length;i++){
					if(destinatari_split[i] != ""){
						value += destinatari_split[i] + " ";
					}
				}
				destinatari.value = value;
				destinatari.innerHTML = value;
				destinatari.classList.add('destinatari_avvisi');
				*/
				
				
				
			}
		}
	}
}

function elimina_avviso(id){
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", 'Servlet_Ricerca', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "elimina_avviso/," + id);
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta = xhttp.responseText;
			if (risposta[0] == 1)
			{
				alert("Avviso eliminato con successo");
				window.open("home.jsp", "_self");
			}
		}
	}
}



function registra_avviso()
{
	var titolo = document.getElementById("titolo").value;
	var avviso = document.getElementById("avviso").value;
	
	var admin;
	if (document.getElementById("admin").checked)
		admin = document.getElementById("admin").value;
	else
		admin = "";
		
	var recruiter;
	if (document.getElementById("recruiter").checked)
		recruiter = document.getElementById("recruiter").value;
	else
		recruiter = "";
		
	var commerciale;
	if (document.getElementById("commerciale").checked)
		commerciale = document.getElementById("commerciale").value;
	else
		commerciale = "";
	
	var dipendente;
	if (document.getElementById("dipendente").checked)
		dipendente = document.getElementById("dipendente").value;
	else
		dipendente = "";
	
	var tutti;
	if (document.getElementById("tutti").checked)
		tutti = document.getElementById("tutti").value;
	else
		tutti = "";
	
	var destinatario = admin + "." + recruiter + "." + commerciale + "." + dipendente + "." + tutti;
	
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", 'Servlet_Ricerca', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("Servlet=" + "registra_avviso/," + titolo + "/," + avviso + "/," + destinatario);
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var risposta = xhttp.responseText;
			if (risposta[0] == 1)
			{
				alert("Avviso pubblicato con successo");
				window.open("home.jsp", "_self");
			}
		}
	}
}