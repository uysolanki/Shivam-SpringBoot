package com.itp.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.sms.exeption.PlayerNotFoundException;
import com.itp.sms.model.Player;
import com.itp.sms.repository.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	PlayerRepository playerRepository;

	public Player addPlayer(Player p) {
		return playerRepository.save(p);
		
	}

	public Player getPlayer(int jno) {
		Optional<Player> player=playerRepository.findById(jno);
		if(player.isPresent())
			return player.get();
		else
			throw new PlayerNotFoundException("Player does not exist");
					
	}

	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}

	public List<Player> getPlayersShivamGreaterThan(int runs) 
	{
		return playerRepository.findByRsGreaterThanEqual(runs);
	}

	public List<Player> getPlayerByName(String pname) {
		return playerRepository.findByPnameContaining(pname);
	}
}
