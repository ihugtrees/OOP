public abstract class Tile {

	protected char tileSign;
	private Position position;

	/**
	 * 
	 * @param gameplay
	 * @param unit
	 */
	public abstract void unitApproach(Gameplay gameplay, ActiveGameUnit unit) ;

	public abstract boolean isMovable() ;
	public Position getPosition(){
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public char getTileSign() {
		return tileSign;
	}
}