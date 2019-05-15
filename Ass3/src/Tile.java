public abstract class Tile {

	private char tileSign;
	private Position location;

	/**
	 * 
	 * @param gameplay
	 * @param unit
	 */
	public abstract void unitApproach(Gameplay gameplay, ActiveGameUnit unit) ;

	public abstract boolean isMovable() ;

}