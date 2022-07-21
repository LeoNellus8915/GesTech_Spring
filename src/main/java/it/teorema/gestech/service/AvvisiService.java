package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.teorema.gestech.model.Avvisi;

public interface AvvisiService extends JpaRepository <Avvisi, Integer>
{	
	@Modifying
	@Query("delete from Avvisi where id = :idAvviso")
	abstract
	void cancellaAvviso(@Param("idAvviso") int idAvviso);
}