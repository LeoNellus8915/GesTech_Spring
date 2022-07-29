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

	@Query("select ri.id, ri.data, ri.cliente, ri.citta, ri.costo, ri.note, li.nome as nome_linguaggio, "
			+ "pro.nome as nome_profilo, liv.nome as nome_seniority, sr.nome as nome_stato "
			+ "from hy_richieste ri, ty_linguaggi li, ty_profili pro, ty_livelli liv, ty_stati_richiesta sr "
			+ "where ri.id_seniority = :idSeniority and ri.id_skill = :idSkill and "
			+ "ri.id_profilo = :idProfilo and ri.id_stato = :idStato")
	abstract 
	List stampaCard(int idSeniority, int idSkill, int idProfilo, int idStato);
}