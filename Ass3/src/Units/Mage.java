package Units;

import Gameplay.*;

public class Mage extends Player {

	private int spellPower;
	private int manaPool;
	private int currentMana;
	private int cost;
	private int hitTimes;
	private int range;

	public Mage(String name, int healthPool, int currentHealth, int attack, int defence, int spellPower, int manaPool, int currentMana, int cost, int hitTimes, int range) {
		super(name, healthPool, currentHealth, attack, defence);
		this.spellPower = spellPower;
		this.manaPool = manaPool;
		this.currentMana = manaPool/4;
		this.cost = cost;
		this.hitTimes = hitTimes;
		this.range = range;
	}

	@Override
	public void playerAbility(Gameplay gameplay) {

	}
}