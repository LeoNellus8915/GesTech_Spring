package it.teorema.gestech.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hy_dettaglio_risorsa")
public class DettagliRisorse
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "id_risorsa")
	private Integer idRisorsa;
	@Column(name = "file_base64")
	private String fileBase64;
	@Column(name = "data_inserimento")
	private LocalDateTime dataInserimento;
	@Column(name = "id_esito_colloquio")
	private Integer idEsitoColloquio;
	@Column(name = "id_profilo")
	private Integer idProfilo;
	@Column(name = "id_skill1")
	private Integer idSkill1;
	@Column(name = "id_skill2")
	private Integer idSkill2;
	@Column(name = "id_skill3")
	private Integer idSkill3;
	@Column(name = "id_skill4")
	private Integer idSkill4;
	@Column(name = "id_skill5")
	private Integer idSkill5;
	@Column(name = "id_lingua1")
	private Integer idLingua1;
	@Column(name = "id_lingua2")
	private Integer idLingua2;
	@Column(name = "id_lingua3")
	private Integer idLingua3;
	@Column(name = "id_seniority")
	private Integer idSeniority;
	
	public DettagliRisorse() {}

	public DettagliRisorse(Integer id, Integer idRisorsa, String fileBase64, LocalDateTime dataInserimento,
			Integer idEsitoColloquio, Integer idProfilo, Integer idSkill1, Integer idSkill2, Integer idSkill3,
			Integer idSkill4, Integer idSkill5, Integer idLingua1, Integer idLingua2, Integer idLingua3,
			Integer idSeniority) {
		super();
		this.id = id;
		this.idRisorsa = idRisorsa;
		this.fileBase64 = fileBase64;
		this.dataInserimento = dataInserimento;
		this.idEsitoColloquio = idEsitoColloquio;
		this.idProfilo = idProfilo;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(Integer idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getFileBase64() {
		return fileBase64;
	}

	public void setFileBase64(String fileBase64) {
		this.fileBase64 = fileBase64;
	}

	public LocalDateTime getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(LocalDateTime dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Integer getIdEsitoColloquio() {
		return idEsitoColloquio;
	}

	public void setIdEsitoColloquio(Integer idEsitoColloquio) {
		this.idEsitoColloquio = idEsitoColloquio;
	}

	public Integer getIdProfilo() {
		return idProfilo;
	}

	public void setIdProfilo(Integer idProfilo) {
		this.idProfilo = idProfilo;
	}

	public Integer getIdSkill1() {
		return idSkill1;
	}

	public void setIdSkill1(Integer idSkill1) {
		this.idSkill1 = idSkill1;
	}

	public Integer getIdSkill2() {
		return idSkill2;
	}

	public void setIdSkill2(Integer idSkill2) {
		this.idSkill2 = idSkill2;
	}

	public Integer getIdSkill3() {
		return idSkill3;
	}

	public void setIdSkill3(Integer idSkill3) {
		this.idSkill3 = idSkill3;
	}

	public Integer getIdSkill4() {
		return idSkill4;
	}

	public void setIdSkill4(Integer idSkill4) {
		this.idSkill4 = idSkill4;
	}

	public Integer getIdSkill5() {
		return idSkill5;
	}

	public void setIdSkill5(Integer idSkill5) {
		this.idSkill5 = idSkill5;
	}

	public Integer getIdLingua1() {
		return idLingua1;
	}

	public void setIdLingua1(Integer idLingua1) {
		this.idLingua1 = idLingua1;
	}

	public Integer getIdLingua2() {
		return idLingua2;
	}

	public void setIdLingua2(Integer idLingua2) {
		this.idLingua2 = idLingua2;
	}

	public Integer getIdLingua3() {
		return idLingua3;
	}

	public void setIdLingua3(Integer idLingua3) {
		this.idLingua3 = idLingua3;
	}

	public Integer getIdSeniority() {
		return idSeniority;
	}

	public void setIdSeniority(Integer idSeniority) {
		this.idSeniority = idSeniority;
	}
}