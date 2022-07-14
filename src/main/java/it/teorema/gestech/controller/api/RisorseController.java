package it.teorema.gestech.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.teorema.gestech.model.Risorse;
import it.teorema.gestech.service.RisorseService;

@RestController
public class RisorseController
{
//	@Autowired
//    RisorseService rs;
//	
//	@RequestMapping("/api/risorse")
//	public Iterable<Risorse> getAll()
//	{
//
//		List<Risorse> risorse = new ArrayList<>();
//		for (int c=0; c<rs.findAll().size(); c++)
//    	{
//    		Risorse app = (Risorse) rs.findAll().get(c);
//    		risorse.add(app);
//    	}
//		return risorse;
//	}
}