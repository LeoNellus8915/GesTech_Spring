package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Ruoli;

public interface RuoliService extends JpaRepository <Ruoli, Integer>
{
	@Query("from Ruoli")
	abstract
	List<Ruoli> findAll();

	@Query("select nome "
			+ "from Ruoli  "
			+ "where id = :idRuolo")
	abstract
	String findRuolo(int idRuolo);
}