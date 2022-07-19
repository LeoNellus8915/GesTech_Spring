package it.teorema.gestech.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sy_risorse")
public class Risorse
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "nome_cognome")
	private String nomeCognome;
	@Column(name = "recapito")
	private String recapito;
	@Column(name = "email")
	private String email;
	@Column(name = "profilo_linkedin")
	private String profiloLinkedin;
	@Column(name = "citta")
	private String citta;
	@Column(name = "ruolo_risorsa")
	private String ruoloRisorsa;
	@Column(name = "competenza_principale")
	private String competenzaPrincipale;
	@Column(name = "data_colloquio")
	private LocalDate dataColloquio;
	@Column(name = "anno_colloquio")
	private String annoColloquio;
	@Column(name = "fonte_reperimento")
	private String fonteReperimento;
	@Column(name = "costo_giornaliero")
	private Double costoGiornaliero;
	@Column(name = "possibilita_lavorativa")
	private String possibilitaLavorativa;
	@Column(name = "skill_campo_libero")
	private String skillCampoLibero;
	@Column(name = "competenze_totali")
	private String competenzeTotali;
	@Column(name = "certificazioni")
	private String certificazioni;
	
	public Risorse() {
	}

	public Risorse(int id, String nomeCognome, String recapito, String email, String profiloLinkedin, String citta,
			String ruoloRisorsa, String competenzaPrincipale, LocalDate dataColloquio, String annoColloquio,
			String fonteReperimento, Double costoGiornaliero, String possibilitaLavorativa, String skillCampoLibero,
			String competenzeTotali, String certificazioni) {
		super();
		this.id = id;
		this.nomeCognome = nomeCognome;
		this.recapito = recapito;
		this.email = email;
		this.profiloLinkedin = profiloLinkedin;
		this.citta = citta;
		this.ruoloRisorsa = ruoloRisorsa;
		this.competenzaPrincipale = competenzaPrincipale;
		this.dataColloquio = dataColloquio;
		this.annoColloquio = annoColloquio;
		this.fonteReperimento = fonteReperimento;
		this.costoGiornaliero = costoGiornaliero;
		this.possibilitaLavorativa = possibilitaLavorativa;
		this.skillCampoLibero = skillCampoLibero;
		this.competenzeTotali = competenzeTotali;
		this.certificazioni = certificazioni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCognome() {
		return nomeCognome;
	}

	public void setNomeCognome(String nomeCognome) {
		this.nomeCognome = nomeCognome;
	}

	public String getRecapito() {
		return recapito;
	}

	public void setRecapito(String recapito) {
		this.recapito = recapito;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfiloLinkedin() {
		return profiloLinkedin;
	}

	public void setProfiloLinkedin(String profiloLinkedin) {
		this.profiloLinkedin = profiloLinkedin;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getRuoloRisorsa() {
		return ruoloRisorsa;
	}

	public void setRuoloRisorsa(String ruoloRisorsa) {
		this.ruoloRisorsa = ruoloRisorsa;
	}

	public String getCompetenzaPrincipale() {
		return competenzaPrincipale;
	}

	public void setCompetenzaPrincipale(String competenzaPrincipale) {
		this.competenzaPrincipale = competenzaPrincipale;
	}

	public LocalDate getDataColloquio() {
		return dataColloquio;
	}

	public void setDataColloquio(LocalDate dataColloquio) {
		this.dataColloquio = dataColloquio;
	}

	public String getAnnoColloquio() {
		return annoColloquio;
	}

	public void setAnnoColloquio(String annoColloquio) {
		this.annoColloquio = annoColloquio;
	}

	public String getFonteReperimento() {
		return fonteReperimento;
	}

	public void setFonteReperimento(String fonteReperimento) {
		this.fonteReperimento = fonteReperimento;
	}

	public Double getCostoGiornaliero() {
		return costoGiornaliero;
	}

	public void setCostoGiornaliero(Double costoGiornaliero) {
		this.costoGiornaliero = costoGiornaliero;
	}

	public String getPossibilitaLavorativa() {
		return possibilitaLavorativa;
	}

	public void setPossibilitaLavorativa(String possibilitaLavorativa) {
		this.possibilitaLavorativa = possibilitaLavorativa;
	}

	public String getSkillCampoLibero() {
		return skillCampoLibero;
	}

	public void setSkillCampoLibero(String skillCampoLibero) {
		this.skillCampoLibero = skillCampoLibero;
	}

	public String getCompetenzeTotali() {
		return competenzeTotali;
	}

	public void setCompetenzeTotali(String competenzeTotali) {
		this.competenzeTotali = competenzeTotali;
	}

	public String getCertificazioni() {
		return certificazioni;
	}

	public void setCertificazioni(String certificazioni) {
		this.certificazioni = certificazioni;
	}
}