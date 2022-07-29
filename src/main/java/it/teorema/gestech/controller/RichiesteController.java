package it.teorema.gestech.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.model.Linguaggi;
import it.teorema.gestech.model.Livelli;
import it.teorema.gestech.model.Profili;
import it.teorema.gestech.model.Richieste;
import it.teorema.gestech.model.CommentiRichieste;
import it.teorema.gestech.service.CommentiRichiesteService;
import it.teorema.gestech.service.LinguaggiService;
import it.teorema.gestech.service.LivelliService;
import it.teorema.gestech.service.ProfiliService;
import it.teorema.gestech.service.RichiesteService;
import it.teorema.gestech.service.StatiRichiestaService;
import it.teorema.gestech.session.LocalSession;

@Controller
public class RichiesteController {
	
	@Autowired
	CommentiRichiesteService commentiRichieste;
	@Autowired
	RichiesteService Richieste;
	@Autowired
	StatiRichiestaService statiRichieste;
	@Autowired
	ProfiliService profiliService;
	@Autowired
	LinguaggiService linguaggiService;
	@Autowired
	LivelliService livelliService;
	
	@RequestMapping("/nuova-richiesta")
	public String paginaNuovaRichiesta(HttpServletRequest request, Model theModel)
	{
		HttpSession session = request.getSession(true);
		if (session.getAttribute("idSessione") == null)
		{
			theModel.addAttribute("titlePage", "Login");
			theModel.addAttribute("msgCredenziali", "Inserisci le credenziali per accedere al sistema");
			return "index";
		}
		else
		{
			LocalSession localSession = (LocalSession) session.getAttribute("localSession");
			
			List<Profili> profili = profiliService.findAll();
			List<Linguaggi> linguaggi = linguaggiService.findAll();
			List<Livelli> livelli = livelliService.findAll();
			
			theModel.addAttribute("livelli", livelli);
			theModel.addAttribute("livelli", "Selezionare...");
			theModel.addAttribute("linguaggi", linguaggi);
			theModel.addAttribute("linguaggi", "Selezionare...");
			theModel.addAttribute("profili", profili);
			theModel.addAttribute("profilo", "Selezionare...");
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Nuova Richiesta");
			theModel.addAttribute("view", "nuovaRichiesta");
		}
		return null;
	}
}
