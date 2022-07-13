package it.teorema.gestech.gestech.model;

import java.util.Date;
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
	private int id_file_risorsa;
	@Column(name = "note")
	private String note;
	@Column(name = "data")
	private Date data;
	
	public Commenti() {}

	public Commenti(int id, int id_file_risorsa, String note, Date data) {
		super();
		this.id = id;
		this.id_file_risorsa = id_file_risorsa;
		this.note = note;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_file_risorsa() {
		return id_file_risorsa;
	}

	public void setId_file_risorsa(int id_file_risorsa) {
		this.id_file_risorsa = id_file_risorsa;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
