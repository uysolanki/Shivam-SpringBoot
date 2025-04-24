package com.itp.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/addplayerbyrequestparam")
	public String addPlayerByRequestParam(
			@RequestParam("playername") String strpname,
			@RequestParam("matches") int matchesPlayed,
			@RequestParam("rs") int rs
			)
	{
		Player p=new Player();
		p.setPname(strpname);
		p.setMp(matchesPlayed);
		p.setRs(rs);
		playerService.addPlayer(p);
		return "Player Record added Successfully";
	}
	
	@PostMapping("/addplayerbyrequestparam1")
	public Player addPlayerByRequestParam1(
			@RequestParam("playername") String strpname,
			@RequestParam("matches") int matchesPlayed,
			@RequestParam("rs") int rs
			)
	{
		Player p=new Player();
		p.setPname(strpname);
		p.setMp(matchesPlayed);
		p.setRs(rs);
		return playerService.addPlayer(p);
	}
	
	@PostMapping("/addplayerbyrequestparam2")
	public ResponseEntity<Player> addPlayerByRequestParam2(
			@RequestParam("playername") String strpname,
			@RequestParam("matches") int matchesPlayed,
			@RequestParam("rs") int rs
			)
	{
		Player p=new Player();
		p.setPname(strpname);
		p.setMp(matchesPlayed);
		p.setRs(rs);
		return new ResponseEntity<Player>(playerService.addPlayer(p),HttpStatus.CREATED);
	}
	
	
	@PostMapping("/addplayerbypathvariable/{a}/{b}/{c}")
	public ResponseEntity<Player> addplayerbypathvariable(
			@PathVariable("a") String strpname,
			@PathVariable("b") int matchesPlayed,
			@PathVariable("c") int rs
			)
	{
		Player p=new Player();
		p.setPname(strpname);
		p.setMp(matchesPlayed);
		p.setRs(rs);
		Player p1=playerService.addPlayer(p);
		return new ResponseEntity<Player>(p1,HttpStatus.CREATED);
	}
	
	@PostMapping("/addplayerbypathvariable2/{strpname}/{matchesPlayed}/{rs}")
	public ResponseEntity<Player> addplayerbypathvariable2(
			@PathVariable String strpname,
			@PathVariable int matchesPlayed,
			@PathVariable int rs
			)
	{
		Player p=new Player();
		p.setPname(strpname);
		p.setMp(matchesPlayed);
		p.setRs(rs);
		Player p1=playerService.addPlayer(p);
		return new ResponseEntity<Player>(p1,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/addplayerbyrequestbody")
	public ResponseEntity<Player> addplayerbyrequestbody(@RequestBody Player p)
	{
		return new ResponseEntity<Player>(playerService.addPlayer(p),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getPlayerByRequestParam")
	public ResponseEntity<Player> getPlayerByRequestParam(@RequestParam("pno") int jno)
	{
		Player player=playerService.getPlayer(jno);
		return new ResponseEntity<Player>(player,HttpStatus.OK);
	}
	
	@GetMapping("/getPlayerByPathVariable/{jno}")
	public ResponseEntity<Player> getPlayerByPathVariable(@PathVariable int jno)
	{
		Player player=playerService.getPlayer(jno);
		return new ResponseEntity<Player>(player,HttpStatus.OK);
	}
	
	@GetMapping("/getAllPlayers")
	public ResponseEntity<List<Player>> getAllPlayers()
	{
		List<Player> players=playerService.getAllPlayers();
		return new ResponseEntity<List<Player>>(players,HttpStatus.OK);
	}

}

/*
{
"jno": 8,
"pname": "Jasprit",
"mp": 5,
"rs": 70
}
*/