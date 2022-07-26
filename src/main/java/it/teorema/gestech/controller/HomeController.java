package it.teorema.gestech.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import it.teorema.gestech.model.Avvisi;
import it.teorema.gestech.service.AuthService;
import it.teorema.gestech.service.AvvisiService;
import it.teorema.gestech.session.LocalSession;

@Controller
public class HomeController {
	@Autowired
	AvvisiService avvisiService;
	@Autowired
	AuthService authService;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request, Model theModel)
	{
		HttpSession session = request.getSession(true);
		if (session.getAttribute("idSessione") == null)
		{
			theModel.addAttribute("titlePage", "Login");
			theModel.addAttribute("msgCredenziali", "Inserisci le credenziali per accedere al sistema");
			return "index";
		}
		else
			return "redirect:home";
	}
	
	@RequestMapping("/modifica-password")
	public String modificaPassword(HttpServletRequest request, Model theModel) {
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
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Password");
			theModel.addAttribute("view", "cambiaPassword");
			
			return "default"+localSession.getRuolo();
		}
	}
	
	@Transactional
	@RequestMapping("/cambia-password")
	public String cambiaPassword(HttpServletRequest request, Model theModel) {
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
			
			authService.cambiaPassword(request.getParameter("passwordMD5"), localSession.getIdRisorsa());
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Candidati");
			theModel.addAttribute("view", "paginaCandidati");
			
			return "default"+localSession.getRuolo();
		}
	}
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request, Model theModel) {
		HttpSession session = request.getSession(true);
		Gson gson = new Gson();
		if (session.getAttribute("idSessione") == null)
		{
			theModel.addAttribute("titlePage", "Login");
			theModel.addAttribute("msgCredenziali", "Inserisci le credenziali per accedere al sistema");
			return "index";
		}
		else
		{
			LocalSession localSession = (LocalSession) session.getAttribute("localSession");
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "HOME");
			theModel.addAttribute("view", "home"+localSession.getRuolo());
			
			List<Avvisi> avvisi = new ArrayList<Avvisi>();
			avvisi = avvisiService.findAll();
			
			List<Avvisi> stampaAvvisi = new ArrayList<Avvisi>();
			
			if(localSession.getRuolo().equals("Admin")) {
				for (Avvisi avviso : avvisi) {
					String appoggio = avviso.getRuoli();
					appoggio.substring(1);
					appoggio=appoggio.replace("[","");
					appoggio=appoggio.replace("]","");
					appoggio=appoggio.replace(",", "");
					avviso.setRuoli(appoggio);
					System.out.println(appoggio);
					theModel.addAttribute("avvisi", avvisi);
				}
			}
			else 
			{
				for (Avvisi avviso : avvisi) {	
					if(avviso.getRuoli().indexOf("Tutti") > 0 || 
							avviso.getRuoli().indexOf(localSession.getRuolo()) > 0) {
					}
				}
				theModel.addAttribute("avvisi", stampaAvvisi);
			}
			return "default"+localSession.getRuolo();
		}
	}
	
	@RequestMapping("/salva-avvisi")
	@Transactional
	public String salvaAvvisi(HttpServletRequest request, Model theModel)
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
			Avvisi salvaAvviso = new Avvisi();
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			LocalDateTime data = LocalDateTime.parse(dtf.format(now), dtf);		
	
			LocalSession localSession = (LocalSession) session.getAttribute("localSession");
					
			String[] inputRuolo = request.getParameterValues("ruolo");
			List<String> listaRuoli = Arrays.asList(inputRuolo);
			 
			salvaAvviso.setTitolo(request.getParameter("titolo"));
			salvaAvviso.setIdRisorsa(localSession.getIdRisorsa());
			salvaAvviso.setRuoli(listaRuoli.toString());
			salvaAvviso.setNote(request.getParameter("avviso"));
			salvaAvviso.setData(data);
			
			avvisiService.save(salvaAvviso);
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "HOME");
			theModel.addAttribute("view", "home"+localSession.getRuolo());
			
			return "default"+localSession.getRuolo();
		}
	}
	
	@RequestMapping("/cancella-avviso")
	@Transactional
	public String cancellaAvviso(@RequestParam(value="idAvviso") int idAvviso, HttpServletRequest request, Model theModel)
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
			
			avvisiService.cancellaAvviso(idAvviso);	
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "HOME");
			theModel.addAttribute("view", "home"+localSession.getRuolo());
			
			return "default"+localSession.getRuolo();
		}	
	}
}