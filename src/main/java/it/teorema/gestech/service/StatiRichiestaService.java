package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.StatiRichiesta;

public interface StatiRichiestaService extends JpaRepository <StatiRichiesta, Integer>
{
	@Query("from StatiRichiesta")
	abstract
	List <StatiRichiesta> findAll();
	
	@Query("select nome "
			+ "from StatiRichiesta "
			+ "where id = :idStato")
	abstract
	String findById(int idStato);
	
	@Query("from StatiRichiesta "
			+ "where nome != :statiRichiesta")
	abstract 
	List<StatiRichiesta> findAllException(String statiRichiesta);
}
