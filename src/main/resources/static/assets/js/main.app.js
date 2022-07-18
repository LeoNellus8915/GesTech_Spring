(function(w, d, u) 
{ 
	w.readyQ = []; 
	w.bindReadyQ = []; 
	function p(x, y) 
	{ 
		if (x == "ready") 
		{ w.bindReadyQ.push(y); } 
		else 
		{ w.readyQ.push(x); } 
		};
		var a = { ready: p, bind: p }; 
		w.$ = w.jQuery = function(f) 
		{ 
			if (f === d || f === u) 
			{ return a } 
			else { p(f) } 
			} 
			})(window, document);
			
			
function stampaRuoli()
{
	$.ajax({
  		dataType: "json",
 		url: "stampaRuoli",
  		success: function (data){
		for (var c=0; c<data.length; c++)
			$('#ruolo').append(`<option value="${data[c].id}">${data[c].nome}</option>`);
		}
	});
}