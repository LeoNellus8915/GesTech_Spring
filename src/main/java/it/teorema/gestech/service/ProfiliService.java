package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.teorema.gestech.model.Profili;

public interface ProfiliService extends JpaRepository <Profili, Integer>
{
	@Query("from Profili")
	abstract
	List <Profili> findAll();
	
	@Query("select p.nome "
			+ "from Profili p, DettagliRisorse d "
			+ "where p.id = d.idSeniority and d.idRisorsa = :idRisorsa")
	abstract
	String getSeniority(@Param (value = "idRisorsa") int idRisorsa);
}