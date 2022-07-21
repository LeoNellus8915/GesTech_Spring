package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.teorema.gestech.model.Commenti;

public interface CommentiService extends JpaRepository <Commenti, Integer>
{
	@Query("select c.data, r.nomeCognome, c.note "
			+ "from Commenti c, Risorse r "
			+ "where r.id = c.idRisorsa and r.id = :idRisorsa")
	abstract
	List stampaCommenti(@Param("idRisorsa") int idRisorsa);
}