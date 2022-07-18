package it.teorema.gestech.controller;

import java.util.ArrayList;

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
		/**
		 * passo il nome della pagina che si deve caricare i file si trovano in
		 * template/subPage
		 */
		HttpSession session = request.getSession(true);
		LocalSession ls  = (LocalSession) session.getAttribute("localSession");

		ArrayList ruoli = new ArrayList();
		for (int c = 0; c < ruoliService.findAll().size(); c++) {
			Ruoli app = (Ruoli) ruoliService.findAll().get(c);
			ruoli.add(app);
		}

		theModel.addAttribute("ruoli", ruoli);
		theModel.addAttribute("nomeCognome", ls.getNomeCognome());
		theModel.addAttribute("ruolo", ls.getRuolo());
		theModel.addAttribute("titlePage", "Utente");
		theModel.addAttribute("view", "nuovoUtente");
		/**
		 * nome del tempate da usare (default/login)
		 */
		return "default";
	}
}
