package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.RuoliRisorse;

public interface RuoliRisorseService extends JpaRepository <RuoliRisorse, Integer>
{
	@Query("from RuoliRisorse where id_risorsa = :idRisorsa")
	abstract
	List<RuoliRisorse> findIdRuolo(int idRisorsa);
}