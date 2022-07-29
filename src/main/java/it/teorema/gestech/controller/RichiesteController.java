package it.teorema.gestech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.teorema.gestech.service.CommentiRichiesteService;
import it.teorema.gestech.service.RichiesteService;
import it.teorema.gestech.service.StatiRichiestaService;

@Controller
public class RichiesteController {
	
	@Autowired
	CommentiRichiesteService commentiRichieste;
	@Autowired
	RichiesteService Richieste;
	@Autowired
	StatiRichiestaService statiRichieste;
	
	
}
