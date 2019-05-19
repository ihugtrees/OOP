package Units;

import Gameplay.*;

public abstract class Player extends ActiveGameUnit {

	private int experience = 0;
	private int level = 1;

	public Player(String name, int healthPool, int currentHealth, int attack, int defence) {
		super(name, healthPool, currentHealth, attack, defence);
	}

	@Override
	public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) {
		gameplay.handleCombat(unit,this);
	}
	public abstract void playerAbility(Gameplay gameplay);
}