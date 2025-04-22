package com.itp.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itp.sms.model.Player;
import com.itp.sms.service.PlayerService;

@RestController
public class PlayerController {
	
	@Autowired
	PlayerService playerService;
	
	@RequestMapping("/addplayer")
	public void addPlayer()
	{
		Player p=new Player();
		p.setPname("Alice");
		p.setMp(100);
		p.setRs(1000);
		playerService.addPlayer(p);
	}

}
