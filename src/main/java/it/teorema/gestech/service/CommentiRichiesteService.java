package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.CommentiRichieste;

public interface CommentiRichiesteService extends JpaRepository <CommentiRichieste, Integer>
{

}
