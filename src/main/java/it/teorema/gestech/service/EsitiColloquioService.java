package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.teorema.gestech.model.EsitiColloquio;

public interface EsitiColloquioService extends JpaRepository <EsitiColloquio, Integer>
{
	@Query("from EsitiColloquio")
	abstract
	List <EsitiColloquio> findAll();
	
	@Query("select e.nome "
			+ "from EsitiColloquio e, DettagliRisorse d "
			+ "where e.id = d.idEsitoColloquio and d.idRisorsa = :idRisorsa")
	abstract
	String getEsitoColloquio(int idRisorsa);

	@Query("from EsitiColloquio "
			+ "where nome != :esitoColloquio")
	abstract 
	List<EsitiColloquio> findAllException(String esitoColloquio);

	@Query("select id from EsitiColloquio where nome = :nomeEsitoColloquio")
	abstract 
	int findIdEsitoColloquio(String nomeEsitoColloquio);
}