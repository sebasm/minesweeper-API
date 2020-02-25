package com.challenge.minesweeper.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.challenge.minesweeper.entity.Game;

@Service
public class GameService {
	
	public Game newGame(String playerName, Integer size, Integer mines) {
		UUID uuid = UUID.randomUUID();
		Game game = new Game(playerName, size, mines);
		return game;
		
	}

}
