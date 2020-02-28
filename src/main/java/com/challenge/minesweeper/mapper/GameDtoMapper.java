package com.challenge.minesweeper.mapper;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.challenge.minesweeper.dto.BoardDto;
import com.challenge.minesweeper.dto.CellDto;
import com.challenge.minesweeper.dto.GameDto;
import com.challenge.minesweeper.entity.Cell;
import com.challenge.minesweeper.entity.Game;
import com.challenge.minesweeper.entity.Cell.CellStatus;
import com.challenge.minesweeper.entity.Game.GameStatus;

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
				
				// if game is lost, reveal all hidden mines, else keep them as they are
				if(game.getStatus().equals(GameStatus.LOST)) {
					mapGameLost(cells, cellsDto, i, j);
				} else {
					cellsDto.get(i).add(new CellDto(cells.get(i).get(j).getStatus()));
				}
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

	private void mapGameLost(LinkedList<LinkedList<Cell>> cells, LinkedList<LinkedList<CellDto>> cellsDto, int i,
			int j) {
		if(cells.get(i).get(j).getHasBomb() && !cells.get(i).get(j).getStatus().equals(CellStatus.EXPLODED)) {
			cellsDto.get(i).add(new CellDto(CellStatus.MINED));
		} else {
			cellsDto.get(i).add(new CellDto(cells.get(i).get(j).getStatus()));
		}
	}

}
