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
	Risorse findAll(String email);
	
	@Query("from Risorse")
	abstract
	List<Risorse> findAll();
	
	@Query("select id from Risorse where email = :email")
	abstract
	Integer findIdByMail(String email);
	
	@Query("from Risorse where id = :idRisorsa")
	abstract
	Risorse findById(int idRisorsa);
	
	@Query("select email "
			+ "from Risorse "
			+ "where email = :email")
	abstract 
	String findByEmail(String email);
	
	@Query("select email "
			+ "from Risorse "
			+ "where id = :idRisorsa")
	abstract 
	String findEmailById(int idRisorsa);
	
	@Modifying
	@Query("delete from Risorse where id = :idRisorsa")
	abstract
	void rimuoviCandidato(@Param("idRisorsa") int idRisorsa);
	
	@Modifying
	@Query("update Risorse set nomeCognome = :nomeCognome, recapito = :recapito, email = :email, profiloLinkedin = :profiloLinkedin, citta = :citta, "
			+ "dataColloquio = :dataColloquio, annoColloquio = :annoColloquio, fonteReperimento = :fonteReperimento, "
			+ "competenzaPrincipale = :competenzaPrincipale, costoGiornaliero = :costoGiornaliero, possibilitaLavorativa = :possibilitaLavorativa, "
			+ "skillCampoLibero = :skillCampoLibero, competenzeTotali = :competenzeTotali, certificazioni = :certificazioni where id = :idRisorsa")
	abstract
	void updateCandidato(int idRisorsa, String nomeCognome, String recapito, String email, String profiloLinkedin, String citta, LocalDate dataColloquio, 
			String annoColloquio, String fonteReperimento, String competenzaPrincipale, Double costoGiornaliero, String possibilitaLavorativa, 
			String skillCampoLibero, String competenzeTotali, String certificazioni);
}