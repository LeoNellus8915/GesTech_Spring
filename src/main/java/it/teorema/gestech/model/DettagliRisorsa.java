package it.teorema.gestech.model;

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
	private int idRisorsa;
	@Column(name = "file_base64")
	private String fileBase64;
	@Column(name = "data_inserimento")
	private Date dataInserimento;
	@Column(name = "id_esito_colloquio")
	private int idEsitoColloquio;
	@Column(name = "id_skill1")
	private int idSkill1;
	@Column(name = "id_skill2")
	private int idSkill2;
	@Column(name = "id_skill3")
	private int idSkill3;
	@Column(name = "id_skill4")
	private int idSkill4;
	@Column(name = "id_skill5")
	private int idSkill5;
	@Column(name = "id_lingua1")
	private int idLingua1;
	@Column(name = "id_lingua2")
	private int idLingua2;
	@Column(name = "id_lingua3")
	private int idLingua3;
	@Column(name = "id_seniority")
	private int idSeniority;
	
	public DettagliRisorsa() {}

	public DettagliRisorsa(int id, int idRisorsa, String fileBase64, Date dataInserimento, int idEsitoColloquio,
			int idSkill1, int idSkill2, int idSkill3, int idSkill4, int idSkill5, int idLingua1, int idLingua2,
			int idLingua3, int idSeniority) {
		super();
		this.id = id;
		this.idRisorsa = idRisorsa;
		this.fileBase64 = fileBase64;
		this.dataInserimento = dataInserimento;
		this.idEsitoColloquio = idEsitoColloquio;
		this.idSkill1 = idSkill1;
		this.idSkill2 = idSkill2;
		this.idSkill3 = idSkill3;
		this.idSkill4 = idSkill4;
		this.idSkill5 = idSkill5;
		this.idLingua1 = idLingua1;
		this.idLingua2 = idLingua2;
		this.idLingua3 = idLingua3;
		this.idSeniority = idSeniority;
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

	public String getFileBase64() {
		return fileBase64;
	}

	public void setFileBase64(String fileBase64) {
		this.fileBase64 = fileBase64;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public int getIdEsitoColloquio() {
		return idEsitoColloquio;
	}

	public void setIdEsitoColloquio(int idEsitoColloquio) {
		this.idEsitoColloquio = idEsitoColloquio;
	}

	public int getIdSkill1() {
		return idSkill1;
	}

	public void setIdSkill1(int idSkill1) {
		this.idSkill1 = idSkill1;
	}

	public int getIdSkill2() {
		return idSkill2;
	}

	public void setIdSkill2(int idSkill2) {
		this.idSkill2 = idSkill2;
	}

	public int getIdSkill3() {
		return idSkill3;
	}

	public void setIdSkill3(int idSkill3) {
		this.idSkill3 = idSkill3;
	}

	public int getIdSkill4() {
		return idSkill4;
	}

	public void setIdSkill4(int idSkill4) {
		this.idSkill4 = idSkill4;
	}

	public int getIdSkill5() {
		return idSkill5;
	}

	public void setIdSkill5(int idSkill5) {
		this.idSkill5 = idSkill5;
	}

	public int getIdLingua1() {
		return idLingua1;
	}

	public void setIdLingua1(int idLingua1) {
		this.idLingua1 = idLingua1;
	}

	public int getIdLingua2() {
		return idLingua2;
	}

	public void setIdLingua2(int idLingua2) {
		this.idLingua2 = idLingua2;
	}

	public int getIdLingua3() {
		return idLingua3;
	}

	public void setIdLingua3(int idLingua3) {
		this.idLingua3 = idLingua3;
	}

	public int getIdSeniority() {
		return idSeniority;
	}

	public void setIdSeniority(int idSeniority) {
		this.idSeniority = idSeniority;
	}
}