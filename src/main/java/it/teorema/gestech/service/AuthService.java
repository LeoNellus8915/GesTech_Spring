package it.teorema.gestech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.teorema.gestech.model.Auth;

public interface AuthService extends JpaRepository <Auth, Integer>
{
	@Query("from Auth where id = :id")
	abstract
	List<Auth> findAll(@Param("id") int id);
}