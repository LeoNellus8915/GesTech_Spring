package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.teorema.gestech.model.Livelli;
import it.teorema.gestech.model.Profili;

public interface LivelliService extends JpaRepository <Livelli, Integer>
{
	@Query("from Livelli")
	abstract
	List<Livelli> findAll();
	
	@Query("select l.nome "
			+ "from Livelli l, DettagliRisorse d "
			+ "where l.id = d.idSeniority and d.idRisorsa = :idRisorsa")
	abstract
	String getSeniority(int idRisorsa);
	
	@Query("select nome "
			+ "from Livelli "
			+ "where id = :idRisorsa")
	abstract
	String getSeniorityNonSalvato(int idRisorsa);
	
	@Query("from Livelli "
			+ "where nome != :seniority")
	abstract 
	List<Livelli> findAllException(String seniority);

	@Query("select id from Livelli where nome = :nome")
	abstract 
	int findIdProfilo(String nome);
}