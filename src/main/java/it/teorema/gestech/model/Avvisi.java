package it.teorema.gestech.model;

import java.time.LocalDateTime;

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
	@Column(name = "titolo")
	private String titolo;
	@Column(name = "ruoli")
	private String ruoli;
	@Column(name = "id_risorsa")
	private int idRisorsa;
	@Column(name = "note")
	private String note;
	@Column(name = "data")
	private LocalDateTime data;
	
	public Avvisi() {}
	
	public Avvisi(int id, String titolo, String ruoli, int idRisorsa, String note, LocalDateTime data) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.ruoli = ruoli;
		this.idRisorsa = idRisorsa;
		this.note = note;
		this.data = data;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRuoli() {
		return ruoli;
	}

	public void setRuoli(String ruoli) {
		this.ruoli = ruoli;
	}

	public int getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(int idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
}