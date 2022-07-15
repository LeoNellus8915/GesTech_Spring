package it.teorema.gestech.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	//private String templateName = "default";
	@RequestMapping(value = "/login")
	public String showDashboardPage(HttpServletRequest request, Model theModel) {
		
		String email = request.getParameter("email");
		String password = request.getParameter("passwordMD5");
		String controllo = null;
		int id_risorsa = 0;
		
		Risorse risorsa;
		if (risorse_service.findAll(email).size() == 1)
		{
			risorsa = (Risorse) risorse_service.findAll(email).get(0);
			id_risorsa = risorsa.getId();
			controllo = "email";
		}

		if (id_risorsa != 0)
		{
			Auth auth = (Auth) auth_service.findAll(id_risorsa).get(0);
			if (password.equals(auth.getPassword()))
				controllo = controllo.concat(" password");
		}
	
		if (controllo.equals("email password"))
			return "redirect:home";
		else
			return "index";
			
		/**
		 * Todo verifica se la login è giusta
		 * si redirect home
		 * no page login con messaggio di errore 
		 * 
		 * return index;
		 */
	}
}