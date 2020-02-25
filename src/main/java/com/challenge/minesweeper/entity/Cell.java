package com.challenge.minesweeper.entity;

public class Cell {

	public enum CellStatus {
		INITIAL, REVEALED, FLAGGED, QUESTIONED
	}

	private Boolean hasBomb;
	private CellStatus status;
	
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
	
	

}
