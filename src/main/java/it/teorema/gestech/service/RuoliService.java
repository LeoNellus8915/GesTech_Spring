package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Ruoli;

public interface RuoliService extends JpaRepository <Ruoli, Integer>
{
	@Query("select nome "
			+ "from Ruoli  "
			+ "where id = :idRuolo")
	abstract
	String getRuolo(int idRuolo);
}