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
	String getSkill1(int idRisorsa);
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliRisorse d "
			+ "where l.id = d.idSkill2 and d.idRisorsa = :idRisorsa")
	abstract
	String getSkill2(int idRisorsa);
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliRisorse d "
			+ "where l.id = d.idSkill3 and d.idRisorsa = :idRisorsa")
	abstract
	String getSkill3(int idRisorsa);
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliRisorse d "
			+ "where l.id = d.idSkill4 and d.idRisorsa = :idRisorsa")
	abstract
	String getSkill4(int idRisorsa);
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliRisorse d "
			+ "where l.id = d.idSkill5 and d.idRisorsa = :idRisorsa")
	abstract
	String getSkill5(int idRisorsa);

	@Query("from Linguaggi "
			+ "where nome != :skill")
	abstract 
	List<Linguaggi> findAllException(String skill);

	@Query("select id from Linguaggi where nome = :nome")
	abstract 
	int findIdSkill1(String nome);
	
	@Query("select id from Linguaggi where nome = :nome")
	abstract 
	int findIdSkill2(String nome);
	
	@Query("select id from Linguaggi where nome = :nome")
	abstract 
	int findIdSkill3(String nome);
	
	@Query("select id from Linguaggi where nome = :nome")
	abstract 
	int findIdSkill4(String nome);
	
	@Query("select id from Linguaggi where nome = :nome")
	abstract 
	int findIdSkill5(String nome);
}