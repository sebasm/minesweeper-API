package com.challenge.minesweeper.entity;

import java.util.Random;

public class Board {
	
	private Integer size;
	private Integer mines;
	private Cell[][] cells;
	
	public Board(Integer size, Integer mines) {
		
		this.size = size;
		this.mines = mines;
		this.cells = new Cell[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				cells[i][j] = new Cell();
			}
		}
		
		Integer remainingMinesToAssign = mines;
		Random random = new Random();
		while(remainingMinesToAssign > 0) {
			int x = random.nextInt(size);
			int y = random.nextInt(size);
			if(!cells[x][y].getHasBomb()) {
				cells[x][y].setHasBomb(true);
				remainingMinesToAssign--;
			}
		}
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

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	
	

}
