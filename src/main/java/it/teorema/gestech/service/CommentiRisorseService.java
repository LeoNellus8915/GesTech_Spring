package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.teorema.gestech.model.CommentiRisorse;

public interface CommentiRisorseService extends JpaRepository <CommentiRisorse, Integer>
{
	@Query("select c.data, r.nomeCognome, c.note "
			+ "from Commenti c, Risorse r "
			+ "where r.id = c.idRisorsa and r.id = :idRisorsa "
			+ "order by c.data desc")
	abstract
	List stampaCommenti(int idRisorsa);
}