package com.challenge.minesweeper.entity;

import java.util.Date;
import java.util.UUID;

import com.challenge.minesweeper.dto.EventDto;
import com.challenge.minesweeper.entity.Cell.CellStatus;

public class Game {
	
	public enum GameStatus {
		CREATED, PLAYING, WON, LOST
	}
	
	private String gameId;
	private String playerName;
	private Board board;
	private Date creationTime;
	private Date startTime;
	private GameStatus status;
	
	public Game(String playerName, Integer size, Integer mines) {
		this.gameId = UUID.randomUUID().toString();
		this.playerName = playerName;
		this.board = new Board(size, mines);
		this.creationTime = new Date();
		this.status = GameStatus.CREATED;
	}
	
	public void processEvent(EventDto event) {
		switch (event.getEvent()) {
		case LEFT_CLICK:
			processLeftClick(event);
			break;
			
		case RIGHT_CLICK:
			processRightClick(event);
			break;

		default:
			break;
		}
		
	}

	private void processLeftClick(EventDto event) {
		if(board.getCells().get(event.getRow()).get(event.getColumn()).getHasBomb()) {
			board.getCells().get(event.getRow()).get(event.getColumn()).setStatus(CellStatus.EXPLODED);
			status = GameStatus.LOST;
		} else {
			board.getCells().get(event.getRow()).get(event.getColumn()).setStatus(CellStatus.REVEALED);
		}
	}
	
	private void processRightClick(EventDto event) {
		// TODO: make this happen
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

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public GameStatus getStatus() {
		return status;
	}

	public void setStatus(GameStatus status) {
		this.status = status;
	}

	
	
	
	
	
}
