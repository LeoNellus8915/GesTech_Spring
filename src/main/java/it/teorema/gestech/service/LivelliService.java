package it.teorema.gestech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.teorema.gestech.model.Livelli;

public interface LivelliService extends JpaRepository <Livelli, Integer>
{
	@Query("from Livelli")
	abstract
	List<Livelli> findAll();
}