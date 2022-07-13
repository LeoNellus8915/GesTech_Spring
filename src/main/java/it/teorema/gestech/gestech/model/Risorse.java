package it.teorema.gestech.gestech.model;

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
	private String nome_cognome;
	@Column(name = "recapito")
	private String recapito;
	@Column(name = "email")
	private String email;
	@Column(name = "profilo_linkedin")
	private String profilo_linkedin;
	@Column(name = "citta")
	private String citta;
	@Column(name = "ruolo_risorsa")
	private String ruolo_risorsa;
	@Column(name = "competenza_principale")
	private String competenza_principale;
	@Column(name = "data_colloquio")
	private Date data_colloquio;
	@Column(name = "anno_colloquio")
	private int anno_colloquio;
	@Column(name = "fonte_reperimento")
	private String fonte_reperimento;
	@Column(name = "costo_giornaliero")
	private double costo_giornaliero;
	@Column(name = "possibilita_lavorativa")
	private String possibilita_lavorativa;
	@Column(name = "skill_campo_libero")
	private String skill_campo_libero;
	@Column(name = "competenze_totali")
	private String competenze_totali;
	@Column(name = "certificazioni")
	private String certificazioni;
	
	public Risorse() {}
	
	public Risorse(int id, String nome_cognome, String recapito, String email, String profilo_linkedin, String citta,
			String ruolo_risorsa, String competenza_principale, Date data_colloquio, int anno_colloquio,
			String fonte_reperimento, double costo_giornaliero, String possibilita_lavorativa, String skill_campo_libero,
			String competenze_totali, String certificazioni)
	{
		super();
		this.id = id;
		this.nome_cognome = nome_cognome;
		this.recapito = recapito;
		this.email = email;
		this.profilo_linkedin = profilo_linkedin;
		this.citta = citta;
		this.ruolo_risorsa = ruolo_risorsa;
		this.competenza_principale = competenza_principale;
		this.data_colloquio = data_colloquio;
		this.anno_colloquio = anno_colloquio;
		this.fonte_reperimento = fonte_reperimento;
		this.costo_giornaliero = costo_giornaliero;
		this.possibilita_lavorativa = possibilita_lavorativa;
		this.skill_campo_libero = skill_campo_libero;
		this.competenze_totali = competenze_totali;
		this.certificazioni = certificazioni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_cognome() {
		return nome_cognome;
	}

	public void setNome_cognome(String nome_cognome) {
		this.nome_cognome = nome_cognome;
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

	public String getProfilo_linkedin() {
		return profilo_linkedin;
	}

	public void setProfilo_linkedin(String profilo_linkedin) {
		this.profilo_linkedin = profilo_linkedin;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getRuolo_risorsa() {
		return ruolo_risorsa;
	}

	public void setRuolo_risorsa(String ruolo_risorsa) {
		this.ruolo_risorsa = ruolo_risorsa;
	}

	public String getCompetenza_principale() {
		return competenza_principale;
	}

	public void setCompetenza_principale(String competenza_principale) {
		this.competenza_principale = competenza_principale;
	}

	public Date getData_colloquio() {
		return data_colloquio;
	}

	public void setData_colloquio(Date data_colloquio) {
		this.data_colloquio = data_colloquio;
	}

	public int getAnno_colloquio() {
		return anno_colloquio;
	}

	public void setAnno_colloquio(int anno_colloquio) {
		this.anno_colloquio = anno_colloquio;
	}

	public String getFonte_reperimento() {
		return fonte_reperimento;
	}

	public void setFonte_reperimento(String fonte_reperimento) {
		this.fonte_reperimento = fonte_reperimento;
	}

	public double getCosto_giornaliero() {
		return costo_giornaliero;
	}

	public void setCosto_giornaliero(double costo_giornaliero) {
		this.costo_giornaliero = costo_giornaliero;
	}

	public String getPossibilita_lavorativa() {
		return possibilita_lavorativa;
	}

	public void setPossibilita_lavorativa(String possibilita_lavorativa) {
		this.possibilita_lavorativa = possibilita_lavorativa;
	}

	public String getSkill_campo_libero() {
		return skill_campo_libero;
	}

	public void setSkill_campo_libero(String skill_campo_libero) {
		this.skill_campo_libero = skill_campo_libero;
	}

	public String getCompetenze_totali() {
		return competenze_totali;
	}

	public void setCompetenze_totali(String competenze_totali) {
		this.competenze_totali = competenze_totali;
	}

	public String getCertificazioni() {
		return certificazioni;
	}

	public void setCertificazioni(String certificazioni) {
		this.certificazioni = certificazioni;
	}
}