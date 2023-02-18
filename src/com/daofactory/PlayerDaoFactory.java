package com.daofactory;

import com.dao.IPlayerDao;
import com.dao.PlayerDaoImpl;

public class PlayerDaoFactory {

	// to avoid object creation
	private PlayerDaoFactory() {
	}

	private static IPlayerDao playerDao = null;

	// creating a reference of the interface to achieve loose coupling
	public static IPlayerDao getPlayerDao() {

		if (playerDao == null) {
			playerDao = new PlayerDaoImpl();
		}
		return playerDao;
	}
}
