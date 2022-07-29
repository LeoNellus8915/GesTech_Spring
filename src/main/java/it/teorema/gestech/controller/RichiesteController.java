package it.teorema.gestech.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.teorema.gestech.model.CommentiRichieste;
import it.teorema.gestech.model.Linguaggi;
import it.teorema.gestech.model.Livelli;
import it.teorema.gestech.model.Profili;
import it.teorema.gestech.model.Richieste;
import it.teorema.gestech.model.StatiRichiesta;
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
	CommentiRichiesteService commentiRichiesteService;
	@Autowired
	RichiesteService richiesteService;
	@Autowired
	StatiRichiestaService statiRichiesteService;
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
			theModel.addAttribute("linguaggi", linguaggi);
			theModel.addAttribute("profili", profili);
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Nuova Richiesta");
			theModel.addAttribute("path", "richieste/");
			theModel.addAttribute("view", "nuovaRichiesta");
			
			return "default" + localSession.getRuolo();
		}
	}
	
	@RequestMapping("/aggiungi-richiesta")
	public String aggiungiRichiesta(HttpServletRequest request, Model theModel) {
		
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
			
			Richieste richiesta = new Richieste();
			
			DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now();  
			LocalDateTime data = LocalDateTime.parse(format1.format(now), format1);	
			
			richiesta.setIdRisorsa(localSession.getIdRisorsa());
			richiesta.setData(data);
			richiesta.setIdSkill(Integer.parseInt(request.getParameter("skill")));
			richiesta.setIdProfilo(Integer.parseInt(request.getParameter("skill")));
			richiesta.setIdSeniority(Integer.parseInt(request.getParameter("seniority")));
			richiesta.setCliente(request.getParameter("cliente"));
			richiesta.setCitta(request.getParameter("citta"));
			richiesta.setCosto(Double.parseDouble(request.getParameter("costo")));
			richiesta.setNote(request.getParameter("note"));
			richiesta.setRecruiter(request.getParameter("recruiter"));
			richiesta.setIdProfilo(Integer.parseInt(request.getParameter("profilo")));
			
			richiesteService.save(richiesta);
			
			theModel.addAttribute("risorsa", richiesta);
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Tutte le Richieste");
			theModel.addAttribute("path", "richieste/");
			theModel.addAttribute("view", "visualizzaRichieste");
		}
		return "redirect:/visualizza-richieste";
	}
	
	@RequestMapping("/pagina-richieste")
	public String paginaRichiesta(HttpServletRequest request, Model theModel) {
		
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
			
			List<Richieste>richieste = richiesteService.findAll();
			List<Richieste> stampaRichieste = new ArrayList<Richieste>();
			
			String appoggio = null;
			
			if(localSession.getRuolo().equals("Commerciale")) 
			{
				for (Richieste richieste2 : richieste) {
					appoggio = richieste2.getRecruiter();
					appoggio=appoggio.replace("[","");
					appoggio=appoggio.replace("]","");
					appoggio=appoggio.replace(",", "");
					richieste2.setRecruiter(appoggio);
				}
				theModel.addAttribute("richieste", richieste);
			}
			else 
			{
				for (Richieste richieste2 : richieste) 
				{
					if(richieste2.getRecruiter().contains("Tutti") 
							|| richieste2.getRecruiter().contains(localSession.getNomeCognome())) {
						appoggio = richieste2.getRecruiter();
						appoggio=appoggio.replace("[","");
						appoggio=appoggio.replace("]","");
						appoggio=appoggio.replace(",", "");
						richieste2.setRecruiter(appoggio);
						stampaRichieste.add(richieste2);
					}
				}
				theModel.addAttribute("richieste", stampaRichieste);
			}
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Visualizza Richiesta");
			theModel.addAttribute("path", "richieste/");
			theModel.addAttribute("view", "visualizzaRichieste");
			
			return "default"+localSession.getRuolo();
		}
	}
	
	@RequestMapping("/stampa-commenti-richiesta")
	@ResponseBody
	public List stampaCommentiRichiesta(@RequestParam(value="idRisorsa") int idRisorsa) 
	{
		List commentiRichiesta = commentiRichiesteService.stampaCommentiRichieste(idRisorsa);
		
		return commentiRichiesta;
	}
	
	@RequestMapping("visualizza-richiesta/{idRichiesta}")
	public String visualizzaRichiesta(@PathVariable int idRichiesta, HttpServletRequest request, Model theModel)
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
			
			Richieste richiesta = richiesteService.findById(idRichiesta);
			List<CommentiRichieste> commentoRichiesta = commentiRichiesteService.findById(richiesta.getIdCommento());
			List<StatiRichiesta> statiRichiesta = statiRichiesteService.findAllException(statiRichiesteService.findById(richiesta.getIdStato()));
			
			theModel.addAttribute("richiesta", richiesta);
			theModel.addAttribute("commentiRichiesta", commentoRichiesta);
			theModel.addAttribute("statoRichiesta", richiesteService.findById(richiesta.getIdStato()));
			theModel.addAttribute("statiRichiesta", statiRichiesta);
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Visualizza Richiesta");
			theModel.addAttribute("path", "richieste/");
			theModel.addAttribute("view", "visualizzaRichieste");
			
			return "default"+localSession.getRuolo();
		}
	}
	
}
