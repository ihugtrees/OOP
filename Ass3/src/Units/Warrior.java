package Units;

import Gameplay.Gameplay;
import Gameplay.Position;

public class Warrior extends Player {

	private int cooldown;
	private int remaining = 0;

	public Warrior(char tileSign, Position position, String name, int healthPool, int currentHealth, int attack, int defence, int experience, int level, int cooldown, int remaining) {
		super(tileSign, position, name, healthPool, currentHealth, attack, defence, experience, level);
		this.cooldown = cooldown;
		this.remaining = remaining;
	}

	@Override
	public void playerAbility(Gameplay gameplay) {

	}
}