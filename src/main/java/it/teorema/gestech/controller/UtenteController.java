package it.teorema.gestech.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UtenteController {
	@RequestMapping("/nuovoUtente")
	public String nuovoUtente(HttpServletRequest request, Model theModel) {
		/**
		 * passo il nome della pagina che si deve caricare
		 * i file si trovano in template/subPage
		 */
		HttpSession session = request.getSession(true);
		String nome_cognome = (String) session.getAttribute("nome_cognome");
		String ruolo = (String) session.getAttribute("ruolo");
		
		theModel.addAttribute("nome_cognome", nome_cognome);
		theModel.addAttribute("ruolo", ruolo);
		theModel.addAttribute("titlePage", "Utente");
		theModel.addAttribute("view", "nuovoUtente");
		/**
		 * nome del tempate da usare (default/login)
		 */
		return "default";
	}
}
