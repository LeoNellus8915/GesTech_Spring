package it.teorema.gestech.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hy_commenti")
public class Commenti
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_risorsa")
	private int idRisorsa;
	@Column(name = "note")
	private String note;
	@Column(name = "data")
	private LocalDate data;
	
	public Commenti() {}

	public Commenti(int id, int idRisorsa, String note, LocalDate data) {
		super();
		this.id = id;
		this.idRisorsa = idRisorsa;
		this.note = note;
		this.data = data;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}
