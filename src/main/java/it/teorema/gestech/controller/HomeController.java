package it.teorema.gestech.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.teorema.gestech.model.Avvisi;
import it.teorema.gestech.service.AvvisiService;

@Controller
public class HomeController {
	@Autowired
	AvvisiService avvisi_service;
	
	@RequestMapping("/")
	public String index(Model theModel)
	{
		/**
		 * TODO controllo se loggato
		 */
		theModel.addAttribute("titlePage", "Login");
		theModel.addAttribute("msg_credenziali", "Inserisci le credenziali per accedere al sistema");
		return "index";
	}
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request, Model theModel) {
		/**
		 * passo il nome della pagina che si deve caricare
		 * i file si trovano in template/subPage
		 */
		HttpSession session = request.getSession(true);
		String nome_cognome = (String) session.getAttribute("nome_cognome");
		String ruolo = (String) session.getAttribute("ruolo");
		
		
		theModel.addAttribute("nome_cognome", nome_cognome);
		theModel.addAttribute("ruolo", ruolo);
		theModel.addAttribute("titlePage", "HOME");
		theModel.addAttribute("view", "home");
		/**
		 * nome del tempate da usare (default/login)
		 */
		return "default";
	}
	
	@RequestMapping("/salvaAvvisi")
	@Transactional
	public String salvaAvvisi(HttpServletRequest request, Model theModel)
	{
		Avvisi salva_avviso = new Avvisi();
		
		HttpSession session = request.getSession(true);
		int id_risorsa = (int) session.getAttribute("id");
		String nome_cognome = (String) session.getAttribute("nome_cognome");
		String ruolo = (String) session.getAttribute("ruolo");
		
		String input_titolo = request.getParameter("titolo");
		String input_avviso = request.getParameter("avviso");
		String[] input_ruolo = request.getParameterValues("ruolo");
		List<String> lista_ruoli = Arrays.asList(input_ruolo);
		
		salva_avviso.setTitolo(input_titolo);
		salva_avviso.setId_risorsa(id_risorsa);
		salva_avviso.setRuoli(lista_ruoli.toString());
		salva_avviso.setNote(input_avviso);
		
		avvisi_service.save(salva_avviso);
		
		theModel.addAttribute("nome_cognome", nome_cognome);
		theModel.addAttribute("ruolo", ruolo);
		theModel.addAttribute("titlePage", "HOME");
		theModel.addAttribute("view", "home");
		
		return "default";
	}
}