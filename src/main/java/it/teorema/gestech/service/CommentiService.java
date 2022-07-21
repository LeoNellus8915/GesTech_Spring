package it.teorema.gestech.service;


import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.Commenti;

public interface CommentiService extends JpaRepository <Commenti, Integer>
{
}