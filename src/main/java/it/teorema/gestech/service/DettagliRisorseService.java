package it.teorema.gestech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.teorema.gestech.model.DettagliRisorse;

public interface DettagliRisorseService extends JpaRepository <DettagliRisorse, Integer>
{
	@Query("select r.id, d.dataInserimento, r.nomeCognome, r.citta, r.ruoloRisorsa, r.competenzaPrincipale "
			+ "from DettagliRisorse d, Risorse r where r.id = d.idRisorsa")
	abstract
	List findAll();
}