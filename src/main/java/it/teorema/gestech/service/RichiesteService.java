package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Richieste;

public interface RichiesteService extends JpaRepository <Richieste, Integer>
{	
	@Query("from Richieste "
			+ "where id = :idRichiesta")
	abstract
	Richieste findById(int idRichiesta);

	@Query("select ri.id, ri.data, ri.cliente, ri.citta, ri.costo, ri.note, li.nome as nome_linguaggio, pro.nome as nome_profilo, liv.nome as nome_seniority, sr.nome as nome_stato "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr "
			+ "where ri.idSeniority = :idSeniority and ri.idSkill = :idSkill and ri.idProfilo = :idProfilo and ri.idStato = :idStato")
	abstract 
	List stampaCard(int idSeniority, int idSkill, int idProfilo, int idStato);
}