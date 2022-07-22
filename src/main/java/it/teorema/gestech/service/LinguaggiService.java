package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.teorema.gestech.model.Linguaggi;

public interface LinguaggiService extends JpaRepository <Linguaggi, Integer>
{
	@Query("from Linguaggi")
	abstract
	List <Linguaggi> findAll();
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliRisorse d "
			+ "where l.id = d.idSkill1 and d.idRisorsa = :idRisorsa")
	abstract
	String getSkill1(@Param(value = "idRisorsa") int idRisorsa);
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliRisorse d "
			+ "where l.id = d.idSkill2 and d.idRisorsa = :idRisorsa")
	abstract
	String getSkill2(@Param(value = "idRisorsa") int idRisorsa);
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliRisorse d "
			+ "where l.id = d.idSkill3 and d.idRisorsa = :idRisorsa")
	abstract
	String getSkill3(@Param(value = "idRisorsa") int idRisorsa);
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliRisorse d "
			+ "where l.id = d.idSkill4 and d.idRisorsa = :idRisorsa")
	abstract
	String getSkill4(@Param(value = "idRisorsa") int idRisorsa);
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliRisorse d "
			+ "where l.id = d.idSkill5 and d.idRisorsa = :idRisorsa")
	abstract
	String getSkill5(@Param(value = "idRisorsa") int idRisorsa);

	@Query("from Linguaggi "
			+ "where nome != :skill")
	abstract 
	List<Linguaggi> findAllException(String skill);
}