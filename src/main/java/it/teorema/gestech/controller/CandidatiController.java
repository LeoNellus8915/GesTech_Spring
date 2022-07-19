package it.teorema.gestech.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import it.teorema.gestech.service.DettagliRisorseService;
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
	@Autowired
	DettagliRisorseService dettagliRisorseService;
	
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
	
	@RequestMapping("/aggiungi-candidato")
	@Transactional
	public String AggiungiCandidato(HttpServletRequest request, Model theModel)
	{
		Risorse risorsa = new Risorse();
		
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		LocalDateTime data = LocalDateTime.parse(format1.format(now), format1);		

		HttpSession session = request.getSession(true);
		LocalSession localSession = (LocalSession) session.getAttribute("localSession");
		
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");  

		risorsa.setNomeCognome((String) request.getParameter("nomeCognome"));
		risorsa.setRecapito((String) request.getParameter("recapito"));
		risorsa.setEmail((String) request.getParameter("email"));
		risorsa.setProfiloLinkedin((String) request.getParameter("profiloLinkedin"));
		risorsa.setCitta((String) request.getParameter("citta"));
		risorsa.setRuoloRisorsa((String) request.getParameter("ruoloProfilo"));
		risorsa.setDataColloquio(LocalDate.parse(request.getParameter("dataColloquio"), format2));
		risorsa.setAnnoColloquio((String) request.getParameter("annoColloquio"));
		risorsa.setFonteReperimento((String) request.getParameter("fonteReperimento"));
		risorsa.setCompetenzaPrincipale((String) request.getParameter("competenzaPrincipale"));
		risorsa.setCostoGiornaliero(Double.parseDouble(request.getParameter("costoGiornaliero")));
		risorsa.setPossibilitaLavorativa((String) request.getParameter("possibilitaLavorativa"));
		risorsa.setSkillCampoLibero((String) request.getParameter("skillCampoLibero"));
		risorsa.setCompetenzeTotali((String) request.getParameter("competenzeTotali"));
		risorsa.setCertificazioni((String) request.getParameter("certificazioni"));
		
		risorseService.save(risorsa);

		return "redirect:pagina-candidati";
	}
	
	@RequestMapping("/tutte-le-risorse")
	@ResponseBody
	public List<Risorse> tutteLeRisorse()
	{
		List<Risorse> risorse = risorseService.findAll();
		return risorse;
	}
}