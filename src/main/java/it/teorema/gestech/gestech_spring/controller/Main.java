package it.teorema.gestech.gestech_spring.controller;

import java.util.ArrayList;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.teorema.gestech.gestech_spring.model.Risorse;
import it.teorema.gestech.gestech_spring.model.Risorse_Service;

@RestController
public class Main
{
    @Autowired
    Risorse_Service rs;
    
    @ResponseBody
    @RequestMapping("/")
    public ArrayList getRisorse()
    { 
    	ArrayList risorse = new ArrayList();
    	for (int c=0; c<rs.findAll().size(); c++)
    	{
    		Risorse app = (Risorse) rs.findAll().get(c);
    		risorse.add(app);
    	}
        return risorse;
    }
}