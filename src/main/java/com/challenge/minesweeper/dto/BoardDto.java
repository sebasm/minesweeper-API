package com.challenge.minesweeper.dto;

import java.util.LinkedList;


public class BoardDto {
	
	private Integer size;
	private Integer mines;
	private LinkedList<LinkedList<CellDto>> cells;
	
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
	public LinkedList<LinkedList<CellDto>> getCells() {
		return cells;
	}
	public void setCells(LinkedList<LinkedList<CellDto>> cells) {
		this.cells = cells;
	}
	

}
