package it.teorema.gestech.model;

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
	@Column(name = "id_file_risorsa")
	private int idFileRisorsa;
	@Column(name = "note")
	private String note;
	@Column(name = "data")
	private LocalDateTime data;
	
	public Commenti() {}

	public Commenti(int id, int idFileRisorsa, String note, LocalDateTime data) {
		super();
		this.id = id;
		this.idFileRisorsa = idFileRisorsa;
		this.note = note;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdFileRisorsa() {
		return idFileRisorsa;
	}

	public void setIdFileRisorsa(int idFileRisorsa) {
		this.idFileRisorsa = idFileRisorsa;
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
