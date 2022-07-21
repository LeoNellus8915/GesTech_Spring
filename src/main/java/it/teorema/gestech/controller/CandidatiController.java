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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.teorema.gestech.model.DettagliRisorse;
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
	public String aggiungiCandidato(HttpServletRequest request, Model theModel)
	{
		Risorse risorsa = new Risorse();
		DettagliRisorse dettagliRisorsa = new DettagliRisorse();
		
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();  
		LocalDateTime data = LocalDateTime.parse(format1.format(now), format1);	
	
		risorsa.setNomeCognome(request.getParameter("nomeCognome"));
		risorsa.setRecapito(request.getParameter("recapito"));
		risorsa.setEmail(request.getParameter("email"));
		risorsa.setProfiloLinkedin(request.getParameter("profiloLinkedin"));
		risorsa.setCitta(request.getParameter("citta"));
		risorsa.setRuoloRisorsa(request.getParameter("ruoloProfilo"));
		risorsa.setDataColloquio(LocalDate.parse(request.getParameter("dataColloquio"), format2));
		risorsa.setAnnoColloquio(request.getParameter("annoColloquio"));
		risorsa.setFonteReperimento(request.getParameter("fonteReperimento"));
		risorsa.setCompetenzaPrincipale(request.getParameter("competenzaPrincipale"));
		risorsa.setCostoGiornaliero(Double.parseDouble(request.getParameter("costoGiornaliero")));
		risorsa.setPossibilitaLavorativa(request.getParameter("possibilitaLavorativa"));
		risorsa.setSkillCampoLibero(request.getParameter("skillCampoLibero"));
		risorsa.setCompetenzeTotali(request.getParameter("competenzeTotali"));
		risorsa.setCertificazioni(request.getParameter("certificazioni"));
		
		risorseService.save(risorsa);
		
		int idRisorsa = risorseService.findId();	
		
		dettagliRisorsa.setDataInserimento(data);
		dettagliRisorsa.setIdEsitoColloquio(Integer.parseInt(request.getParameter("esitoColloquio")));
		dettagliRisorsa.setIdLingua1(Integer.parseInt(request.getParameter("lingua1")));
		dettagliRisorsa.setIdLingua2(Integer.parseInt(request.getParameter("lingua2")));
		dettagliRisorsa.setIdLingua3(Integer.parseInt(request.getParameter("lingua3")));
		dettagliRisorsa.setIdRisorsa(idRisorsa);
		dettagliRisorsa.setIdSeniority(Integer.parseInt(request.getParameter("seniority")));
		dettagliRisorsa.setIdSkill1(Integer.parseInt(request.getParameter("skill1")));
		dettagliRisorsa.setIdSkill2(Integer.parseInt(request.getParameter("skill2")));
		dettagliRisorsa.setIdSkill3(Integer.parseInt(request.getParameter("skill3")));
		dettagliRisorsa.setIdSkill4(Integer.parseInt(request.getParameter("skill4")));
		dettagliRisorsa.setIdSkill5(Integer.parseInt(request.getParameter("skill5")));
		
		dettagliRisorseService.save(dettagliRisorsa);

		return "redirect:pagina-candidati";
	}
	
	@RequestMapping("/tutte-le-risorse")
	@ResponseBody
	public List tutteLeRisorse()
	{
		List json = dettagliRisorseService.findAll();
		return json;
	}
	
	@RequestMapping("/visualizza-candidato")
	public String visualizzaCandidati(@RequestParam(value="idRisorsa") int idRisorsa, HttpServletRequest request, Model theModel)
	{
		
		HttpSession session = request.getSession(true);
		LocalSession localSession = (LocalSession) session.getAttribute("localSession");
		
		Risorse risorse = risorseService.findById(idRisorsa);
		
		theModel.addAttribute("id", risorse.getId());
		theModel.addAttribute("email", risorse.getEmail());
		theModel.addAttribute("recapito", risorse.getRecapito());
		theModel.addAttribute("citta", risorse.getCitta());
		theModel.addAttribute("dataInserimento", risorse.getDataInserimento());
		theModel.addAttribute("competenzaPrincipale", risorse.getCompetenzaPrincipale());
		theModel.addAttribute("dataColloquio", risorse.getDataColloquio());
		theModel.addAttribute("annoColloquio", risorse.getAnnoColloquio());
		//theModel.addAttribute("esitoColloquio", risorse.getEsitoColloquio());
		theModel.addAttribute("fonteReperimento", risorse.getFonteReperimento());
		theModel.addAttribute("costoGiornaliero", risorse.getCostoGiornaliero());
		theModel.addAttribute("possibilitaLavorativa", risorse.getPossibilitaLavorativa());
		theModel.addAttribute("competenzeTotali", risorse.getCompetenzeTotali());
		theModel.addAttribute("certificazioni", risorse.getCertificazioni());
		
		theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
		theModel.addAttribute("ruolo", localSession.getRuolo());
		theModel.addAttribute("titlePage", "Visualizza Candidato");
		theModel.addAttribute("view", "visualizzaCandidato");
		
		return "default";
		
		
	}
	
	@RequestMapping("/modifica-candidato")
	public String modificaCandidati(@RequestParam(value="idRisorsa") int idRisorsa, HttpServletRequest request, Model theModel)
	{
		
		HttpSession session = request.getSession(true);
		LocalSession localSession = (LocalSession) session.getAttribute("localSession");
		
		//Risorse risorse = new Risorse();
		
		theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
		theModel.addAttribute("ruolo", localSession.getRuolo());
		theModel.addAttribute("titlePage", "Modifica Candidato");
		theModel.addAttribute("view", "modificaCandidato");
		
		return "default";
	}
	
	@RequestMapping("/elimina-candidato")
	@Transactional
	public String eliminaCandidato(@RequestParam(value="idRisorsa") int idRisorsa, HttpServletRequest request, Model theModel)
	{
		HttpSession session = request.getSession(true);
		LocalSession localSession = (LocalSession) session.getAttribute("localSession");
		
		dettagliRisorseService.rimuoviCandidato(idRisorsa);
		risorseService.rimuoviCandidato(idRisorsa);
		
		theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
		theModel.addAttribute("ruolo", localSession.getRuolo());
		theModel.addAttribute("titlePage", "Candidati");
		theModel.addAttribute("view", "paginaCandidati");
		return "default";
	}
}