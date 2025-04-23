package com.itp.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.sms.model.Player;
import com.itp.sms.repository.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	PlayerRepository playerRepository;

	public Player addPlayer(Player p) {
		return playerRepository.save(p);
		
	}

}
