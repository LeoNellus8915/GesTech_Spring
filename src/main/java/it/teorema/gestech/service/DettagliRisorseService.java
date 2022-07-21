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
}