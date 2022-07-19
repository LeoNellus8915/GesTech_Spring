package it.teorema.gestech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.teorema.gestech.model.Linguaggi;
import it.teorema.gestech.model.Profili;

public interface LinguaggiService extends JpaRepository <Linguaggi, Integer>
{
	@Query("from Linguaggi")
	abstract
	List <Linguaggi> findAll();
}