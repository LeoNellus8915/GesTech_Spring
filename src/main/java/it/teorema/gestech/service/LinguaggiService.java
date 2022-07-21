package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Linguaggi;

public interface LinguaggiService extends JpaRepository <Linguaggi, Integer>
{
	@Query("from Linguaggi")
	abstract
	List <Linguaggi> findAll();
}