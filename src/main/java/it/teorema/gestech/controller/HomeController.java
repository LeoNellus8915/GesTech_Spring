package it.teorema.gestech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	private String templateName = "default";
	
	@RequestMapping("/")
	public String index(Model theModel)
	{
		/**
		 * TODO controllo se loggato
		 */
		theModel.addAttribute("titlePage", "Login");
		return "index";
	}
	
	@RequestMapping("/home")
	public String home(Model theModel) {
		/**
		 * passo il nome della pagina che si deve caricare
		 * i file si trovano in template/subPage
		 */
		theModel.addAttribute("titlePage", "HOME");
		theModel.addAttribute("view", "home");
		/**
		 * nome del tempate da usare (default/login)
		 */
		return templateName;
	}
}
