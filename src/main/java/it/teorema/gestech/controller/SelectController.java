package it.teorema.gestech.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.teorema.gestech.model.Ruoli;
import it.teorema.gestech.service.RuoliService;

@Controller
public class SelectController {
	@Autowired
	RuoliService ruoli_service;

	@ResponseBody
	@RequestMapping("/stampaRuoli")
	public ArrayList stampaRuoli(HttpServletRequest request, Model theModel)
	{
		ArrayList ruoli = new ArrayList();
		for (int c=0; c<ruoli_service.findAll().size(); c++)
    	{
    		Ruoli app = (Ruoli) ruoli_service.findAll().get(c);
    		ruoli.add(app);
    	}
		return ruoli;
	}
}