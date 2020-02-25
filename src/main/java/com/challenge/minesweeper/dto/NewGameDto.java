package com.challenge.minesweeper.dto;

public class NewGameDto {
	
	String playerName;
	Integer size;
	Integer mines;
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getMines() {
		return mines;
	}
	public void setMines(Integer mines) {
		this.mines = mines;
	}

}
