package com.service;

import com.dto.Player;

public interface IPlayerService {

	// operations to be implemented
	public Player addPlayer(Player player);

	public Player deletePlayer(Integer playerID);

	public Player updatePlayer(Player player);

	public Player searchPlayer(Integer playerID);

}
