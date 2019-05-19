package Units;

import Gameplay.*;

public abstract class Enemy extends ActiveGameUnit {

	public Enemy(String name, int healthPool, int currentHealth, int attack, int defence) {
		super(name, healthPool, currentHealth, attack, defence);
	}

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