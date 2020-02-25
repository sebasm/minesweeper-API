package com.challenge.minesweeper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.minesweeper.entity.Board;
import com.challenge.minesweeper.entity.Cell;

@SpringBootTest
class MinesweeperApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void boardCreation() {
		Integer boardSize = 5;
		Integer boardMines = 6;
		
		Board board = new Board(boardSize, boardMines);
		assertThat(board.getMines().equals(6));
		assertThat(board.getSize().equals(5));
		
		//get all mines from the created board
		Integer minesCount = 0;
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				if(board.getCells().get(i).get(j).getHasBomb()) {
					minesCount++;
				}
			}
		}
		
		assertThat(minesCount.equals(boardMines));
	}

}
