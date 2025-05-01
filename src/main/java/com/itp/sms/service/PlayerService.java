package com.itp.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	public Player updatePlayer(int jerseyNo, Player newDetails) {
		
		Player playerDB=getPlayer(jerseyNo);
		playerDB.setMp(newDetails.getMp());
		playerDB.setRs(newDetails.getRs());
		playerDB.setPname(newDetails.getPname());
		return playerRepository.save(playerDB);
	}

	public void deletePlayer(int jerseyNo) {
		playerRepository.deleteById(jerseyNo);
	}

	public List<Player> addMultiplePlayer(List<Player> players) {
		return playerRepository.saveAll(players);
	}

	public Page<Player> getAllPlayersByPagination(int pageNo, int pageSize) {
		return playerRepository.findAll(PageRequest.of(pageNo, pageSize));
	}

}
