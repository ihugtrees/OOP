package Units;

import Gameplay.*;

public class Rogue extends Player {

	private int cost;
	private int currentEnergy = 100;

	public Rogue(char tileSign, Position position, String name, int healthPool, int currentHealth, int attack, int defence, int experience, int level, int cost) {
		super(tileSign, position, name, healthPool, currentHealth, attack, defence, experience, level);
		this.cost = cost;
	}

	@Override
	public void playerAbility(Gameplay gameplay) {

	}
}