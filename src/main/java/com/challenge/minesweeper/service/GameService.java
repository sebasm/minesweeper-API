package com.challenge.minesweeper.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.challenge.minesweeper.dto.EventDto;
import com.challenge.minesweeper.entity.Game;

@Service
public class GameService {
	
	
	public Game newGame(String playerName, Integer size, Integer mines) {
		UUID uuid = UUID.randomUUID();
		Game game = new Game(playerName, size, mines);
		return game;
		
	}
	
	public Game processEvent(EventDto event) {
		
		//get game from redis
		//gameRepository.getGameById(UUId gameId);
		
		Game game = new Game("Name", 7, 7);
		game.processEvent(event);
		
		//save updated game to redis
		//gameRepository.save(game);
		
		//Integer x = 4, Integer y = 3,  ClickType clickType
		
		return game;
	}

}
