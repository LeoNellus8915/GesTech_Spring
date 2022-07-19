package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.teorema.gestech.model.Ruoli;

public interface RuoliService extends JpaRepository <Ruoli, Integer>
{
	@Query("from Ruoli")
	abstract
	List findAll();

	@Query("from Ruoli  where id = :idRuolo")
	abstract
	List findRuolo(@Param("idRuolo") Object idRuolo);
}