package Units;

import Gameplay.*;

public class Warrior extends Player {

	private int cooldown;
	private int remaining = 0;

	public Warrior(String name, int healthPool, int currentHealth, int attack, int defence, int cooldown) {
		super(name, healthPool, currentHealth, attack, defence);
		this.cooldown = cooldown;
	}

	@Override
	public void playerAbility(Gameplay gameplay) {

	}
}