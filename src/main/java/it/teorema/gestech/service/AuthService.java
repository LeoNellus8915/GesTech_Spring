package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.teorema.gestech.model.Auth;

public interface AuthService extends JpaRepository <Auth, Integer>
{
	@Query("from Auth where idRisorsa = :idRisorsa")
	abstract
	List<Auth> findAll(@Param("idRisorsa") int idRisorsa);
	
	@Modifying
	@Query("update Auth set password = :password where idRisorsa = :idRisorsa")
	abstract
	void cambiaPassword(@Param("password") String password, @Param("idRisorsa") int idRisorsa);
}