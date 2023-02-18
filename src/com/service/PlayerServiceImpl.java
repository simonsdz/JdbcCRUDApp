package com.service;

import com.dao.IPlayerDao;
import com.daofactory.PlayerDaoFactory;
import com.dto.Player;

public class PlayerServiceImpl implements IPlayerService {

	private IPlayerDao playerDao;

	@Override
	public Player addPlayer(Player player) {
		// TODO Auto-generated method stub
		playerDao = PlayerDaoFactory.getPlayerDao();
		return playerDao.addPlayer(player);
	}

	@Override
	public Player deletePlayer(Integer playerID) {
		// TODO Auto-generated method stub
		playerDao = PlayerDaoFactory.getPlayerDao();
		return playerDao.deletePlayer(playerID);
	}

	@Override
	public Player updatePlayer(Player player) {
		// TODO Auto-generated method stub
		playerDao = PlayerDaoFactory.getPlayerDao();
		return playerDao.updatePlayer(player);
	}

	@Override
	public Player searchPlayer(Integer playerID) {
		// TODO Auto-generated method stub
		playerDao = PlayerDaoFactory.getPlayerDao();
		return playerDao.searchPlayer(playerID);
	}
}
