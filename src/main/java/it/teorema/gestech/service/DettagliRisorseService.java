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
	@Query("select r.id, d.dataInserimento, r.nomeCognome, r.citta, p.nome, r.competenzaPrincipale, e.nome "
			+ "from DettagliRisorse d, Risorse r, EsitiColloquio e, Profili p "
			+ "where r.id = d.idRisorsa and e.id = d.idEsitoColloquio and p.id = d.idProfilo")
	abstract
	List findAll();
	
	@Modifying
	@Query("delete from DettagliRisorse where idRisorsa = :idRisorsa")
	abstract
	void rimuoviCandidato(int idRisorsa);
	
	@Query("select dataInserimento from DettagliRisorse where idRisorsa = :idRisorsa")
	abstract
	LocalDateTime getDataInserimento(int idRisorsa);
	
	@Modifying
	@Query("update DettagliRisorse set idEsitoColloquio = :esitoColloquio, idProfilo = :profilo, idSkill1 = :skill1, idSkill2 = :skill2, idSkill3 = :skill3, idSkill4 = :skill4, "
			+ "idSkill5 = :skill5, idLingua1 = :lingua1, idLingua2 = :lingua2, idLingua3 = :lingua3, idSeniority = :seniority where idRisorsa = :idRisorsa")
	abstract
	void updateCandidato(int idRisorsa, int esitoColloquio, int profilo, int skill1, int skill2, int skill3, 
			int skill4, int skill5, int lingua1, int lingua2, int lingua3, int seniority);
}