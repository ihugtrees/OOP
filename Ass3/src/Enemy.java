public abstract class Enemy extends ActiveGameUnit {

	/**
	 * 
	 * @param playerPosition
	 * @param gamepaly
	 */
	public abstract void turn(Position playerPosition, Gameplay gamepaly) ;
	public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) {
		gameplay.handleCombat(unit,this);
	}

}