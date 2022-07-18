package it.teorema.gestech.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sy_auth")
public class Auth
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_risorsa")
	private int id_risorsa;
	@Column(name = "password")
	private String password;
	@Column(name = "data")
	private LocalDate data;

	public Auth(){}
	
	public Auth(int id, int id_risorsa, String password, LocalDate data) {
		super();
		this.id = id;
		this.id_risorsa = id_risorsa;
		this.password = password;
		this.data = data;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Auth [id=" + id + ", id_risorsa=" + id_risorsa + ", password=" + password + ", data=" + data + "]";
	}
}