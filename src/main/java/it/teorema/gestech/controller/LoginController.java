package it.teorema.gestech.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.model.Auth;
import it.teorema.gestech.model.Risorse;
import it.teorema.gestech.model.RuoliRisorse;
import it.teorema.gestech.service.AuthService;
import it.teorema.gestech.service.RisorseService;
import it.teorema.gestech.service.RuoliRisorseService;
import it.teorema.gestech.service.RuoliService;
import it.teorema.gestech.session.LocalSession;

@Controller
public class LoginController {
	
	@Autowired
	RisorseService risorseService;
	@Autowired
	AuthService authService;
	@Autowired
	RuoliRisorseService ruoliRisorseService;
	@Autowired
	RuoliService ruoliService;
	
	@RequestMapping("/logout")
	public String index(HttpServletRequest request, Model theModel)
	{
		HttpSession session = request.getSession(true);
		theModel.addAttribute("msgCredenziali", "Credenziali errate, si prega di riprovare");
		theModel.addAttribute("titlePage", "Login");
		session.invalidate();
		return "index";
	}
	
	@RequestMapping("/login")
	public String showDashboardPage(HttpServletRequest request, Model theModel) {
		
		String email = request.getParameter("email");
		String password = request.getParameter("passwordMD5");
		String controllo = "";
		Risorse risorsa = risorseService.findAll(email);
		int idRisorsa = 0;
		String nomeCognome = null;
		String ruolo = null;
		LocalSession localSession = new LocalSession();
		
		if (risorsa != null)
		{
			idRisorsa = risorsa.getId();
			
			List<RuoliRisorse> listIdRuolo = ruoliRisorseService.findIdRuolo(idRisorsa);
			RuoliRisorse ruoliRisorsa = (RuoliRisorse) listIdRuolo.get(0);
			int idRuoloRisorsa = ruoliRisorsa.getIdRuolo();
			
			
			String ruoloRisorsa = ruoliService.findRuolo(idRuoloRisorsa);
			ruolo = ruoloRisorsa;
			nomeCognome = risorsa.getNomeCognome();
			controllo = "email";
		}
		
		if (idRisorsa != 0)
		{
			Auth auth = (Auth) authService.findAll(idRisorsa);
			if (password.equals(auth.getPassword()))
				controllo = controllo.concat(" password");
		}
	
		if (controllo.equals("email password")) 
		{
			localSession.setNomeCognome(nomeCognome);
			localSession.setRuolo(ruolo);
			localSession.setIdRisorsa(idRisorsa);
			HttpSession session = request.getSession(true);
			session.setAttribute("localSession", localSession);
			session.setAttribute("idSessione", 1);
			return "redirect:/home";
		}
		else
		{
			theModel.addAttribute("msgCredenziali", "Credenziali errate, si prega di riprovare");
			theModel.addAttribute("titlePage", "Login");
			return "index";
		}
	}
}