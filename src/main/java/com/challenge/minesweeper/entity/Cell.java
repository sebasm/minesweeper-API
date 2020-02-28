package com.challenge.minesweeper.entity;

public class Cell {

	public enum CellStatus {
		INITIAL, REVEALED, FLAGGED, QUESTIONED, EXPLODED, MINED
	}

	private Boolean hasBomb;
	private CellStatus status;
	private Integer bombsArround;
	
	public Cell() {
		this.status = CellStatus.INITIAL;
		this.hasBomb = false;
	}

	public Cell(Boolean hasBomb) {
		this.hasBomb = hasBomb;
		this.status = CellStatus.INITIAL;
	}

	public Boolean getHasBomb() {
		return hasBomb;
	}

	public void setHasBomb(Boolean hasBomb) {
		this.hasBomb = hasBomb;
	}

	public CellStatus getStatus() {
		return status;
	}

	public void setStatus(CellStatus status) {
		this.status = status;
	}

	public Integer getBombsArround() {
		return bombsArround;
	}

	public void setBombsArround(Integer bombsArround) {
		this.bombsArround = bombsArround;
	}
	
	
	

}
