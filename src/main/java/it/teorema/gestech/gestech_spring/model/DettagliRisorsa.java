package it.teorema.gestech.gestech_spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hy_dettagli_risorsa")
public class DettagliRisorsa
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_risorsa")
	private int id_risorsa;
	@Column(name = "file_base64")
	private String file_base64;
	@Column(name = "data_inserimento")
	private Date data_inserimento;
	@Column(name = "id_esito_colloquio")
	private int id_esito_colloquio;
	@Column(name = "id_skill1")
	private int id_skill1;
	@Column(name = "id_skill2")
	private int id_skill2;
	@Column(name = "id_skill3")
	private int id_skill3;
	@Column(name = "id_skill4")
	private int id_skill4;
	@Column(name = "id_skill5")
	private int id_skill5;
	@Column(name = "id_lingua1")
	private int id_lingua1;
	@Column(name = "id_lingua2")
	private int id_lingua2;
	@Column(name = "id_lingua3")
	private int id_lingua3;
	@Column(name = "id_seniority")
	private int id_seniority;
	
	public DettagliRisorsa() {}

	public DettagliRisorsa(int id, int id_risorsa, String file_base64, Date data_inserimento, int id_esito_colloquio,
			int id_skill1, int id_skill2, int id_skill3, int id_skill4, int id_skill5, int id_lingua1, int id_lingua2,
			int id_lingua3, int id_seniority) {
		super();
		this.id = id;
		this.id_risorsa = id_risorsa;
		this.file_base64 = file_base64;
		this.data_inserimento = data_inserimento;
		this.id_esito_colloquio = id_esito_colloquio;
		this.id_skill1 = id_skill1;
		this.id_skill2 = id_skill2;
		this.id_skill3 = id_skill3;
		this.id_skill4 = id_skill4;
		this.id_skill5 = id_skill5;
		this.id_lingua1 = id_lingua1;
		this.id_lingua2 = id_lingua2;
		this.id_lingua3 = id_lingua3;
		this.id_seniority = id_seniority;
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

	public String getFile_base64() {
		return file_base64;
	}

	public void setFile_base64(String file_base64) {
		this.file_base64 = file_base64;
	}

	public Date getData_inserimento() {
		return data_inserimento;
	}

	public void setData_inserimento(Date data_inserimento) {
		this.data_inserimento = data_inserimento;
	}

	public int getId_esito_colloquio() {
		return id_esito_colloquio;
	}

	public void setId_esito_colloquio(int id_esito_colloquio) {
		this.id_esito_colloquio = id_esito_colloquio;
	}

	public int getId_skill1() {
		return id_skill1;
	}

	public void setId_skill1(int id_skill1) {
		this.id_skill1 = id_skill1;
	}

	public int getId_skill2() {
		return id_skill2;
	}

	public void setId_skill2(int id_skill2) {
		this.id_skill2 = id_skill2;
	}

	public int getId_skill3() {
		return id_skill3;
	}

	public void setId_skill3(int id_skill3) {
		this.id_skill3 = id_skill3;
	}

	public int getId_skill4() {
		return id_skill4;
	}

	public void setId_skill4(int id_skill4) {
		this.id_skill4 = id_skill4;
	}

	public int getId_skill5() {
		return id_skill5;
	}

	public void setId_skill5(int id_skill5) {
		this.id_skill5 = id_skill5;
	}

	public int getId_lingua1() {
		return id_lingua1;
	}

	public void setId_lingua1(int id_lingua1) {
		this.id_lingua1 = id_lingua1;
	}

	public int getId_lingua2() {
		return id_lingua2;
	}

	public void setId_lingua2(int id_lingua2) {
		this.id_lingua2 = id_lingua2;
	}

	public int getId_lingua3() {
		return id_lingua3;
	}

	public void setId_lingua3(int id_lingua3) {
		this.id_lingua3 = id_lingua3;
	}

	public int getId_seniority() {
		return id_seniority;
	}

	public void setId_seniority(int id_seniority) {
		this.id_seniority = id_seniority;
	}
}