package it.teorema.gestech.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
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
import it.teorema.gestech.model.Richieste;
import it.teorema.gestech.model.StatiRichiesta;
import it.teorema.gestech.service.CommentiRichiesteService;
import it.teorema.gestech.service.LinguaggiService;
import it.teorema.gestech.service.LivelliService;
import it.teorema.gestech.service.ProfiliService;
import it.teorema.gestech.service.RichiesteService;
import it.teorema.gestech.service.RisorseService;
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
	RisorseService risorseService;
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
			
			theModel.addAttribute("nomiRecruiter", risorseService.getNomi());
			theModel.addAttribute("livelli", livelliService.findAll());
			theModel.addAttribute("linguaggi", linguaggiService.findAll());
			theModel.addAttribute("profili", profiliService.findAll());
			
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
			
			DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			LocalDateTime data = LocalDateTime.parse(format1.format(now), format1);	
			
			String[] inputRecruiter = request.getParameterValues("recruiter");
			List<String> listaRecuiter = Arrays.asList(inputRecruiter);
			
			richiesta.setIdRisorsa(localSession.getIdRisorsa());
			richiesta.setData(data);
			richiesta.setIdSkill(Integer.parseInt(request.getParameter("linguaggio")));
			richiesta.setIdProfilo(Integer.parseInt(request.getParameter("profilo")));
			richiesta.setIdSeniority(Integer.parseInt(request.getParameter("seniority")));
			richiesta.setCliente(request.getParameter("cliente"));
			richiesta.setCitta(request.getParameter("citta"));
			richiesta.setCosto(Double.parseDouble(request.getParameter("costo")));
			richiesta.setNote(request.getParameter("note"));
			richiesta.setRecruiter(listaRecuiter.toString());
			
			richiesteService.save(richiesta);
			
			theModel.addAttribute("risorsa", richiesta);
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Tutte le Richieste");
			theModel.addAttribute("path", "richieste/");
			theModel.addAttribute("view", "visualizzaRichieste");
			
			return "default"+localSession.getRuolo();
		}
		
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
			
			List lista = new ArrayList();
			
			List<Richieste>richieste = richiesteService.findAll();
			List<Richieste> stampaRichieste = new ArrayList<Richieste>();
			
			String appoggio = null;
			
			if(localSession.getRuolo().equals("Commerciale")) 
			{
				for (Richieste richieste2 : richieste) {
					/*appoggio = richieste2.getRecruiter();
					appoggio=appoggio.replace("[","");
					appoggio=appoggio.replace("]","");
					appoggio=appoggio.replace(",", "");
					richieste2.setRecruiter(appoggio);*/
					lista.add(richiesteService.stampaCard(richieste2.getIdSeniority(), richieste2.getIdSkill(), 
							richieste2.getIdProfilo(), richieste2.getIdStato()));
				}
			}
			else 
			{
				for (Richieste richieste2 : richieste) 
				{
					if(richieste2.getRecruiter().contains("Tutti") 
							|| richieste2.getRecruiter().contains(localSession.getNomeCognome())) {
						/*appoggio = richieste2.getRecruiter();
						appoggio=appoggio.replace("[","");
						appoggio=appoggio.replace("]","");
						appoggio=appoggio.replace(",", "");
						richieste2.setRecruiter(appoggio);
						stampaRichieste.add(richieste2);*/
						lista.add(richiesteService.stampaCard(richieste2.getIdSeniority(), richieste2.getIdSkill(), 
								richieste2.getIdProfilo(), richieste2.getIdStato()));
					}
				}
				
			}
			theModel.addAttribute("richieste", lista);
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
			
			theModel.addAttribute("richiesta", richiesta);
			theModel.addAttribute("commentiRichiesta", commentiRichiesteService.findById(richiesta.getIdCommento()));
			theModel.addAttribute("statoRichiesta", richiesteService.findById(richiesta.getIdStato()));
			theModel.addAttribute("statiRichiesta", statiRichiesteService.findAllException(statiRichiesteService.findById(richiesta.getIdStato())));
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Visualizza Richiesta");
			theModel.addAttribute("path", "richieste/");
			theModel.addAttribute("view", "visualizzaRichieste");
			
			return "default"+localSession.getRuolo();
		}
	}
	
}
