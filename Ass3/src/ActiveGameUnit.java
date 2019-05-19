public abstract class ActiveGameUnit extends Tile {

	private String name;
	private int healthPool;
	private int currentHealth;
	private int attack;
	private int defence;

	public int attack() {
		// TODO - implement ActiveGameUnit.attack
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param attack
	 * @return
	 */
	public int defend(int attack) {
		// TODO - implement ActiveGameUnit.defend
		throw new UnsupportedOperationException();
	}
	public boolean isMovable() {
		return true;
	}

}