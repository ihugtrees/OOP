package Gameplay;

import Units.ActiveGameUnit;

public abstract class Tile {

	protected char tileSign;
	private Position position;

	public Tile(char tileSign, Position position) {
		this.tileSign = tileSign;
		this.position = position;
	}

	public abstract boolean isMovable() ;

	/**
	 * 
	 * @param gameplay
	 * @param unit
	 */
	public abstract void unitApproach(Gameplay gameplay, ActiveGameUnit unit) ;

	public Position getPosition(){
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public char getTileSign(){return tileSign;}
}