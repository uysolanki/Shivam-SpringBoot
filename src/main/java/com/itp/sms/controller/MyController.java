package com.itp.sms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itp.sms.model.Player;

@RestController
public class MyController {

	
	@RequestMapping(value={"/virat","/rcb","/ipl"})
	public String test()
	{
		return "virat";
	}
	
	
	
}
