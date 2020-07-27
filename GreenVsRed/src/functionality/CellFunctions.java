package functionality;

import model.Cell;

public class CellFunctions {

	
	public int checkColor(int[][] board, Cell cell) {

		int xCell = cell.getX();
		int yCell = cell.getY();

		if (board[xCell][yCell] == 1) {
			return 1;

		} else {
			return 0;
		}
	}

	public boolean checkChange(int[][] board, Cell cell) {

		int xCell = cell.getX();
		int yCell = cell.getY();

		int greenNeighborsN = neighboursGreen(board, cell);

		int cellColor = board[xCell][yCell];

		if (cellColor == 0 && (greenNeighborsN == 3 || greenNeighborsN == 6)) {
			return true;
		}
		if (cellColor == 1 && (greenNeighborsN != 2 && greenNeighborsN != 3
				&& greenNeighborsN != 6)) {
			return true;
		}

		return false;
	}

	public int neighboursGreen(int[][] board, Cell cell) {
		int xCell = cell.getX();
		int yCell = cell.getY();

		int countGreen = 0;

		for (int xN = xCell - 1; xN <= xCell + 1; xN++) {
			for (int yN = yCell - 1; yN <= yCell + 1; yN++) {

				if ((xN >= 0 && yN >= 0 && xN < board.length && yN < board[0].length) && (xN != xCell || yN != yCell)) {
					if (board[xN][yN] == 1) {
						countGreen++;
					}
				}
			}
		}
		return countGreen;
	}
}
