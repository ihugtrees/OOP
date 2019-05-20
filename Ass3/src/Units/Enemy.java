package Units;

import Gameplay.Gameplay;
import Gameplay.Position;

public abstract class Enemy extends ActiveGameUnit {

	public Enemy(char tileSign, Position position, String name, int healthPool, int currentHealth, int attack, int defence) {
		super(tileSign, position, name, healthPool, currentHealth, attack, defence);
	}

	/**
	 * 
	 * @param playerPosition
	 * @param gameplay
	 */
	public abstract void turn(Position playerPosition, Gameplay gameplay) ;
	public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) {
		return;
	}
	public void unitApproach(Gameplay gameplay, Player player) {
		gameplay.handleCombat(player,this);
	}
}