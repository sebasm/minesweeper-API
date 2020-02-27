package com.challenge.minesweeper.entity;

import java.util.Date;
import java.util.UUID;

import com.challenge.minesweeper.dto.EventDto;
import com.challenge.minesweeper.entity.Cell.CellStatus;

public class Game {
	
	public enum GameStatus {
		CREATED, PLAYING, WON, LOST
	}
	
	private UUID gameId;
	private String playerName;
	private Board board;
	private Date creationTime;
	private Date startTime;
	
	public Game(String playerName, Integer size, Integer mines) {
		this.gameId = UUID.randomUUID();
		this.playerName = playerName;
		this.board = new Board(size, mines);
		this.creationTime = new Date();
	}
	
	public void processEvent(EventDto event) {
		switch (event.getEvent()) {
		case LEFT_CLICK:
			board.getCells().get(event.getRow()).get(event.getColumn()).setStatus(CellStatus.REVEALED);
			break;
			
		case RIGHT_CLICK:
			//TODO: implement logic for right click
			break;

		default:
			break;
		}
		
	}
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}

	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public UUID getGameId() {
		return gameId;
	}

	public void setGameId(UUID gameId) {
		this.gameId = gameId;
	}
	
	
	
	
}
