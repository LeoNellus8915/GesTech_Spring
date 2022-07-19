package it.teorema.gestech.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.teorema.gestech.model.EsitiColloquio;
import it.teorema.gestech.model.Linguaggi;
import it.teorema.gestech.model.Lingue;
import it.teorema.gestech.model.Livelli;
import it.teorema.gestech.model.Profili;
import it.teorema.gestech.model.Risorse;
import it.teorema.gestech.model.Ruoli;
import it.teorema.gestech.service.EsitiColloquioService;
import it.teorema.gestech.service.LinguaggiService;
import it.teorema.gestech.service.LingueService;
import it.teorema.gestech.service.LivelliService;
import it.teorema.gestech.service.ProfiliService;
import it.teorema.gestech.service.RisorseService;
import it.teorema.gestech.session.LocalSession;

@Controller
public class CandidatiController {
	@Autowired
	RisorseService risorseService;
	@Autowired
	EsitiColloquioService esitiColloquioService;
	@Autowired
	ProfiliService profiliService;
	@Autowired
	LinguaggiService linguaggiService;
	@Autowired
	LingueService lingueService;
	@Autowired
	LivelliService livelliService;
	
	@RequestMapping("/pagina-candidati")
	public String paginaCandidati(HttpServletRequest request, Model theModel){
		
		HttpSession session = request.getSession(true);
		LocalSession localSession = (LocalSession) session.getAttribute("localSession");
		
		theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
		theModel.addAttribute("ruolo", localSession.getRuolo());
		theModel.addAttribute("titlePage", "Candidati");
		theModel.addAttribute("view", "paginaCandidati");
		
		return "default";
	}
	
	@RequestMapping("/nuovo-candidato")
	@Transactional
	public String nuovoCandidato(HttpServletRequest request, Model theModel) {
		
		HttpSession session = request.getSession(true);
		LocalSession localSession = (LocalSession) session.getAttribute("localSession");
		
		List<EsitiColloquio> esitiColloquio = esitiColloquioService.findAll();
		List<Profili> profili = profiliService.findAll();
		List<Linguaggi> linguaggi = linguaggiService.findAll();
		List<Lingue> lingue = lingueService.findAll();
		List<Livelli> livelli = livelliService.findAll();

		theModel.addAttribute("livelli", livelli);
		theModel.addAttribute("lingue", lingue);
		theModel.addAttribute("linguaggi", linguaggi);
		theModel.addAttribute("profili", profili);
		theModel.addAttribute("esitiColloquio", esitiColloquio);
		theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
		theModel.addAttribute("ruolo", localSession.getRuolo());
		theModel.addAttribute("titlePage", "Nuovo Candidato");
		theModel.addAttribute("view", "nuovoCandidato");
		
		return "default";
	}
	
	@RequestMapping("/tutte-le-risorse")
	@ResponseBody
	public List tutteLeRisorse()
	{
		List<Risorse> risorse = risorseService.findAll();
		return risorse;
	}
}