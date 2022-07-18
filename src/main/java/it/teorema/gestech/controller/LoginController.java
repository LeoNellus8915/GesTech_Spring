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
import it.teorema.gestech.service.AuthService;
import it.teorema.gestech.service.RisorseService;

@Controller
public class LoginController {
	
	@Autowired
	RisorseService risorse_service;
	@Autowired
	AuthService auth_service;
	
	@RequestMapping("/logout")
	public String index()
	{
		return "index";
	}
	@RequestMapping("/login")
	public String showDashboardPage(HttpServletRequest request, Model theModel) {
		
		String email = request.getParameter("email");
		String password = request.getParameter("passwordMD5");
		String controllo = "";
		List service = risorse_service.findAll(email);
		int id_risorsa = 0;
		
		String nome_cognome = null;
		String ruolo = null;
		
		if (service.size() == 1)
		{
			Risorse risorsa = (Risorse) service.get(0);
			id_risorsa = risorsa.getId();
			nome_cognome = risorsa.getNome_cognome();
			ruolo = risorsa.getRuolo_risorsa();
			controllo = "email";
		}
		
		

		if (id_risorsa != 0)
		{
			Auth auth = (Auth) auth_service.findAll(id_risorsa).get(0);
			if (password.equals(auth.getPassword()))
				controllo = controllo.concat(" password");
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("id", id_risorsa);
		session.setAttribute("nome_cognome", nome_cognome);
		session.setAttribute("ruolo", ruolo);
	
		if (controllo.equals("email password"))
			return "redirect:home";
		else
		{
			theModel.addAttribute("msg_credenziali", "Credenziali errate, si prega di riprovare");
			theModel.addAttribute("titlePage", "Login");
			return "index";
		}
			
		/**
		 * Todo verifica se la login è giusta
		 * si redirect home
		 * no page login con messaggio di errore 
		 * 
		 * return index;
		 */
	}
}