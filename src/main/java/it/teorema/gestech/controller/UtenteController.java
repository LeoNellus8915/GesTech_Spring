package it.teorema.gestech.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.model.Ruoli;
import it.teorema.gestech.service.RuoliService;
import it.teorema.gestech.session.LocalSession;

@Controller
public class UtenteController {

	@Autowired
	RuoliService ruoliService;
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

		List<Ruoli> ruoli = new ArrayList<Ruoli>();
		for (int c = 0; c < ruoliService.findAll().size(); c++) {
			Ruoli app = (Ruoli) ruoliService.findAll().get(c);
			ruoli.add(app);
		}

		theModel.addAttribute("ruoli", ruoli);
		theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
		theModel.addAttribute("ruolo", localSession.getRuolo());
		theModel.addAttribute("titlePage", "Utente");
		theModel.addAttribute("view", "nuovoUtente");

		return "default";
	}
}
