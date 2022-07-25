package it.teorema.gestech.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.teorema.gestech.model.Risorse;

public interface RisorseService extends JpaRepository <Risorse, Integer>
{
	@Query("from Risorse where email = :email")
	abstract
	List<Risorse> findAll(@Param("email") String email);
	
	@Query("from Risorse")
	abstract
	List<Risorse> findAll();
	
	@Query("select max(id) from Risorse")
	abstract
	Integer findId();
	
	@Query("from Risorse where id = :idRisorsa")
	abstract
	Risorse findById(@Param("idRisorsa") int idRisorsa);
	
	@Query("select email "
			+ "from Risorse "
			+ "where email = :email")
	abstract 
	String findByEmail(String email);
	
	@Modifying
	@Query("delete from Risorse where id = :idRisorsa")
	abstract
	void rimuoviCandidato(@Param("idRisorsa") int idRisorsa);
	
	@Modifying
	@Query("update Risorse set nomeCognome = :nomeCognome, recapito = :recapito, profiloLinkedin = :profiloLinkedin, citta = :citta, "
			+ "dataColloquio = :dataColloquio, annoColloquio = :annoColloquio, fonteReperimento = :fonteReperimento, ruoloRisorsa = :ruoloRisorsa, "
			+ "competenzaPrincipale = :competenzaPrincipale, costoGiornaliero = :costoGiornaliero, possibilitaLavorativa = :possibilitaLavorativa, "
			+ "skillCampoLibero = :skillCampoLibero, competenzeTotali = :competenzeTotali, certificazioni = :certificazioni where id = :idRisorsa")
	abstract
	void updateCandidato(@Param("idRisorsa") int idRisorsa, @Param("nomeCognome") String nomeCognome, @Param("recapito") String recapito, 
			@Param("profiloLinkedin") String profiloLinkedin, @Param("citta") String citta, @Param("dataColloquio") LocalDate dataColloquio, 
			@Param("annoColloquio") String annoColloquio, @Param("fonteReperimento") String fonteReperimento, 
			@Param("ruoloRisorsa") String ruoloRisorsa, @Param("competenzaPrincipale") String competenzaPrincipale, 
			@Param("costoGiornaliero") Double costoGiornaliero, @Param("possibilitaLavorativa") String possibilitaLavorativa, 
			@Param("skillCampoLibero") String skillCampoLibero, @Param("competenzeTotali") String competenzeTotali, 
			@Param("certificazioni") String certificazioni);
}