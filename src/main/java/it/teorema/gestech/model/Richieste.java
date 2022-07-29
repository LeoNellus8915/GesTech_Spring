package it.teorema.gestech.model;

import java.sql.Date;
import java.time.LocalDate;

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
	private LocalDate data;
	@Column(name = "id_skill")
	private int id_skill;
	@Column(name = "id_profilo")
	private int id_profilo;
	@Column(name = "id_seniority")
	private int id_seniority;
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

	public Richieste(int id, LocalDate data, int id_skill, int id_profilo, int id_seniority, String cliente,
			String citta, double costo, String note, String recruiter) {
		super();
		this.id = id;
		this.data = data;
		this.id_skill = id_skill;
		this.id_profilo = id_profilo;
		this.id_seniority = id_seniority;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getId_skill() {
		return id_skill;
	}

	public void setId_skill(int id_skill) {
		this.id_skill = id_skill;
	}

	public int getId_profilo() {
		return id_profilo;
	}

	public void setId_profilo(int id_profilo) {
		this.id_profilo = id_profilo;
	}

	public int getId_seniority() {
		return id_seniority;
	}

	public void setId_seniority(int id_seniority) {
		this.id_seniority = id_seniority;
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
