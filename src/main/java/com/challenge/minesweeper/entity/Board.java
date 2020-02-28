package com.challenge.minesweeper.entity;

import java.util.LinkedList;
import java.util.Random;

public class Board {
	
	private Integer size;
	private Integer mines;
	private LinkedList<LinkedList<Cell>> cells;
	
	public Board(Integer size, Integer mines) {
		
		this.size = size;
		this.mines = mines;
		this.cells = new LinkedList<LinkedList<Cell>>();
		
		for(int i = 0; i < size; i++) {
			cells.add(new LinkedList<Cell>());
			for(int j = 0; j < size; j++) {
				cells.get(i).add(new Cell());
			}
		}
		
		Integer remainingMinesToAssign = mines;
		Random random = new Random();
		while(remainingMinesToAssign > 0) {
			int row = random.nextInt(size);
			int column = random.nextInt(size);
			if(!cells.get(row).get(column).getHasBomb()) {
				System.out.println("Row: " + row + " Column: " + column);
				cells.get(row).get(column).setHasBomb(true);
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

	public LinkedList<LinkedList<Cell>> getCells() {
		return cells;
	}

	public void setCells(LinkedList<LinkedList<Cell>> cells) {
		this.cells = cells;
	}

	
	
	
	

}
