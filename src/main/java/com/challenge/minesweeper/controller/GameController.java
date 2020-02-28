package com.challenge.minesweeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.challenge.minesweeper.dto.GameDto;
import com.challenge.minesweeper.dto.NewGameDto;
import com.challenge.minesweeper.entity.Game;
import com.challenge.minesweeper.exception.GameNotFoundException;
import com.challenge.minesweeper.exception.TooManyMinesException;
import com.challenge.minesweeper.mapper.GameDtoMapper;
import com.challenge.minesweeper.service.GameService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.challenge.minesweeper.dto.EventDto;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class GameController {
	
	@Autowired
	GameService gameService;
	
	@Autowired
	GameDtoMapper gameDtoMapper;
	
	@ApiOperation(value = "Creates a new game", notes = "This endpoints receives the player name, the board size and desired mines quantity and returns a new game.")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Board created successfully.", response = GameDto.class),
			@ApiResponse(code = 500, message = "Internal server error.", response = String.class),
			@ApiResponse(code = 400, message = "Board can't be created, missing data or data inconsistency.", response = String.class)})
	@RequestMapping(value = "/games", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public GameDto newGame(@RequestBody(required = true) NewGameDto newGame) {
		Game game = null;
		try {
			game = gameService.newGame(newGame.getPlayerName(), newGame.getSize(), newGame.getMines());
		} catch (TooManyMinesException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
		GameDto gameDto = gameDtoMapper.map(game);
		return gameDto;
	}
	
	@ApiOperation(value = "Handles clicks on cells", notes = "This endpoint receives coordinates and type of click and returs the game and it's board with the new state.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Event received and processes succesfully.")})
	@RequestMapping(value = "/games/{id}/events", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public GameDto clickEvent(@RequestBody(required = true) EventDto event, @PathVariable("id") String gameId) {
		GameDto gameDto = null;
		try {
			gameDto = gameDtoMapper.map(gameService.processEvent(gameId, event));
		} catch (GameNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
		return gameDto;
	}

}
