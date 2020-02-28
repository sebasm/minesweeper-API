package com.challenge.minesweeper.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.challenge.minesweeper.dto.EventDto;
import com.challenge.minesweeper.entity.Game;
import com.challenge.minesweeper.exception.GameNotFoundException;
import com.challenge.minesweeper.exception.TooManyMinesException;

@Service
public class GameService {
	
	private Map<String, Game> games = new HashMap<String, Game>();
	
	
	public Game newGame(String playerName, Integer size, Integer mines) {
		if(mines >= size*size) {
			throw new TooManyMinesException("Can't set more mines than cells.");
		}
		Game game = new Game(playerName, size, mines);
		games.put(game.getGameId().toString(), game);
		return game;
		
	}
	
	public Game processEvent(String gameId, EventDto event) {
		
		Game game = games.get(gameId);
		if(game == null) {
			throw new GameNotFoundException("Game not found with the given id.");
		}
		//TODO: check if coordinates exceed matrix bounds
		game.processEvent(event);
		
		return game;
	}

}
