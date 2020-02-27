package com.challenge.minesweeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.minesweeper.dto.GameDto;
import com.challenge.minesweeper.dto.NewGameDto;
import com.challenge.minesweeper.entity.Game;
import com.challenge.minesweeper.mapper.GameDtoMapper;
import com.challenge.minesweeper.service.GameService;
import com.challenge.minesweeper.dto.EventDto;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class GameController {
	
	@Autowired
	GameService gameService;
	
	@Autowired
	GameDtoMapper gameDtoMapper;
	
	@RequestMapping(value = "/games", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public GameDto newGame(@RequestBody(required = true) NewGameDto newGame) {
		Game game = gameService.newGame(newGame.getPlayerName(), newGame.getSize(), newGame.getMines());
		GameDto gameDto = gameDtoMapper.map(game);
		return gameDto;
	}
	
	@RequestMapping(value = "/games/{id}/events", method = RequestMethod.POST)
	public GameDto clickEvent(@RequestBody(required = true) EventDto event) {
		GameDto gameDto = gameDtoMapper.map(gameService.processEvent(event));
		return gameDto;
	}

}
