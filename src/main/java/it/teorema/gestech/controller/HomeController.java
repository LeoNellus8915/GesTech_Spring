package it.teorema.gestech.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.model.Avvisi;
import it.teorema.gestech.service.AvvisiService;
import it.teorema.gestech.session.LocalSession;

@Controller
public class HomeController {
	@Autowired
	AvvisiService avvisiService;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request, Model theModel)
	{
		theModel.addAttribute("titlePage", "Login");
		theModel.addAttribute("msgCredenziali", "Inserisci le credenziali per accedere al sistema");
		return "index";
	}
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request, Model theModel) {
		HttpSession session = request.getSession(true);
		LocalSession localSession = (LocalSession) session.getAttribute("localSession");
		
		theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
		theModel.addAttribute("ruolo", localSession.getRuolo());
		theModel.addAttribute("titlePage", "HOME");
		theModel.addAttribute("view", "home");
		
		return "default";
	}
	
	@RequestMapping("/salva-avvisi")
	@Transactional
	public String salvaAvvisi(HttpServletRequest request, Model theModel)
	{
		Avvisi salvaAvviso = new Avvisi();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		LocalDateTime data = LocalDateTime.parse(dtf.format(now), dtf);		

		HttpSession session = request.getSession(true);
		LocalSession localSession = (LocalSession) session.getAttribute("localSession");
				
		String[] inputRuolo = request.getParameterValues("ruolo");
		List listaRuoli = Arrays.asList(inputRuolo);
		 
		salvaAvviso.setTitolo(request.getParameter("titolo"));
		salvaAvviso.setIdRisorsa(localSession.getIdRisorsa());
		salvaAvviso.setRuoli(listaRuoli.toString());
		salvaAvviso.setNote(request.getParameter("avviso"));
		salvaAvviso.setData(data);
		
		avvisiService.save(salvaAvviso);
		
		theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
		theModel.addAttribute("ruolo", localSession.getRuolo());
		theModel.addAttribute("titlePage", "HOME");
		theModel.addAttribute("view", "home");
		
		return "default";
	}
}