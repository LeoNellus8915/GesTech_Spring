package it.teorema.gestech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.teorema.gestech.model.Risorse;

public interface RisorseService extends JpaRepository <Risorse, Integer>
{
	@Query("from Risorse where email = :email")
	abstract
	List findAll(@Param("email") String email);
}