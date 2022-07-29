package it.teorema.gestech.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.teorema.gestech.model.CommentiRisorse;
import it.teorema.gestech.model.DettagliRisorse;
import it.teorema.gestech.model.EsitiColloquio;
import it.teorema.gestech.model.Linguaggi;
import it.teorema.gestech.model.Lingue;
import it.teorema.gestech.model.Livelli;
import it.teorema.gestech.model.Profili;
import it.teorema.gestech.model.ResponseWrapper;
import it.teorema.gestech.model.Risorse;
import it.teorema.gestech.service.CommentiRisorseService;
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
	CommentiRisorseService commentiRisorseService;
	
	@RequestMapping("/pagina-candidati")
	public String paginaCandidati(HttpServletRequest request, Model theModel){
		HttpSession session = request.getSession(true);
		if (session.getAttribute("idSessione") == null)
		{
			theModel.addAttribute("titlePage", "Login");
			theModel.addAttribute("msgCredenziali", "Inserisci le credenziali per accedere al sistema");
			return "index";
		}
		else
		{
			LocalSession localSession = (LocalSession) session.getAttribute("localSession");
			
			List listaCandidati = dettagliRisorseService.findAll();

			theModel.addAttribute("candidati", listaCandidati);
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Candidati");
			theModel.addAttribute("path", "candidati/");
			theModel.addAttribute("view", "paginaCandidati");
			
			return "default"+localSession.getRuolo();
		}
	}
	
	@RequestMapping("/pagina-nuovo-candidato")
	@Transactional
	public String nuovoCandidato(HttpServletRequest request, Model theModel) {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("idSessione") == null)
		{
			theModel.addAttribute("titlePage", "Login");
			theModel.addAttribute("msgCredenziali", "Inserisci le credenziali per accedere al sistema");
			return "index";
		}
		else
		{
			LocalSession localSession = (LocalSession) session.getAttribute("localSession");
			
			Risorse risorsa = new Risorse();
			DettagliRisorse dettagliRisorsa = new DettagliRisorse();
			CommentiRisorse commentiRisorse = new CommentiRisorse();
			
			List<EsitiColloquio> esitiColloquio = esitiColloquioService.findAll();
			List<Profili> profili = profiliService.findAll();
			List<Linguaggi> linguaggi = linguaggiService.findAll();
			List<Lingue> lingue = lingueService.findAll();
			List<Livelli> livelli = livelliService.findAll();
	
			theModel.addAttribute("risorsa", risorsa);
			theModel.addAttribute("dettagliRisorsa", dettagliRisorsa);
			theModel.addAttribute("commenti", commentiRisorse);
			theModel.addAttribute("livelli", livelli);
			theModel.addAttribute("lingue1", lingue);
			theModel.addAttribute("lingue2", lingue);
			theModel.addAttribute("lingue3", lingue);
			theModel.addAttribute("linguaggi1", linguaggi);
			theModel.addAttribute("linguaggi2", linguaggi);
			theModel.addAttribute("linguaggi3", linguaggi);
			theModel.addAttribute("linguaggi4", linguaggi);
			theModel.addAttribute("linguaggi5", linguaggi);
			theModel.addAttribute("profili", profili);
			theModel.addAttribute("esitiColloquio", esitiColloquio);
			theModel.addAttribute("esitoColloquio", "Selezionare...");
			theModel.addAttribute("profilo", "Selezionare...");
			theModel.addAttribute("skill1", "Selezionare...");
			theModel.addAttribute("skill2", "Selezionare...");
			theModel.addAttribute("skill3", "Selezionare...");
			theModel.addAttribute("skill4", "Selezionare...");
			theModel.addAttribute("skill5", "Selezionare...");
			theModel.addAttribute("lingua1", "Selezionare...");
			theModel.addAttribute("lingua2", "Selezionare...");
			theModel.addAttribute("lingua3", "Selezionare...");
			theModel.addAttribute("seniority", "Selezionare...");
			theModel.addAttribute("errore", "");
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Nuovo Candidato");
			theModel.addAttribute("path", "candidati/");
			theModel.addAttribute("view", "nuovoCandidato");
			
			return "default"+localSession.getRuolo();
		}
	}
	
	@RequestMapping("/aggiungi-candidato")
	@Transactional
	public String aggiungiCandidato(HttpServletRequest request, Model theModel)
	{
		HttpSession session = request.getSession(true);
		if (session.getAttribute("idSessione") == null)
		{
			theModel.addAttribute("titlePage", "Login");
			theModel.addAttribute("msgCredenziali", "Inserisci le credenziali per accedere al sistema");
			return "index";
		}
		else
		{
			LocalSession localSession = (LocalSession) session.getAttribute("localSession");
			Risorse risorsa = new Risorse();
			DettagliRisorse dettagliRisorsa = new DettagliRisorse();
			CommentiRisorse commentiRisorse = new CommentiRisorse();
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
		
			if(risorseService.findByEmail(request.getParameter("email")) == null) {
				risorseService.save(risorsa);
				int idRisorsa = risorseService.findIdByMail(risorsa.getEmail());	

				dettagliRisorsa.setDataInserimento(data);
				dettagliRisorsa.setFileBase64(request.getParameter("base64"));
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
				
				if (request.getParameter("commento") != "")
				{
					commentiRisorse.setData(LocalDate.parse(format2.format(now), format2));
					commentiRisorse.setIdRisorsa(idRisorsa);
					commentiRisorse.setNote(request.getParameter("commento"));
				}
				dettagliRisorseService.save(dettagliRisorsa);
	
				if(commentiRisorse.getNote().equals(null))
					commentiRisorseService.save(commentiRisorse);
				
				return "redirect:/pagina-candidati";
			}
			else {
				List<EsitiColloquio> esitiColloquio = new ArrayList<EsitiColloquio>();
				List<Profili> profili = new ArrayList<Profili>();
				List<Linguaggi> linguaggi1 = new ArrayList<Linguaggi>();
				List<Linguaggi> linguaggi2 = new ArrayList<Linguaggi>();
				List<Linguaggi> linguaggi3 = new ArrayList<Linguaggi>();
				List<Linguaggi> linguaggi4 = new ArrayList<Linguaggi>();
				List<Linguaggi> linguaggi5 = new ArrayList<Linguaggi>();
				List<Lingue> lingue1 = new ArrayList<Lingue>();
				List<Lingue> lingue2 = new ArrayList<Lingue>();
				List<Lingue> lingue3 = new ArrayList<Lingue>();
				List<Livelli> livelli = new ArrayList<Livelli>();
				
				
				if(dettagliRisorsa.getIdEsitoColloquio()!=11) {
					esitiColloquio = esitiColloquioService.findAllException(esitiColloquioService.getEsitoColloquioNonSalvato(dettagliRisorsa.getIdEsitoColloquio()));
					theModel.addAttribute("esitoColloquio", esitiColloquioService.getEsitoColloquioNonSalvato(dettagliRisorsa.getIdEsitoColloquio()));
				}
				else {
					esitiColloquio = esitiColloquioService.findAll();
					theModel.addAttribute("esitoColloquio", "Selezionare...");
				}
					
				if(dettagliRisorsa.getIdProfilo()!=17) {
					profili = profiliService.findAllException(profiliService.getProfiloNonSalvato(dettagliRisorsa.getIdProfilo()));
					theModel.addAttribute("profilo", profiliService.getProfiloNonSalvato(dettagliRisorsa.getIdProfilo()));
				}
				else {
					profili = profiliService.findAll();
					theModel.addAttribute("profilo", "Selezionare...");
				}
				
				if(dettagliRisorsa.getIdSkill1()!=0) {
					linguaggi1 = linguaggiService.findAllException(linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill1()));
					theModel.addAttribute("skill1", linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill1()));
				}
				else {
					linguaggi1 = linguaggiService.findAll();
					theModel.addAttribute("skill1", "Selezionare...");
				}
				if(dettagliRisorsa.getIdSkill2()!=0) {
					linguaggi2 = linguaggiService.findAllException(linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill2()));
					theModel.addAttribute("skill2", linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill2()));
				}
				else {
					linguaggi2 = linguaggiService.findAll();
					theModel.addAttribute("skill2", "Selezionare...");
				}
				if(dettagliRisorsa.getIdSkill3()!=0) {
					linguaggi3 = linguaggiService.findAllException(linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill3()));
					theModel.addAttribute("skill3", linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill3()));
				}
				else {
					linguaggi3 = linguaggiService.findAll();
					theModel.addAttribute("skill3", "Selezionare...");
				}
				if(dettagliRisorsa.getIdSkill4()!=0) {
					linguaggi4 = linguaggiService.findAllException(linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill4()));
					theModel.addAttribute("skill4", linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill4()));
				}
				else {
					linguaggi4 = linguaggiService.findAll();
					theModel.addAttribute("skill4", "Selezionare...");
				}
				if(dettagliRisorsa.getIdSkill5()!=0) {
					linguaggi5 = linguaggiService.findAllException(linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill5()));
					theModel.addAttribute("skill5", linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill5()));
				}
				else {
					linguaggi5 = linguaggiService.findAll();
					theModel.addAttribute("skill5", "Selezionare...");
				}
				
				if(dettagliRisorsa.getIdLingua1()!=0) {
					lingue1 = lingueService.findAllException(lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua1()));
					theModel.addAttribute("lingua1", lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua1()));
				}
				else {
					lingue1 = lingueService.findAll();
					theModel.addAttribute("lingua1", "Selezionare...");
				}
				if(dettagliRisorsa.getIdLingua2()!=0) {
					lingue2 = lingueService.findAllException(lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua2()));
					theModel.addAttribute("lingua2", lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua2()));
				}
				else {
					lingue2 = lingueService.findAll();
					theModel.addAttribute("lingua2", "Selezionare...");
				}
				if(dettagliRisorsa.getIdLingua3()!=0) {
					lingue3 = lingueService.findAllException(lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua3()));
					theModel.addAttribute("lingua3", lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua3()));
				}
				else {
					lingue3 = lingueService.findAll();
					theModel.addAttribute("lingua3", "Selezionare...");
				}
				
				if(dettagliRisorsa.getIdSeniority()!=0) {
					livelli = livelliService.findAllException(livelliService.getSeniorityNonSalvato(dettagliRisorsa.getIdSeniority()));
					theModel.addAttribute("seniority", livelliService.getSeniorityNonSalvato(dettagliRisorsa.getIdSeniority()));
				}
				else {
					livelli = livelliService.findAll();
					theModel.addAttribute("seniority", "Selezionare...");
				}

				
				theModel.addAttribute("risorsa", risorsa);
				theModel.addAttribute("dettagliRisorsa", dettagliRisorsa);
				theModel.addAttribute("commenti", commentiRisorse);
				theModel.addAttribute("errore", "Candidato già presente");
				theModel.addAttribute("livelli", livelli);
				theModel.addAttribute("lingue1", lingue1);
				theModel.addAttribute("lingue2", lingue2);
				theModel.addAttribute("lingue3", lingue3);
				theModel.addAttribute("linguaggi1", linguaggi1);
				theModel.addAttribute("linguaggi2", linguaggi2);
				theModel.addAttribute("linguaggi3", linguaggi3);
				theModel.addAttribute("linguaggi4", linguaggi4);
				theModel.addAttribute("linguaggi5", linguaggi5);
				theModel.addAttribute("profili", profili);
				theModel.addAttribute("esitiColloquio", esitiColloquio);
				
				theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
				theModel.addAttribute("ruolo", localSession.getRuolo());
				theModel.addAttribute("titlePage", "Nuovo Candidato");
				theModel.addAttribute("path", "candidati/");
				theModel.addAttribute("view", "nuovoCandidato");
				
				return "default"+localSession.getRuolo();
			}
		}
	}
	
	@RequestMapping("/stampa-commenti")
	@ResponseBody
	public List stampaComment(@RequestParam(value="idRisorsa") int idRisorsa) 
	{
		List commenti = commentiRisorseService.stampaCommenti(idRisorsa);
		
		return commenti;
	}
	
	@RequestMapping("visualizza-candidato/{idRisorsa}")
	public String visualizzaCandidato(@PathVariable int idRisorsa, HttpServletRequest request, Model theModel)
	{
		HttpSession session = request.getSession(true);
		if (session.getAttribute("idSessione") == null)
		{
			theModel.addAttribute("titlePage", "Login");
			theModel.addAttribute("msgCredenziali", "Inserisci le credenziali per accedere al sistema");
			return "index";
		}
		else
		{
			LocalSession localSession = (LocalSession) session.getAttribute("localSession");
			
			Risorse risorse = risorseService.findById(idRisorsa);
			
			theModel.addAttribute("risorse", risorse);
			
			theModel.addAttribute("id", idRisorsa);
			
			theModel.addAttribute("dataInserimento", dettagliRisorseService.getDataInserimento(idRisorsa));
			theModel.addAttribute("esitoColloquio", esitiColloquioService.getEsitoColloquio(idRisorsa));
			theModel.addAttribute("profilo", profiliService.getProfilo(idRisorsa));
			theModel.addAttribute("skill1", linguaggiService.getSkill1(idRisorsa));
			theModel.addAttribute("skill2", linguaggiService.getSkill2(idRisorsa));
			theModel.addAttribute("skill3", linguaggiService.getSkill3(idRisorsa));
			theModel.addAttribute("skill4", linguaggiService.getSkill4(idRisorsa));
			theModel.addAttribute("skill5", linguaggiService.getSkill5(idRisorsa));
			theModel.addAttribute("lingua1", lingueService.getLingua1(idRisorsa));
			theModel.addAttribute("lingua2", lingueService.getLingua2(idRisorsa));
			theModel.addAttribute("lingua3", lingueService.getLingua3(idRisorsa));
			theModel.addAttribute("seniority", livelliService.getSeniority(idRisorsa));
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Visualizza Candidato");
			theModel.addAttribute("path", "candidati/");
			theModel.addAttribute("view", "visualizzaCandidato");
			
			return "default"+localSession.getRuolo();
		}
	}
	
	@RequestMapping("modifica-candidato/{idRisorsa}")
	public String modifcaCandidato(@PathVariable int idRisorsa, HttpServletRequest request, Model theModel)
	{
		HttpSession session = request.getSession(true);
		if (session.getAttribute("idSessione") == null)
		{
			theModel.addAttribute("titlePage", "Login");
			theModel.addAttribute("msgCredenziali", "Inserisci le credenziali per accedere al sistema");
			return "index";
		}
		else
		{
			LocalSession localSession = (LocalSession) session.getAttribute("localSession");
			Risorse risorsa = risorseService.findById(idRisorsa);
			DettagliRisorse dettagliRisorsa = dettagliRisorseService.findById(idRisorsa);
			
			List<EsitiColloquio> esitiColloquio = new ArrayList<EsitiColloquio>();
			List<Profili> profili = new ArrayList<Profili>();
			List<Linguaggi> linguaggi1 = new ArrayList<Linguaggi>();
			List<Linguaggi> linguaggi2 = new ArrayList<Linguaggi>();
			List<Linguaggi> linguaggi3 = new ArrayList<Linguaggi>();
			List<Linguaggi> linguaggi4 = new ArrayList<Linguaggi>();
			List<Linguaggi> linguaggi5 = new ArrayList<Linguaggi>();
			List<Lingue> lingue1 = new ArrayList<Lingue>();
			List<Lingue> lingue2 = new ArrayList<Lingue>();
			List<Lingue> lingue3 = new ArrayList<Lingue>();
			List<Livelli> livelli = new ArrayList<Livelli>();
			
			
			if(dettagliRisorsa.getIdEsitoColloquio()!=11) {
				esitiColloquio = esitiColloquioService.findAllException(esitiColloquioService.getEsitoColloquioNonSalvato(dettagliRisorsa.getIdEsitoColloquio()));
				theModel.addAttribute("esitoColloquio", esitiColloquioService.getEsitoColloquioNonSalvato(dettagliRisorsa.getIdEsitoColloquio()));
				System.out.println("Esito Colloquio ----"+esitiColloquioService.getEsitoColloquioNonSalvato(dettagliRisorsa.getIdEsitoColloquio()));
			}
			else {
				esitiColloquio = esitiColloquioService.findAll();
				theModel.addAttribute("esitoColloquio", "Selezionare...");
			}
				
			if(dettagliRisorsa.getIdProfilo()!=17) {
				profili = profiliService.findAllException(profiliService.getProfiloNonSalvato(dettagliRisorsa.getIdProfilo()));
				theModel.addAttribute("profilo", profiliService.getProfiloNonSalvato(dettagliRisorsa.getIdProfilo()));
			}
			else {
				profili = profiliService.findAll();
				theModel.addAttribute("profilo", "Selezionare...");
			}
			
			if(dettagliRisorsa.getIdSkill1()!=0) {
				linguaggi1 = linguaggiService.findAllException(linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill1()));
				theModel.addAttribute("skill1", linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill1()));
			}
			else {
				linguaggi1 = linguaggiService.findAll();
				theModel.addAttribute("skill1", "Selezionare...");
			}
			if(dettagliRisorsa.getIdSkill2()!=0) {
				linguaggi2 = linguaggiService.findAllException(linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill2()));
				theModel.addAttribute("skill2", linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill2()));
			}
			else {
				linguaggi2 = linguaggiService.findAll();
				theModel.addAttribute("skill2", "Selezionare...");
			}
			if(dettagliRisorsa.getIdSkill3()!=0) {
				linguaggi3 = linguaggiService.findAllException(linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill3()));
				theModel.addAttribute("skill3", linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill3()));
			}
			else {
				linguaggi3 = linguaggiService.findAll();
				theModel.addAttribute("skill3", "Selezionare...");
			}
			if(dettagliRisorsa.getIdSkill4()!=0) {
				linguaggi4 = linguaggiService.findAllException(linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill4()));
				theModel.addAttribute("skill4", linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill4()));
			}
			else {
				linguaggi4 = linguaggiService.findAll();
				theModel.addAttribute("skill4", "Selezionare...");
			}
			if(dettagliRisorsa.getIdSkill5()!=0) {
				linguaggi5 = linguaggiService.findAllException(linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill5()));
				theModel.addAttribute("skill5", linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill5()));
			}
			else {
				linguaggi5 = linguaggiService.findAll();
				theModel.addAttribute("skill5", "Selezionare...");
			}
			
			if(dettagliRisorsa.getIdLingua1()!=0) {
				lingue1 = lingueService.findAllException(lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua1()));
				theModel.addAttribute("lingua1", lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua1()));
			}
			else {
				lingue1 = lingueService.findAll();
				theModel.addAttribute("lingua1", "Selezionare...");
			}
			if(dettagliRisorsa.getIdLingua2()!=0) {
				lingue2 = lingueService.findAllException(lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua2()));
				theModel.addAttribute("lingua2", lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua2()));
			}
			else {
				lingue2 = lingueService.findAll();
				theModel.addAttribute("lingua2", "Selezionare...");
			}
			if(dettagliRisorsa.getIdLingua3()!=0) {
				lingue3 = lingueService.findAllException(lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua3()));
				theModel.addAttribute("lingua3", lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua3()));
			}
			else {
				lingue3 = lingueService.findAll();
				theModel.addAttribute("lingua3", "Selezionare...");
			}
			
			if(dettagliRisorsa.getIdSeniority()!=0) {
				livelli = livelliService.findAllException(livelliService.getSeniorityNonSalvato(dettagliRisorsa.getIdSeniority()));
				theModel.addAttribute("seniority", livelliService.getSeniorityNonSalvato(dettagliRisorsa.getIdSeniority()));
			}
			else {
				livelli = livelliService.findAll();
				theModel.addAttribute("seniority", "Selezionare...");
			}

			theModel.addAttribute("risorsa", risorsa);
			theModel.addAttribute("dettagliRisorsa", dettagliRisorsa);
			theModel.addAttribute("livelli", livelli);
			theModel.addAttribute("lingue1", lingue1);
			theModel.addAttribute("lingue2", lingue2);
			theModel.addAttribute("lingue3", lingue3);
			theModel.addAttribute("linguaggi1", linguaggi1);
			theModel.addAttribute("linguaggi2", linguaggi2);
			theModel.addAttribute("linguaggi3", linguaggi3);
			theModel.addAttribute("linguaggi4", linguaggi4);
			theModel.addAttribute("linguaggi5", linguaggi5);
			theModel.addAttribute("profili", profili);
			theModel.addAttribute("esitiColloquio", esitiColloquio);
			theModel.addAttribute("errore", "");
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Modifica Candidato");
			theModel.addAttribute("path", "candidati/");
			theModel.addAttribute("view", "modificaCandidato");
			
			return "default"+localSession.getRuolo();
		}
	}
	
	@RequestMapping("/modifica-campi-candidato")
	@Transactional
	public String ModificaCampiCandidato(HttpServletRequest request, Model theModel)
	{
		HttpSession session = request.getSession(true);
		if (session.getAttribute("idSessione") == null)
		{
			theModel.addAttribute("titlePage", "Login");
			theModel.addAttribute("msgCredenziali", "Inserisci le credenziali per accedere al sistema");
			return "index";
		}
		else
		{
			LocalSession localSession = (LocalSession) session.getAttribute("localSession");
			
			int idRisorsa = Integer.parseInt(request.getParameter("idRisorsa"));
			String nomeCognome = request.getParameter("nomeCognome");
			String recapito = request.getParameter("recapito");
			String email = request.getParameter("email");
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
			

			theModel.addAttribute("errore", "Email inserita già presente, si prega di inserirne una nuova");
			if(risorseService.findByEmail(email)==null  || risorseService.findByEmail(email).equals(risorseService.findEmailById(idRisorsa))) 
			{
				risorseService.updateCandidato(idRisorsa, nomeCognome, recapito, email, profiloLinkedin, citta, dataColloquio, annoColloquio, fonteReperimento,
					competenzaPrincipale, costoGiornaliero, possibilitaLavorativa, skillCampoLibero, competenzeTotali, certificazioni);
			
				dettagliRisorseService.updateCandidato(idRisorsa, esitoColloquio, profilo, skill1, skill2, skill3, skill4, skill5, lingua1, lingua2, lingua3, seniority);
				theModel.addAttribute("errore", "");
			}
			Risorse risorsa = risorseService.findById(idRisorsa);
			theModel.addAttribute("risorsa", risorsa);
			DettagliRisorse dettagliRisorsa = dettagliRisorseService.findById(idRisorsa);
			theModel.addAttribute("dettagliRisorsa", dettagliRisorsa);
			
			List<EsitiColloquio> esitiColloquio = new ArrayList<EsitiColloquio>();
			List<Profili> profili = new ArrayList<Profili>();
			List<Linguaggi> linguaggi1 = new ArrayList<Linguaggi>();
			List<Linguaggi> linguaggi2 = new ArrayList<Linguaggi>();
			List<Linguaggi> linguaggi3 = new ArrayList<Linguaggi>();
			List<Linguaggi> linguaggi4 = new ArrayList<Linguaggi>();
			List<Linguaggi> linguaggi5 = new ArrayList<Linguaggi>();
			List<Lingue> lingue1 = new ArrayList<Lingue>();
			List<Lingue> lingue2 = new ArrayList<Lingue>();
			List<Lingue> lingue3 = new ArrayList<Lingue>();
			List<Livelli> livelli = new ArrayList<Livelli>();
			
			if(dettagliRisorsa.getIdEsitoColloquio()!=11) {
				esitiColloquio = esitiColloquioService.findAllException(esitiColloquioService.getEsitoColloquioNonSalvato(dettagliRisorsa.getIdEsitoColloquio()));
				theModel.addAttribute("esitoColloquio", esitiColloquioService.getEsitoColloquioNonSalvato(dettagliRisorsa.getIdEsitoColloquio()));
				System.out.println("Esito Colloquio ----"+esitiColloquioService.getEsitoColloquioNonSalvato(dettagliRisorsa.getIdEsitoColloquio()));
			}
			else {
				esitiColloquio = esitiColloquioService.findAll();
				theModel.addAttribute("esitoColloquio", "Selezionare...");
			}
				
			if(dettagliRisorsa.getIdProfilo()!=17) {
				profili = profiliService.findAllException(profiliService.getProfiloNonSalvato(dettagliRisorsa.getIdProfilo()));
				theModel.addAttribute("profilo", profiliService.getProfiloNonSalvato(dettagliRisorsa.getIdProfilo()));
			}
			else {
				profili = profiliService.findAll();
				theModel.addAttribute("profilo", "Selezionare...");
			}
			
			if(dettagliRisorsa.getIdSkill1()!=0) {
				linguaggi1 = linguaggiService.findAllException(linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill1()));
				theModel.addAttribute("skill1", linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill1()));
			}
			else {
				linguaggi1 = linguaggiService.findAll();
				theModel.addAttribute("skill1", "Selezionare...");
			}
			if(dettagliRisorsa.getIdSkill2()!=0) {
				linguaggi2 = linguaggiService.findAllException(linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill2()));
				theModel.addAttribute("skill2", linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill2()));
			}
			else {
				linguaggi2 = linguaggiService.findAll();
				theModel.addAttribute("skill2", "Selezionare...");
			}
			if(dettagliRisorsa.getIdSkill3()!=0) {
				linguaggi3 = linguaggiService.findAllException(linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill3()));
				theModel.addAttribute("skill3", linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill3()));
			}
			else {
				linguaggi3 = linguaggiService.findAll();
				theModel.addAttribute("skill3", "Selezionare...");
			}
			if(dettagliRisorsa.getIdSkill4()!=0) {
				linguaggi4 = linguaggiService.findAllException(linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill4()));
				theModel.addAttribute("skill4", linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill4()));
			}
			else {
				linguaggi4 = linguaggiService.findAll();
				theModel.addAttribute("skill4", "Selezionare...");
			}
			if(dettagliRisorsa.getIdSkill5()!=0) {
				linguaggi5 = linguaggiService.findAllException(linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill5()));
				theModel.addAttribute("skill5", linguaggiService.getSkillNonSalvato(dettagliRisorsa.getIdSkill5()));
			}
			else {
				linguaggi5 = linguaggiService.findAll();
				theModel.addAttribute("skill5", "Selezionare...");
			}
			
			if(dettagliRisorsa.getIdLingua1()!=0) {
				lingue1 = lingueService.findAllException(lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua1()));
				theModel.addAttribute("lingua1", lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua1()));
			}
			else {
				lingue1 = lingueService.findAll();
				theModel.addAttribute("lingua1", "Selezionare...");
			}
			if(dettagliRisorsa.getIdLingua2()!=0) {
				lingue2 = lingueService.findAllException(lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua2()));
				theModel.addAttribute("lingua2", lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua2()));
			}
			else {
				lingue2 = lingueService.findAll();
				theModel.addAttribute("lingua2", "Selezionare...");
			}
			if(dettagliRisorsa.getIdLingua3()!=0) {
				lingue3 = lingueService.findAllException(lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua3()));
				theModel.addAttribute("lingua3", lingueService.getLinguaNonSalvato(dettagliRisorsa.getIdLingua3()));
			}
			else {
				lingue3 = lingueService.findAll();
				theModel.addAttribute("lingua3", "Selezionare...");
			}
			
			if(dettagliRisorsa.getIdSeniority()!=0) {
				livelli = livelliService.findAllException(livelliService.getSeniorityNonSalvato(dettagliRisorsa.getIdSeniority()));
				theModel.addAttribute("seniority", livelliService.getSeniorityNonSalvato(dettagliRisorsa.getIdSeniority()));
			}
			else {
				livelli = livelliService.findAll();
				theModel.addAttribute("seniority", "Selezionare...");
			}
			
			theModel.addAttribute("livelli", livelli);
			theModel.addAttribute("lingue1", lingue1);
			theModel.addAttribute("lingue2", lingue2);
			theModel.addAttribute("lingue3", lingue3);
			theModel.addAttribute("linguaggi1", linguaggi1);
			theModel.addAttribute("linguaggi2", linguaggi2);
			theModel.addAttribute("linguaggi3", linguaggi3);
			theModel.addAttribute("linguaggi4", linguaggi4);
			theModel.addAttribute("linguaggi5", linguaggi5);
			theModel.addAttribute("profili", profili);
			theModel.addAttribute("esitiColloquio", esitiColloquio);
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Modifica Candidato");
			theModel.addAttribute("path", "candidati/");
			theModel.addAttribute("view", "modificaCandidato");
			
			return "default"+localSession.getRuolo();		
		}
	}
	
	@RequestMapping("/elimina-candidato/{idRisorsa}")
	@Transactional
	public String eliminaCandidato(@PathVariable int idRisorsa, HttpServletRequest request, Model theModel)
	{
		HttpSession session = request.getSession(true);
		if (session.getAttribute("idSessione") == null)
		{
			theModel.addAttribute("titlePage", "Login");
			theModel.addAttribute("msgCredenziali", "Inserisci le credenziali per accedere al sistema");
			return "index";
		}
		else
		{
			LocalSession localSession = (LocalSession) session.getAttribute("localSession");
			
			dettagliRisorseService.rimuoviCandidato(idRisorsa);
			risorseService.rimuoviCandidato(idRisorsa);
			
			theModel.addAttribute("nomeCognome", localSession.getNomeCognome());
			theModel.addAttribute("ruolo", localSession.getRuolo());
			theModel.addAttribute("titlePage", "Candidati");
			theModel.addAttribute("path", "candidati/");
			theModel.addAttribute("view", "paginaCandidati");
			return "redirect:/pagina-candidati";
		}
	}
	
	@ResponseBody
	@RequestMapping("/stampa-cv")
	public ResponseWrapper stampaCV(@RequestParam(value="idRisorsa") int idRisorsa, HttpServletRequest request, Model theModel)
	{
		HttpSession session = request.getSession(true);
		ResponseWrapper response = new ResponseWrapper();
		if (session.getAttribute("idSessione") == null)
		{
			theModel.addAttribute("titlePage", "Login");
			theModel.addAttribute("msgCredenziali", "Inserisci le credenziali per accedere al sistema");
			response.setCode("e00404");
		}
		else
		{
			response.setCode("0");
			response.setDescrizione("file64 presi con successo");
			response.setPayload(dettagliRisorseService.getFile64(idRisorsa));
		}
		return response;
	}
}