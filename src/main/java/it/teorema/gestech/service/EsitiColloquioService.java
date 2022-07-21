package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.EsitiColloquio;

public interface EsitiColloquioService extends JpaRepository <EsitiColloquio, Integer>
{
	@Query("from EsitiColloquio")
	abstract
	List <EsitiColloquio> findAll();
}