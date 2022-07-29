package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Richieste;

public interface RichiesteService extends JpaRepository <Richieste, Integer>
{
	
	@Query("from Richieste")
	abstract
	List<Richieste> findAll();
	
	@Query("from Richieste "
			+ "where id = :idRichiesta")
	abstract
	Richieste findById(int idRichiesta);
}