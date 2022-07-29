package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Auth;

public interface AuthService extends JpaRepository <Auth, Integer>
{
	@Query("from Auth where idRisorsa = :idRisorsa")
	abstract
	Auth findAll(int idRisorsa);
	
	@Modifying
	@Query("update Auth set password = :password where idRisorsa = :idRisorsa")
	abstract
	void cambiaPassword(String password, int idRisorsa);
}