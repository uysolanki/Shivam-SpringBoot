package com.itp.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.sms.exception.PlayerNotFoundException;
import com.itp.sms.model.Player;
import com.itp.sms.repository.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	PlayerRepository playerRepository;

	public Player addPlayer(Player p) {
		return playerRepository.save(p);
		
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
	public Player getPlayer(int jerseyno) {
		Optional<Player> player=playerRepository.findById(jerseyno);
		if(player.isPresent())
			return player.get();
		else
			throw new PlayerNotFoundException("Player with Jersey No " + jerseyno + " Does not Exist");
	}

}
