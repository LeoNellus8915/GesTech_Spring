package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.Menu;

public interface MenuService extends JpaRepository <Menu, Integer>
{
}