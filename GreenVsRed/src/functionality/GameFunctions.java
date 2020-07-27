package functionality;

import java.io.IOException;
import java.util.Scanner;

import model.Cell;
import model.Game;
import model.Value;

public class GameFunctions implements Game {
	private CellFunctions cellFunctions = new CellFunctions();
	private Value value;

	public GameFunctions() {
		this.value = new Value(new Scanner(System.in));
	}

	public void run() {
		int[][] board = null;
		String[] boardSize = null;
		try {
			boardSize = value.readLine(", ");
		} catch (IOException e) {

			e.printStackTrace();
		}
		if (boardSize.length != 2) {

			System.out.println("the lenght must be 2");
		}
		int width = Integer.parseInt(boardSize[0]);
		int height = Integer.parseInt(boardSize[1]);
		board = new int[height][width];
		try {
			build(board);
		} catch (IOException e) {

			e.printStackTrace();
		}
		String[] fCellAndIter = null;
		try {
			fCellAndIter = value.readLine(", ");
		} catch (IOException e) {

			e.printStackTrace();
		}
		int[] secInput = new int[3];
		for (int i = 0; i < secInput.length; i++) {

			secInput[i] = Integer.parseInt(fCellAndIter[i]);
		}
		Cell cell = new Cell(secInput[1], secInput[0]);

		int iterations = secInput[2];
		int count = 0;
		if (cellFunctions.checkColor(board, cell) == 1) {
			count++;
		}
//output the return value of iteration method which is the answer
		System.out.println(iterations(iterations, height, width, board, cell, count));
	}

	// building a board with the user input
	@Override
	public void build(int[][] board) throws IOException {
		for (int row = 0; row < board.length; row++) {
			// splitting the line
			String[] rowArray = value.readLine("");
			for (int col = 0; col < rowArray.length; col++) {
				board[row][col] = Integer.parseInt(rowArray[col]);
			}
		}

	}

	// method that counts the number of green during iterations
	@Override
	public int iterations(int iterations, int height, int width, int board[][], Cell cell, int count) {
		for (int i = 0; i < iterations; i++) {
			int[][] newBoard = new int[height][width];
			for (int r = 0; r < board.length; r++) {
				for (int j = 0; j < board[0].length; j++) {
					if (cellFunctions.checkChange(board, new Cell(r, j))) {
						int boardColorCell = board[r][j];
						newBoard[r][j] = (boardColorCell == 0 ? 1 : 0);
					} else {
						newBoard[r][j] = board[r][j];
					}
				}
			}
			board = newBoard;
			// check if the cell is green and if yes=>increment "count"
			if (cellFunctions.checkColor(board, cell) == 1) {
				count++;
			}
		}
		return count;
	}
}
