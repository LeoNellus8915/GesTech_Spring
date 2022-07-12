package it.teorema.gestech.gestech_spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sy_menu")
public class Menu
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_ruolo")
	private int id_ruolo;
	@Column(name = "categoria")
	private String categoria;
	@Column(name = "label")
	private String label;
	@Column(name = "url")
	private String url;
	
	public Menu() {}

	public Menu(int id, int id_ruolo, String categoria, String label, String url) {
		super();
		this.id = id;
		this.id_ruolo = id_ruolo;
		this.categoria = categoria;
		this.label = label;
		this.url = url;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
