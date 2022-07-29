package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Avvisi;

public interface AvvisiService extends JpaRepository <Avvisi, Integer>
{	
	@Query("from Avvisi order by id desc")
	abstract
	List<Avvisi> getAvvisi();
	
	@Modifying
	@Query("delete from Avvisi where id = :idAvviso")
	abstract
	void cancellaAvviso(int idAvviso);
}