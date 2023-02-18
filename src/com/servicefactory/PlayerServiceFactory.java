package com.servicefactory;

import com.service.IPlayerService;
import com.service.PlayerServiceImpl;

public class PlayerServiceFactory {

	// to avoid object creation
	private PlayerServiceFactory() {
	}

	private static IPlayerService playerService = null;

	// creating a reference of the interface to achieve loose coupling
	public static IPlayerService getPlayerService() {
		if (playerService == null) {
			playerService = new PlayerServiceImpl();
		}
		return playerService;
	}
}
