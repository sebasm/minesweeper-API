package com.challenge.minesweeper.entity;

import java.util.Date;
import java.util.UUID;

public class Game {
	
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