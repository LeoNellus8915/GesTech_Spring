package it.teorema.gestech.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hy_commenti_richieste")
public class Richieste 

{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_risorsa")
	private int idRisorsa;
	@Column(name = "data")
	private LocalDateTime data;
	@Column(name = "id_skill")
	private int idSkill;
	@Column(name = "id_profilo")
	private int idProfilo;
	@Column(name = "id_seniority")
	private int idSeniority;
	@Column(name = "cliente")
	private String cliente;
	@Column(name = "citta")
	private String citta;
	@Column(name = "costo")
	private double costo;
	@Column(name = "note")
	private String note;
	@Column(name = "recruiter")
	private String recruiter;
	@Column(name = "id_stato")
	private int idStato;
	@Column(name = "id_commento")
	private int idCommento;
	
	public Richieste() {
		id = 0;
		idRisorsa = 0;
		idSkill = 0;
		idProfilo = 0;
		idSeniority = 0;
		cliente = "";
		citta = "";
		costo = 0.0;
		note = "";
		recruiter = "";
		idStato = 0;
		idCommento = 0;
	}

	public Richieste(int id, int idRisorsa,LocalDateTime data, int idSkill, int idProfilo, int idSeniority, String cliente,
			String citta, double costo, String note, String recruiter, int idStato, int idCommento) {
		super();
		this.id = id;
		this.idRisorsa = idRisorsa;
		this.data = data;
		this.idSkill = idSkill;
		this.idProfilo = idProfilo;
		this.idSeniority = idSeniority;
		this.cliente = cliente;
		this.citta = citta;
		this.costo = costo;
		this.note = note;
		this.recruiter = recruiter;
		this.idStato = idStato;
		this.idCommento = idCommento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(int idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public int getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(int idSkill) {
		this.idSkill = idSkill;
	}

	public int getIdProfilo() {
		return idProfilo;
	}

	public void setIdProfilo(int idProfilo) {
		this.idProfilo = idProfilo;
	}

	public int getIdSeniority() {
		return idSeniority;
	}

	public void setIdSeniority(int idSeniority) {
		this.idSeniority = idSeniority;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}

	public int getIdStato() {
		return idStato;
	}

	public void setIdStato(int idStato) {
		this.idStato = idStato;
	}

	public int getIdCommento() {
		return idCommento;
	}

	public void setIdCommento(int idCommento) {
		this.idCommento = idCommento;
	}
	
	}