package Units;

import Gameplay.Gameplay;
import Gameplay.Position;

public abstract class Enemy extends ActiveGameUnit {
	int experienceValue;
	public Enemy(char tileSign, Position position, String name, int healthPool, int attack, int defence,int experienceVal) {
		super(tileSign, position, name, healthPool, attack, defence);
		this.experienceValue = experienceVal;
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