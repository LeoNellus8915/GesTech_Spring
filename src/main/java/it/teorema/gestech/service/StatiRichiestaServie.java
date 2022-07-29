package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.CommentiRisorse;

public interface StatiRichiestaServie extends JpaRepository <CommentiRisorse, Integer>
{

}
