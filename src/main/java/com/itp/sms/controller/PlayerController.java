//package com.itp.sms.controller;
//
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.itp.sms.model.Player;
//import com.itp.sms.service.PlayerService;
//
//@RestController
//public class PlayerController {
//	
//	@Autowired
//	PlayerService playerService;
//	
//	private static final Logger logger=Logger.getLogger(PlayerController.class);
//	
//	@RequestMapping("/addplayer")
//	public void addPlayer()
//	{
//		Player p=new Player();
//		p.setPname("Alice");
//		p.setMp(100);
//		p.setRs(1000);
//		playerService.addPlayer(p);
//	}
//	
//	@PostMapping("/addplayerbyrequestparam")
//	public String addPlayerByRequestParam(
//			@RequestParam("playername") String strpname,
//			@RequestParam("matches") int matchesPlayed,
//			@RequestParam("rs") int rs
//			)
//	{
//		Player p=new Player();
//		p.setPname(strpname);
//		p.setMp(matchesPlayed);
//		p.setRs(rs);
//		playerService.addPlayer(p);
//		return "Player Record added Successfully";
//	}
//	
//	@PostMapping("/addplayerbyrequestparam1")
//	public Player addPlayerByRequestParam1(
//			@RequestParam("playername") String strpname,
//			@RequestParam("matches") int matchesPlayed,
//			@RequestParam("rs") int rs
//			)
//	{
//		Player p=new Player();
//		p.setPname(strpname);
//		p.setMp(matchesPlayed);
//		p.setRs(rs);
//		return playerService.addPlayer(p);
//	}
//	
//	@PostMapping("/addplayerbyrequestparam2")
//	public ResponseEntity<Player> addPlayerByRequestParam2(
//			@RequestParam("playername") String strpname,
//			@RequestParam("matches") int matchesPlayed,
//			@RequestParam("rs") int rs
//			)
//	{
//		Player p=new Player();
//		p.setPname(strpname);
//		p.setMp(matchesPlayed);
//		p.setRs(rs);
//		return new ResponseEntity<Player>(playerService.addPlayer(p),HttpStatus.CREATED);
//	}
//	
//	
//	@PostMapping("/addplayerbypathvariable/{a}/{b}/{c}")
//	public ResponseEntity<Player> addplayerbypathvariable(
//			@PathVariable("a") String strpname,
//			@PathVariable("b") int matchesPlayed,
//			@PathVariable("c") int rs
//			)
//	{
//		Player p=new Player();
//		p.setPname(strpname);
//		p.setMp(matchesPlayed);
//		p.setRs(rs);
//		Player p1=playerService.addPlayer(p);
//		return new ResponseEntity<Player>(p1,HttpStatus.CREATED);
//	}
//	
//	@PostMapping("/addplayerbypathvariable2/{strpname}/{matchesPlayed}/{rs}")
//	public ResponseEntity<Player> addplayerbypathvariable2(
//			@PathVariable String strpname,
//			@PathVariable int matchesPlayed,
//			@PathVariable int rs
//			)
//	{
//		Player p=new Player();
//		p.setPname(strpname);
//		p.setMp(matchesPlayed);
//		p.setRs(rs);
//		Player p1=playerService.addPlayer(p);
//		return new ResponseEntity<Player>(p1,HttpStatus.CREATED);
//	}
//	
//	
//	@PostMapping("/addplayerbyrequestbody")
//	public ResponseEntity<Player> addplayerbyrequestbody(@RequestBody Player p)
//	{
//		logger.info("Request recieved to add Player " +p.getPname());
//		return new ResponseEntity<Player>(playerService.addPlayer(p),HttpStatus.CREATED);
//	}
//	
//	
//	@PostMapping("/addmultipleplayersbyrequestbody")
//	public ResponseEntity<List<Player>> addmultipleplayersbyrequestbody(@RequestBody List<Player> players)
//	{
//		return new ResponseEntity<List<Player>>(playerService.addMultiplePlayer(players),HttpStatus.CREATED);
//	}
//	
//	
////	@GetMapping("/getPlayerByRequestParam")
////	public ResponseEntity<Player> getPlayerByRequestParam(@RequestParam("pno") int jno)
////	{
////		Player player=playerService.getPlayer(jno);
////		return new ResponseEntity<Player>(player,HttpStatus.OK);
////	}
////
////	@GetMapping("/getPlayerByPathVariable/{jno}")
////	public ResponseEntity<Player> getPlayerByPathVariable(@PathVariable int jno)
////	{
////		Player player=playerService.getPlayer(jno);
////		return new ResponseEntity<Player>(player,HttpStatus.OK);
////	}
//	
//	@GetMapping("/getAllPlayers")
//	public ResponseEntity<List<Player>> getAllPlayers()
//	{
//		List<Player> players=playerService.getAllPlayers();
//		return new ResponseEntity<List<Player>>(players,HttpStatus.OK);
//	}
//	
//	@GetMapping("/getAllPlayersByPagination/{pageNo}/{pageSize}")
//	public ResponseEntity<Page<Player>> getAllPlayersByPagination(@PathVariable int pageNo,@PathVariable int pageSize )
//	{
//		Page<Player> players=playerService.getAllPlayersByPagination(pageNo,pageSize);
//		return new ResponseEntity<Page<Player>>(players,HttpStatus.OK);
//	}
//	
//	@GetMapping("/getAllPlayersByPaginationAndSorting/{pageNo}/{pageSize}/{fieldName}")
//	public ResponseEntity<Page<Player>> getAllPlayersByPaginationAndSorting(@PathVariable int pageNo,@PathVariable int pageSize,@PathVariable String fieldName)
//	{
//		Page<Player> players=playerService.getAllPlayersByPaginationAndSorting(pageNo,pageSize,fieldName);
//		return new ResponseEntity<Page<Player>>(players,HttpStatus.OK);
//	}
//	
//	@GetMapping("/getPlayersGreaterThan/{runs}") //10000
//	public ResponseEntity<List<Player>> getPlayersGreaterThan(@PathVariable int runs)
//	{
//		List<Player> players=playerService.getPlayersShivamGreaterThan(runs);
//		return new ResponseEntity<List<Player>>(players,HttpStatus.OK);
//	}
//
//	@GetMapping("/getPlayerByName/{pname}") //10000
//	public ResponseEntity<List<Player>> getPlayerByName(@PathVariable String pname)
//	{
//		List<Player> players=playerService.getPlayerByName(pname);
//		return new ResponseEntity<List<Player>>(players,HttpStatus.OK);
//	}
//
//	@GetMapping("/getPlayer/{jerseyNo}") //10000
//	public ResponseEntity<Player> getPlayer(@PathVariable int jerseyNo)
//	{
//		Player player=playerService.getPlayer(jerseyNo);
//		return new ResponseEntity<Player>(player,HttpStatus.OK);
//	}
//	
//	@PutMapping("/updatePlayer/{jerseyNo}") //10000
//	public ResponseEntity<Player> updatePlayer(@PathVariable int jerseyNo, @RequestBody Player newDetails)
//	{
//		Player player=playerService.updatePlayer(jerseyNo,newDetails);
//		return new ResponseEntity<Player>(player,HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/deletePlayer/{jerseyNo}") //10000
//	public ResponseEntity<String> deletePlayer(@PathVariable int jerseyNo)
//	{
//		playerService.deletePlayer(jerseyNo);
//		return new ResponseEntity<String>("Player record Deleted",HttpStatus.OK);
//	}
//}
//
///*
//
//Option A
//{
//"jno": 9,
//"pname": "Dhoni",
//"mp": 300,
//"rs": 15000
//}
//
//Option B
//[
//	{
//	"jno": 9,
//	"pname": "Dhoni",
//	"mp": 300,
//	"rs": 15000
//	}
//]
//*/