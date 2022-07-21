package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.teorema.gestech.model.Lingue;

public interface LingueService extends JpaRepository <Lingue, Integer>
{
	@Query("from Lingue")
	abstract
	List<Lingue> findAll();
	
	@Query("select l.nome "
			+ "from Lingue l, DettagliRisorse d "
			+ "where l.id = d.idLingua1 and d.idRisorsa = :idRisorsa")
	abstract
	String getLingua1(@Param(value = "idRisorsa") int idRisorsa);
	
	@Query("select l.nome "
			+ "from Lingue l, DettagliRisorse d "
			+ "where l.id = d.idLingua2 and d.idRisorsa = :idRisorsa")
	abstract
	String getLingua2(@Param(value = "idRisorsa") int idRisorsa);
	
	@Query("select l.nome "
			+ "from Lingue l, DettagliRisorse d "
			+ "where l.id = d.idLingua3 and d.idRisorsa = :idRisorsa")
	abstract
	String getLingua3(@Param(value = "idRisorsa") int idRisorsa);
}