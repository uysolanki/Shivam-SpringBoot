package com.itp.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.sms.model.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>
{
	public List<Player> findByRsGreaterThanEqual(int x);
}
