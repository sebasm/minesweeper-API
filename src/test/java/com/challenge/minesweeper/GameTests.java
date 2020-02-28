package com.challenge.minesweeper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.minesweeper.dto.EventDto;
import com.challenge.minesweeper.dto.EventDto.Event;
import com.challenge.minesweeper.entity.Board;
import com.challenge.minesweeper.entity.Cell;
import com.challenge.minesweeper.entity.Cell.CellStatus;
import com.challenge.minesweeper.entity.Game;
import com.challenge.minesweeper.entity.Game.GameStatus;

@SpringBootTest
public class GameTests {
	
	Integer size = 6;
	Integer mines = 3;
	
	public Game testGame;
	public Board cleanBoard;
	
	GameTests() {
		
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
	public void clickEmptyCell() {
		EventDto event = new EventDto(3, 4, Event.LEFT_CLICK);
		testGame.processEvent(event);
		assertThat(testGame.getBoard().getCells().get(3).get(4).getHasBomb().equals(true));
	}
	
	@Test
	public void clickOnBomb(){
		EventDto event = new EventDto(2, 2, Event.LEFT_CLICK);
		testGame.processEvent(event);
		
		assertThat(testGame.getStatus().equals(GameStatus.LOST));
		assertThat(testGame.getBoard().getCells().get(2).get(2).getStatus().equals(CellStatus.EXPLODED));
	}
	
	@Test
	public void flagCell(){
		
	}
	
	@Test
	public void questionCell(){
		
	}

}
