package Units;

import Gameplay.Gameplay;

public class Rogue extends Player {

	private int cost;
	private int currentEnergy = 100;

	public Rogue(String name, int healthPool, int currentHealth, int attack, int defence, int cost) {
		super(name, healthPool, currentHealth, attack, defence);
		this.cost = cost;
	}

	@Override
	public void playerAbility(Gameplay gameplay) {

	}
}