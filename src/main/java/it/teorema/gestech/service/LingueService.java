package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Lingue;

public interface LingueService extends JpaRepository <Lingue, Integer>
{
	@Query("from Lingue")
	abstract
	List<Lingue> findAll();
}