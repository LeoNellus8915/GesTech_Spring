package it.teorema.gestech.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.teorema.gestech.model.DettagliRisorse;

public interface DettagliRisorseService extends JpaRepository <DettagliRisorse, Integer>
{
	@Query("select r.id, d.dataInserimento, r.nomeCognome, r.citta, r.ruoloRisorsa, r.competenzaPrincipale, e.nome "
			+ "from DettagliRisorse d, Risorse r, EsitiColloquio e "
			+ "where r.id = d.idRisorsa and e.id = d.idEsitoColloquio")
	abstract
	List findAll();
	
	@Modifying
	@Query("delete from DettagliRisorse where idRisorsa = :idRisorsa")
	abstract
	void rimuoviCandidato(@Param("idRisorsa") int idRisorsa);
	
	@Query("select dataInserimento from DettagliRisorse where idRisorsa = :idRisorsa")
	abstract
	LocalDateTime getDataInserimento(@Param("idRisorsa") int idRisorsa);
	
	@Modifying
	@Query("update DettagliRisorse set idEsitoColloquio = :esitoColloquio, idSkill1 = :skill1, idSkill2 = :skill2, idSkill3 = :skill3, idSkill4 = :skill4, "
			+ "idSkill5 = :skill5, idLingua1 = :lingua1, idLingua2 = :lingua2, idLingua3 = :lingua3, idSeniority = :seniority where idRisorsa = :idRisorsa")
	abstract
	void updateCandidato(@Param("idRisorsa") int idRisorsa, @Param("esitoColloquio") int esitoColloquio, 
			@Param("skill1") int skill1, @Param("skill2") int skill2, @Param("skill3") int skill3, 
			@Param("skill4") int skill4, @Param("skill5") int skill5, @Param("lingua1") int lingua1, 
			@Param("lingua2") int lingua2, @Param("lingua3") int lingua3, @Param("seniority") int seniority);
}