package it.teorema.gestech.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.session.LocalSession;

@Controller
public class AmministrazioneController {
	
	@RequestMapping("pagina-buste-paga")
	public String bustePaga(HttpServletRequest request, Model theModel)
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
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Buste Paga");
			theModel.addAttribute("view", "paginaBustePaga");
			
			return "default"+localSession.getRuolo();
		}
	}
	
	@RequestMapping("pagina-certificazione-unica")
	public String certificazioneUnica(HttpServletRequest request, Model theModel)
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
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Certificazione Unica");
			theModel.addAttribute("view", "paginaCertificazioneUnica");
			
			return "default"+localSession.getRuolo();
		}
	}
}
