import java.util.LinkedList;
import java.util.List;

public class Board {

	/**
	 * 
	 * @param x
	 * @param y
	 */
	Tile board[][];
	public Tile getTileAt(int x, int y) {
		// TODO - implement Boards.getTileAt
		return board[x][y];
	}

	/**
	 * 
	 * @param radius
	 * @param position
	 */
	public List<Tile> getEmptyTileInRadius(int radius, Position position) {
		LinkedList<Tile> emptyTiles = new LinkedList<>();//perhaps nulls?
		for (int x = position.getX() - radius < 0 ? 0 : position.getX() - radius;
			 x < board.length && x < position.getX() + radius; x++) {
			for (int y = position.getY() - radius < 0 ? 0 : position.getY() - radius;
				 y < board.length && y < position.getY() + radius; y++) {
				if (board[x][y].isMovable()) {
					emptyTiles.add(board[x][y]);
				}
			}

		}
		return emptyTiles;

	}

}