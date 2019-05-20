package Units;

import Gameplay.Gameplay;
import Gameplay.Position;

public abstract class Player extends ActiveGameUnit {

	private int experience = 0;
	private int level = 1;

	public Player(char tileSign, Position position, String name, int healthPool, int currentHealth, int attack, int defence, int experience, int level) {
		super(tileSign, position, name, healthPool, currentHealth, attack, defence);
		this.experience = experience;
		this.level = level;
	}

	@Override
	public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) {
		gameplay.handleCombat(unit,this);
	}
	public void unitApproach(Gameplay gameplay, Player unit) {
		return;
	}
	public abstract void playerAbility(Gameplay gameplay);
}