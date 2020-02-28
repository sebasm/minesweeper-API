package com.challenge.minesweeper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.minesweeper.dto.EventDto;
import com.challenge.minesweeper.dto.GameDto;
import com.challenge.minesweeper.dto.EventDto.Event;
import com.challenge.minesweeper.entity.Board;
import com.challenge.minesweeper.entity.Cell;
import com.challenge.minesweeper.entity.Game;
import com.challenge.minesweeper.entity.Cell.CellStatus;
import com.challenge.minesweeper.mapper.GameDtoMapper;

@SpringBootTest
public class GameDtoMapperTests {
	
	Integer size = 6;
	Integer mines = 3;
	
	public Game testGame;
	public Board cleanBoard;
	
	GameDtoMapper mapper = new GameDtoMapper();
	
	@BeforeEach
	private void initTestGame() {
		
		testGame = new Game("Test User", size, mines);
		cleanBoard = new Board(size, 0);
		
		LinkedList<LinkedList<Cell>> cells = testGame.getBoard().getCells();
		// Set all cells with hasMine = false
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				cells.get(i).get(j).setHasBomb(false);
			}
		}
		
//		Set bombs in: 
//		(0, 1), (2, 2), (2, 3) and (5, 3)
		cells.get(0).get(1).setHasBomb(true);
		cells.get(2).get(2).setHasBomb(true);
		cells.get(2).get(3).setHasBomb(true);
		cells.get(5).get(3).setHasBomb(true);
	}
	
	@Test
	public void initialGameMap() {
		
	}
	
	@Test
	public void lostGameMap() {
		// this events reveals one cell with no mines
		EventDto event1 = new EventDto(0, 2, Event.LEFT_CLICK);
		testGame.processEvent(event1);
		
		// this test clicks in a mined cell
		EventDto event2 = new EventDto(5, 3, Event.LEFT_CLICK);
		testGame.processEvent(event2);
		
		
		GameDto gameDto = mapper.map(testGame);
		
		//TODO: A board equals to expected should be created so we don't have to test each cell, also ensure a better coverage of all the board
		assertThat(gameDto.getBoard().getCells().get(0).get(2).getStatus().equals(CellStatus.REVEALED));
		assertThat(gameDto.getBoard().getCells().get(5).get(3).getStatus().equals(CellStatus.EXPLODED));
		
		assertThat(gameDto.getBoard().getCells().get(0).get(1).getStatus().equals(CellStatus.MINED));
		assertThat(gameDto.getBoard().getCells().get(2).get(2).getStatus().equals(CellStatus.MINED));
		assertThat(gameDto.getBoard().getCells().get(2).get(3).getStatus().equals(CellStatus.MINED));
		
		assertThat(gameDto.getBoard().getCells().get(1).get(1).getStatus().equals(CellStatus.INITIAL));
		assertThat(gameDto.getBoard().getCells().get(1).get(2).getStatus().equals(CellStatus.INITIAL));
		
	}
	
	

}






























