package com.challenge.minesweeper.mapper;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.challenge.minesweeper.dto.BoardDto;
import com.challenge.minesweeper.dto.CellDto;
import com.challenge.minesweeper.dto.GameDto;
import com.challenge.minesweeper.entity.Cell;
import com.challenge.minesweeper.entity.Game;

@Component
public class GameDtoMapper {
	
	public GameDto map(Game game) {
		GameDto gameDto = new GameDto();
		BoardDto boardDto = new BoardDto();
		
		LinkedList<LinkedList<Cell>> cells = game.getBoard().getCells();
		LinkedList<LinkedList<CellDto>> cellsDto = new LinkedList<LinkedList<CellDto>>();
		
		for(int i = 0; i < cells.size(); i++) {
			cellsDto.add(new LinkedList<CellDto>());
			for (int j = 0; j < cells.size(); j++) {
				cellsDto.get(i).add(new CellDto(cells.get(i).get(j).getStatus()));
			}
		}
		
		boardDto.setCells(cellsDto);
		boardDto.setMines(game.getBoard().getMines());
		boardDto.setSize(game.getBoard().getSize());
		
		gameDto.setBoard(boardDto);
		gameDto.setCreationTime(game.getCreationTime());
		gameDto.setGameId(game.getGameId());
		gameDto.setPlayerName(game.getPlayerName());
		gameDto.setStartTime(game.getStartTime());
		
		return gameDto;
	}

}
