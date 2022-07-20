package it.teorema.gestech.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.model.Auth;
import it.teorema.gestech.model.Risorse;
import it.teorema.gestech.model.Ruoli;
import it.teorema.gestech.model.RuoliRisorse;
import it.teorema.gestech.service.AuthService;
import it.teorema.gestech.service.RisorseService;
import it.teorema.gestech.service.RuoliRisorseService;
import it.teorema.gestech.service.RuoliService;
import it.teorema.gestech.session.LocalSession;

@Controller
public class UtenteController {

	@Autowired
	RuoliService ruoliService;
	@Autowired
	RisorseService risorseService;
	@Autowired
	AuthService authService;
	@Autowired
	RuoliRisorseService ruoliRisorseService;
//	@Autowired
//	HttpServletRequest request;
//	
//	private LocalSession ls;
//	@PostConstruct
//	public void initialize() {
//		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//		HttpSession session = request.getSession(true);
//		System.out.println(session);
//		ls = (LocalSession) session.getAttribute("localSession");
//	}
	
	@RequestMapping("/nuovo-utente")
	public String nuovoUtente(HttpServletRequest request, Model theModel) {

		HttpSession session = request.getSession(true);
		LocalSession localSession  = (LocalSession) session.getAttribute("localSession");

		List<Ruoli> ruoli = ruoliService.findAll();

		theModel.addAttribute("ruoli", ruoli);
		theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
		theModel.addAttribute("ruolo", localSession.getRuolo());
		theModel.addAttribute("titlePage", "Utente");
		theModel.addAttribute("view", "nuovoUtente");

		return "default";
	}
	
	@RequestMapping("/aggiungi-utente")
	@Transactional
	public String aggiungiUtente(HttpServletRequest request, Model theModel){		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDate now = LocalDate.now();  
		LocalDate data = LocalDate.parse(dtf.format(now), dtf);

		Risorse risorsa = new Risorse();
		Auth auth = new Auth();
		RuoliRisorse ruoliRisorse = new RuoliRisorse();
		
		risorsa.setNomeCognome((String) request.getParameter("nomeCognome"));
		risorsa.setEmail((String) request.getParameter("email"));
		
		risorseService.save(risorsa);
		
		int idRisorsa = risorseService.findId();
		
		auth.setPassword((String) request.getParameter("passwordMD5"));
		auth.setIdRisorsa(idRisorsa);
		auth.setData(data);
		
		authService.save(auth);
		
		ruoliRisorse.setIdRisorsa(idRisorsa);
		ruoliRisorse.setIdRuolo(Integer.parseInt(request.getParameter("ruolo")));
		
		ruoliRisorseService.save(ruoliRisorse);
		
		return "redirect:pagina-candidati";
	}
}