package com.challenge.minesweeper.dto;

import com.challenge.minesweeper.entity.Cell.CellStatus;

public class CellDto {

	private CellStatus status;

	public CellDto(CellStatus status) {
		this.status = status;
	}

	public CellStatus getStatus() {
		return status;
	}

	public void setStatus(CellStatus status) {
		this.status = status;
	}

}
