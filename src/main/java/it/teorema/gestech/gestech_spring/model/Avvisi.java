package it.teorema.gestech.gestech_spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hy_avvisi")
public class Avvisi
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_ruolo")
	private int id_ruolo;
	@Column(name = "id_risorsa")
	private int id_risorsa;
	@Column(name = "note")
	private String note;
	
	public Avvisi() {}

	public Avvisi(int id, int id_ruolo, int id_risorsa, String note) {
		super();
		this.id = id;
		this.id_ruolo = id_ruolo;
		this.id_risorsa = id_risorsa;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_ruolo() {
		return id_ruolo;
	}

	public void setId_ruolo(int id_ruolo) {
		this.id_ruolo = id_ruolo;
	}

	public int getId_risorsa() {
		return id_risorsa;
	}

	public void setId_risorsa(int id_risorsa) {
		this.id_risorsa = id_risorsa;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
