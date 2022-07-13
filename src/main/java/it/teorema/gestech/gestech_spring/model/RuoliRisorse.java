package it.teorema.gestech.gestech_spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sy_ruoli_risorse")
public class RuoliRisorse
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_risorsa")
	private int id_risorsa;
	@Column(name = "id_ruolo")
	private int id_ruolo;
	
	public RuoliRisorse() {}

	public RuoliRisorse(int id, int id_risorsa, int id_ruolo) {
		super();
		this.id = id;
		this.id_risorsa = id_risorsa;
		this.id_ruolo = id_ruolo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_risorsa() {
		return id_risorsa;
	}

	public void setId_risorsa(int id_risorsa) {
		this.id_risorsa = id_risorsa;
	}

	public int getId_ruolo() {
		return id_ruolo;
	}

	public void setId_ruolo(int id_ruolo) {
		this.id_ruolo = id_ruolo;
	}
}
