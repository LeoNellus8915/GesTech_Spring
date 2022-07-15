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
import it.teorema.gestech.model.Lingue;
import it.teorema.gestech.service.AuthService;
import it.teorema.gestech.service.LinguaService;
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
		int prova = 0;
		int id = 0;
		
		for (int c=0; c<risorse_service.findAll().size(); c++)
    	{
    		Risorse risorsa = (Risorse) risorse_service.findAll().get(c);
    		if (email.equals(risorsa.getEmail()))
    		{
    			id = risorsa.getId();
    			prova++;
    		}
    	}
		if (id != 0)
		{
			Auth auth = (Auth) auth_service.findAll(id).get(0);
			if (password.equals(auth.getPassword()))
				prova++;
		}
	
		if (prova == 2)
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