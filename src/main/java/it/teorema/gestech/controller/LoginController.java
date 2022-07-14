package it.teorema.gestech.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	private String templateName = "default";


	@RequestMapping(value = "/login")
	public String showDashboardPage(HttpServletRequest request, Model theModel) {
		
		String password = request.getParameter("passwordMD5");
		System.out.println("PASSWORD ----> " + password);		
		/**
		 * Todo verifica se la login è giusta
		 * si redirect home
		 * no page login con messaggio di errore 
		 * 
		 * return index;
		 */
		return "redirect:home";
	}
	
}
