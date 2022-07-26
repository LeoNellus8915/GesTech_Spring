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
			+ "where d.idRisorsa = :idRisorsa and p.id = d.idProfilo")
	abstract 
	String getProfilo(int idRisorsa);
	
	@Query("select nome "
			+ "from Profili "
			+ "where id = :idRisorsa")
	abstract 
	String getProfiloNonSalvato(int idRisorsa);

	@Query("from Profili "
			+ "where nome != :profilo")
	abstract 
	List<Profili> findAllException(String profilo);

	@Query("select id from Profili where nome = :nome")
	abstract 
	int findIdProfilo(String nome);
}