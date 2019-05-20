package Gameplay;

import java.util.LinkedList;
import java.util.List;

public class Board {

	private Tile[][] board;

	public Board(Tile[][] board) {
		this.board = board;
	}

	/**
	 * 
	 * @param x - x parameter
	 * @param y - y parameter
	 */

	public Tile getTileAt(int x, int y) {
		return board[x][y];
	}

	/**
	 * 
	 * @param radius
	 * @param position
	 */

}