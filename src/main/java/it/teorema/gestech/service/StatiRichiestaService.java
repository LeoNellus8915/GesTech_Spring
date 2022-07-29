package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.CommentiRisorse;

public interface StatiRichiestaService extends JpaRepository <CommentiRisorse, Integer>
{

}
