package com.challenge.minesweeper.service;

import org.springframework.stereotype.Service;

import com.challenge.minesweeper.entity.Game;

@Service
public class GameService {
	
	public Game newGame(String playerName, Integer size, Integer mines) {
		
		Game game = new Game(playerName, size, mines);
		return game;
		
	}

}
