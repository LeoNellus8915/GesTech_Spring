package it.teorema.gestech.gestech.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@ResponseBody
	@RequestMapping(value="login", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public HashMap<String, String> executLogin(@RequestBody Map<String, String> json)
	{	
		HashMap<String, String> rs=new HashMap<String, String>();
		
		System.out.println("Entrato");
		return rs;
	}
}
