package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.Richieste;

public interface RichiesteService extends JpaRepository <Richieste, Integer>
{
}