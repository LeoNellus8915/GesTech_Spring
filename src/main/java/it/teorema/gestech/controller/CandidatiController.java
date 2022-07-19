package it.teorema.gestech.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.session.LocalSession;

@Controller
public class CandidatiController {
	
	@RequestMapping("/pagina-candidati")
	public String paginaCandidati(HttpServletRequest request, Model theModel) {
		/**
		 * passo il nome della pagina che si deve caricare
		 * i file si trovano in template/subPage
		 */
		HttpSession session = request.getSession(true);
		LocalSession localSession = (LocalSession) session.getAttribute("localSession");
		
		theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
		theModel.addAttribute("ruolo", localSession.getRuolo());
		theModel.addAttribute("titlePage", "Candidati");
		theModel.addAttribute("view", "paginaCandidati");
		/**
		 * nome del tempate da usare (default/login)
		 */
		return "default";
	}
	@RequestMapping("/nuovo-candidato")
	public String nuovoCandidato(HttpServletRequest request, Model theModel) {
		/**
		 * passo il nome della pagina che si deve caricare
		 * i file si trovano in template/subPage
		 */
		HttpSession session = request.getSession(true);
		LocalSession localSession = (LocalSession) session.getAttribute("localSession");
		
		theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
		theModel.addAttribute("ruolo", localSession.getRuolo());
		theModel.addAttribute("titlePage", "Nuovo Candidato");
		theModel.addAttribute("view", "nuovoCandidato");
		/**
		 * nome del tempate da usare (default/login)
		 */
		return "default";
	}
	
}