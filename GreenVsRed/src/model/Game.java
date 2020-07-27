package model;

import java.io.IOException;

import functionality.CellFunctions;
import functionality.GameFunctions;

public interface Game {
	Value value = null;
	CellFunctions cellFunctions = new CellFunctions();

	GameFunctions gameFunctions = new GameFunctions();

	void run();

	void build(int[][] board) throws IOException;

	int iterations(int iterations, int height, int width, int board[][], Cell cell, int count);
}
