package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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
}