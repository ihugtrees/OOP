package Units;

import Gameplay.Tile;

public abstract class ActiveGameUnit extends Tile {

	private String name;
	private int healthPool;
	private int currentHealth;
	private int attack;
	private int defence;

	public ActiveGameUnit(String name, int healthPool, int currentHealth, int attack, int defence) {
		this.name = name;
		this.healthPool = healthPool;
		this.currentHealth = currentHealth;
		this.attack = attack;
		this.defence = defence;
	}

	public int attack() {
		// TODO - implement Units.ActiveGameUnit.attack
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param attack
	 * @return
	 */
	public int defend(int attack) {
		// TODO - implement Units.ActiveGameUnit.defend
		throw new UnsupportedOperationException();
	}
	public boolean isMovable() {
		return true;
	}

}