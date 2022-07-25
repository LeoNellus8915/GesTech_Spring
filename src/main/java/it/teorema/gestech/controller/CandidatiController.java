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

import it.teorema.gestech.model.Commenti;
import it.teorema.gestech.model.DettagliRisorse;
import it.teorema.gestech.model.EsitiColloquio;
import it.teorema.gestech.model.Linguaggi;
import it.teorema.gestech.model.Lingue;
import it.teorema.gestech.model.Livelli;
import it.teorema.gestech.model.Profili;
import it.teorema.gestech.model.Risorse;
import it.teorema.gestech.service.CommentiService;
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
	@Autowired
	CommentiService commentiService;
	
	@RequestMapping("/pagina-candidati")
	public String paginaCandidati(HttpServletRequest request, Model theModel){
		
		HttpSession session = request.getSession(true);
		LocalSession localSession = (LocalSession) session.getAttribute("localSession");
		
		theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
		theModel.addAttribute("ruolo", localSession.getRuolo());
		theModel.addAttribute("titlePage", "Candidati");
		theModel.addAttribute("view", "paginaCandidati");
		
		return "default"+localSession.getRuolo();
	}
	
	@RequestMapping("/pagina-nuovo-candidato")
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
		
		return "default"+localSession.getRuolo();
	}
	
	@RequestMapping("/aggiungi-candidato")
	@Transactional
	public String aggiungiCandidato(HttpServletRequest request, Model theModel)
	{
		// Controllo se il candidato è già presente
		if(risorseService.findByEmail(request.getParameter("email")) == null) {
		
			Risorse risorsa = new Risorse();
			DettagliRisorse dettagliRisorsa = new DettagliRisorse();
			Commenti commenti = new Commenti();
			Double costoGiornaliero;
		
			DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now();  
			LocalDateTime data = LocalDateTime.parse(format1.format(now), format1);	
		
			if (request.getParameter("costoGiornaliero") == "")
				costoGiornaliero = (double) 0;
			else
				costoGiornaliero = Double.parseDouble(request.getParameter("costoGiornaliero"));
	
			risorsa.setNomeCognome(request.getParameter("nomeCognome"));
			risorsa.setRecapito(request.getParameter("recapito"));
			risorsa.setEmail(request.getParameter("email"));
			risorsa.setProfiloLinkedin(request.getParameter("profiloLinkedin"));
			risorsa.setCitta(request.getParameter("citta"));
			risorsa.setDataColloquio(LocalDate.parse(request.getParameter("dataColloquio"), format2));
			risorsa.setAnnoColloquio(request.getParameter("annoColloquio"));
			risorsa.setFonteReperimento(request.getParameter("fonteReperimento"));
			risorsa.setCompetenzaPrincipale(request.getParameter("competenzaPrincipale"));
			risorsa.setCostoGiornaliero(costoGiornaliero);
			risorsa.setPossibilitaLavorativa(request.getParameter("possibilitaLavorativa"));
			risorsa.setSkillCampoLibero(request.getParameter("skillCampoLibero"));
			risorsa.setCompetenzeTotali(request.getParameter("competenzeTotali"));
			risorsa.setCertificazioni(request.getParameter("certificazioni"));
		
			risorseService.save(risorsa);
		
			int idRisorsa = risorseService.findId();	
		
			dettagliRisorsa.setDataInserimento(data);
			dettagliRisorsa.setIdEsitoColloquio(Integer.parseInt(request.getParameter("esitoColloquio")));
			dettagliRisorsa.setIdProfilo(Integer.parseInt(request.getParameter("profilo")));
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
				
			if (request.getParameter("commento") != "")
			{
				commenti.setData(LocalDate.parse(format2.format(now), format2));
				commenti.setIdRisorsa(idRisorsa);
				commenti.setNote(request.getParameter("commento"));
			
				commentiService.save(commenti);
			}
			return "redirect:pagina-candidati";
		}
		else {
			return "redirect:pagina-nuovo-candidato";
		}
	}
	
	@RequestMapping("/tutte-le-risorse")
	@ResponseBody
	public List tutteLeRisorse()
	{
		List json = dettagliRisorseService.findAll();
		return json;
	}
	
	@RequestMapping("/stampa-commenti")
	@ResponseBody
	public List stampaCommenti(@RequestParam(value="idRisorsa") int idRisorsa) 
	{
		List commenti = commentiService.stampaCommenti(idRisorsa);
		
		return commenti;
	}
	
	@RequestMapping("/visualizza-candidato")
	public String visualizzaCandidati(@RequestParam(value="idRisorsa") int idRisorsa, HttpServletRequest request, Model theModel)
	{
		HttpSession session = request.getSession(true);
		LocalSession localSession = (LocalSession) session.getAttribute("localSession");
		
		Risorse risorse = risorseService.findById(idRisorsa);
		
		theModel.addAttribute("id", risorse.getId());
		theModel.addAttribute("nomeCognomeCandidato", risorse.getNomeCognome());
		theModel.addAttribute("email", risorse.getEmail());
		theModel.addAttribute("recapito", risorse.getRecapito());
		theModel.addAttribute("citta", risorse.getCitta());
		theModel.addAttribute("dataInserimento", dettagliRisorseService.getDataInserimento(idRisorsa));
		theModel.addAttribute("competenzaPrincipale", risorse.getCompetenzaPrincipale());
		theModel.addAttribute("dataColloquio", risorse.getDataColloquio());
		theModel.addAttribute("annoColloquio", risorse.getAnnoColloquio());
		theModel.addAttribute("esitoColloquio", esitiColloquioService.getEsitoColloquio(idRisorsa));
		theModel.addAttribute("fonteReperimento", risorse.getFonteReperimento());
		theModel.addAttribute("profilo", profiliService.getProfilo(idRisorsa));
		theModel.addAttribute("costoGiornaliero", risorse.getCostoGiornaliero());
		theModel.addAttribute("possibilitaLavorativa", risorse.getPossibilitaLavorativa());
		theModel.addAttribute("skill1", linguaggiService.getSkill1(idRisorsa));
		theModel.addAttribute("skill2", linguaggiService.getSkill2(idRisorsa));
		theModel.addAttribute("skill3", linguaggiService.getSkill3(idRisorsa));
		theModel.addAttribute("skill4", linguaggiService.getSkill4(idRisorsa));
		theModel.addAttribute("skill5", linguaggiService.getSkill5(idRisorsa));
		theModel.addAttribute("lingua1", lingueService.getLingua1(idRisorsa));
		theModel.addAttribute("lingua2", lingueService.getLingua2(idRisorsa));
		theModel.addAttribute("lingua3", lingueService.getLingua3(idRisorsa));
		theModel.addAttribute("seniority", livelliService.getSeniority(idRisorsa));
		theModel.addAttribute("skillCampoLibero", risorse.getSkillCampoLibero());
		theModel.addAttribute("competenzeTotali", risorse.getCompetenzeTotali());
		theModel.addAttribute("certificazioni", risorse.getCertificazioni());
		
		theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
		theModel.addAttribute("ruolo", localSession.getRuolo());
		theModel.addAttribute("titlePage", "Visualizza Candidato");
		theModel.addAttribute("view", "visualizzaCandidato");
		
		return "default"+localSession.getRuolo();		
	}
	
	@RequestMapping("/modifica-candidato")
	public String modificaCandidati(@RequestParam(value="idRisorsa") int idRisorsa, HttpServletRequest request, Model theModel)
	{
		HttpSession session = request.getSession(true);
		LocalSession localSession = (LocalSession) session.getAttribute("localSession");
		
		Risorse risorse = risorseService.findById(idRisorsa);
		
		theModel.addAttribute("id", risorse.getId());
		theModel.addAttribute("nomeCognomeCandidato", risorse.getNomeCognome());
		theModel.addAttribute("email", risorse.getEmail());
		theModel.addAttribute("recapito", risorse.getRecapito());
		theModel.addAttribute("profiloLinkedin", risorse.getProfiloLinkedin());
		theModel.addAttribute("citta", risorse.getCitta());
		theModel.addAttribute("dataInserimento", dettagliRisorseService.getDataInserimento(idRisorsa));
		theModel.addAttribute("competenzaPrincipale", risorse.getCompetenzaPrincipale());
		theModel.addAttribute("dataColloquio", risorse.getDataColloquio());
		theModel.addAttribute("annoColloquio", risorse.getAnnoColloquio());
		theModel.addAttribute("esitoColloquio", esitiColloquioService.getEsitoColloquio(idRisorsa));
		theModel.addAttribute("fonteReperimento", risorse.getFonteReperimento());
		theModel.addAttribute("profilo", profiliService.getProfilo(idRisorsa));
		theModel.addAttribute("costoGiornaliero", risorse.getCostoGiornaliero());
		theModel.addAttribute("possibilitaLavorativa", risorse.getPossibilitaLavorativa());
		theModel.addAttribute("skill1", linguaggiService.getSkill1(idRisorsa));
		theModel.addAttribute("skill2", linguaggiService.getSkill2(idRisorsa));
		theModel.addAttribute("skill3", linguaggiService.getSkill3(idRisorsa));
		theModel.addAttribute("skill4", linguaggiService.getSkill4(idRisorsa));
		theModel.addAttribute("skill5", linguaggiService.getSkill5(idRisorsa));
		theModel.addAttribute("lingua1", lingueService.getLingua1(idRisorsa));
		theModel.addAttribute("lingua2", lingueService.getLingua2(idRisorsa));
		theModel.addAttribute("lingua3", lingueService.getLingua3(idRisorsa));
		theModel.addAttribute("livello", livelliService.getSeniority(idRisorsa));
		theModel.addAttribute("skillCampoLibero", risorse.getSkillCampoLibero());
		theModel.addAttribute("competenzeTotali", risorse.getCompetenzeTotali());
		theModel.addAttribute("certificazioni", risorse.getCertificazioni());
		
		theModel.addAttribute("esitiColloquio", esitiColloquioService.findAllException(esitiColloquioService.getEsitoColloquio(idRisorsa)));
		theModel.addAttribute("idEsitoColloquio", esitiColloquioService.findIdEsitoColloquio(esitiColloquioService.getEsitoColloquio(idRisorsa)));
		
		theModel.addAttribute("profili", profiliService.findAllException(profiliService.getProfilo(idRisorsa)));
		theModel.addAttribute("idProfilo", profiliService.findIdProfilo(profiliService.getProfilo(idRisorsa)));
		
		theModel.addAttribute("linguaggi1", linguaggiService.findAllException(linguaggiService.getSkill1(idRisorsa)));
		theModel.addAttribute("idLinguaggio1", linguaggiService.findIdSkill1(linguaggiService.getSkill1(idRisorsa)));
		
		theModel.addAttribute("linguaggi2", linguaggiService.findAllException(linguaggiService.getSkill2(idRisorsa)));
		theModel.addAttribute("idLinguaggio2", linguaggiService.findIdSkill2(linguaggiService.getSkill2(idRisorsa)));
		
		theModel.addAttribute("linguaggi3", linguaggiService.findAllException(linguaggiService.getSkill3(idRisorsa)));
		theModel.addAttribute("idLinguaggio3", linguaggiService.findIdSkill3(linguaggiService.getSkill3(idRisorsa)));
		
		theModel.addAttribute("linguaggi4", linguaggiService.findAllException(linguaggiService.getSkill4(idRisorsa)));
		theModel.addAttribute("idLinguaggio4", linguaggiService.findIdSkill4(linguaggiService.getSkill4(idRisorsa)));
		
		theModel.addAttribute("linguaggi5", linguaggiService.findAllException(linguaggiService.getSkill5(idRisorsa)));
		theModel.addAttribute("idLinguaggio5", linguaggiService.findIdSkill5(linguaggiService.getSkill5(idRisorsa)));
		
		theModel.addAttribute("lingue1", lingueService.findAllException(lingueService.getLingua1(idRisorsa)));
		theModel.addAttribute("idLingua1", lingueService.findIdLingua1(lingueService.getLingua1(idRisorsa)));
		
		theModel.addAttribute("lingue2", lingueService.findAllException(lingueService.getLingua2(idRisorsa)));
		theModel.addAttribute("idLingua2", lingueService.findIdLingua2(lingueService.getLingua2(idRisorsa)));
		
		theModel.addAttribute("lingue3", lingueService.findAllException(lingueService.getLingua3(idRisorsa)));
		theModel.addAttribute("idLingua3", lingueService.findIdLingua3(lingueService.getLingua3(idRisorsa)));
		
		theModel.addAttribute("livelli", livelliService.findAllException(livelliService.getSeniority(idRisorsa)));
		theModel.addAttribute("idLivello", livelliService.findIdProfilo(livelliService.getSeniority(idRisorsa)));
		
		theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
		theModel.addAttribute("ruolo", localSession.getRuolo());
		theModel.addAttribute("titlePage", "Modifica Candidato");
		theModel.addAttribute("view", "modificaCandidato");
		
		return "default"+localSession.getRuolo();
	}
	
	@RequestMapping("/modifica-campi-candidato")
	@Transactional
	public String modificaCampiCandidato(HttpServletRequest request, Model theModel)
	{
		HttpSession session = request.getSession(true);
		LocalSession localSession = (LocalSession) session.getAttribute("localSession");
		
		
		int idRisorsa = Integer.parseInt(request.getParameter("idRisorsa"));
		String nomeCognome = request.getParameter("nomeCognome");
		String recapito = request.getParameter("recapito");
		String profiloLinkedin = request.getParameter("profiloLinkedin");
		String citta = request.getParameter("citta");
		LocalDate dataColloquio = LocalDate.parse(request.getParameter("dataColloquio"));
		String annoColloquio = request.getParameter("annoColloquio");
		int esitoColloquio = Integer.parseInt(request.getParameter("esitoColloquio"));
		String fonteReperimento = request.getParameter("fonteReperimento");
		int profilo = Integer.parseInt(request.getParameter("ruoloRisorsa"));
		String competenzaPrincipale = request.getParameter("competenzaPrincipale");
		Double costoGiornaliero = Double.parseDouble(request.getParameter("costoGiornaliero"));
		String possibilitaLavorativa = request.getParameter("possibilitaLavorativa");
		int skill1 = Integer.parseInt(request.getParameter("skill1"));
		int skill2 = Integer.parseInt(request.getParameter("skill2"));
		int skill3 = Integer.parseInt(request.getParameter("skill3"));
		int skill4 = Integer.parseInt(request.getParameter("skill4"));
		int skill5 = Integer.parseInt(request.getParameter("skill5"));
		int lingua1 = Integer.parseInt(request.getParameter("lingua1"));
		int lingua2 = Integer.parseInt(request.getParameter("lingua2"));
		int lingua3 = Integer.parseInt(request.getParameter("lingua3"));
		String skillCampoLibero = request.getParameter("skillCampoLibero");
		String competenzeTotali = request.getParameter("competenzeTotali");
		String certificazioni = request.getParameter("certificazioni");
		int seniority = Integer.parseInt(request.getParameter("seniority"));
		
		risorseService.updateCandidato(idRisorsa, nomeCognome, recapito, profiloLinkedin, citta, dataColloquio, annoColloquio, fonteReperimento,
				competenzaPrincipale, costoGiornaliero, possibilitaLavorativa, skillCampoLibero, competenzeTotali, certificazioni);
		
		dettagliRisorseService.updateCandidato(idRisorsa, esitoColloquio, profilo, skill1, skill2, skill3, skill4, skill5, lingua1, lingua2, lingua3, seniority);
		
		Risorse risorse = risorseService.findById(idRisorsa);
		
		theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
		theModel.addAttribute("ruolo", localSession.getRuolo());
		theModel.addAttribute("titlePage", "Candidati");
		theModel.addAttribute("view", "paginaCandidati");
		
		return "default"+localSession.getRuolo();		
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
		return "default"+localSession.getRuolo();
	}
}