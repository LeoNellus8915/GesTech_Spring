package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.DettagliRisorse;

public interface DettagliRisorseService extends JpaRepository <DettagliRisorse, Integer>
{
	@Query("select r.id, d.dataInserimento, r.nomeCognome, r.citta, r.ruoloRisorsa, r.competenzaPrincipale, e.nome "
			+ "from DettagliRisorse d, Risorse r, EsitiColloquio e "
			+ "where r.id = d.idRisorsa and e.id = d.idEsitoColloquio")
	abstract
	List findAll();
}