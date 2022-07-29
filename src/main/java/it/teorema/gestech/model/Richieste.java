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
	
	public Richieste () {}

	public Richieste(int id, LocalDateTime data, int idSkill, int idProfilo, int idSeniority, String cliente,
			String citta, double costo, String note, String recruiter) {
		super();
		this.id = id;
		this.data = data;
		this.idSkill = idSkill;
		this.idProfilo = idProfilo;
		this.idSeniority = idSeniority;
		this.cliente = cliente;
		this.citta = citta;
		this.costo = costo;
		this.note = note;
		this.recruiter = recruiter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setId_skill(int idSkill) {
		this.idSkill = idSkill;
	}

	public int getIdProfilo() {
		return idProfilo;
	}

	public void setId_profilo(int idProfilo) {
		this.idProfilo = idProfilo;
	}

	public int getIdSeniority() {
		return idSeniority;
	}

	public void setId_seniority(int idSeniority) {
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
}