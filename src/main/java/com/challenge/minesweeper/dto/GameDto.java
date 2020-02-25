package com.challenge.minesweeper.dto;

import java.util.Date;
import java.util.UUID;

import com.challenge.minesweeper.entity.Board;

public class GameDto {
	
	private UUID gameId;
	private String playerName;
	private BoardDto board;
	private Date creationTime;
	private Date startTime;
	
	public UUID getGameId() {
		return gameId;
	}
	public void setGameId(UUID gameId) {
		this.gameId = gameId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public BoardDto getBoard() {
		return board;
	}
	public void setBoard(BoardDto board) {
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
	

}
