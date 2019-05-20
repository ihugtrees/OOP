package Units;

import Gameplay.Position;
import Gameplay.Tile;
import Utils.RandomGeneratorImpl;

public abstract class ActiveGameUnit extends Tile {

    private String name;
    private int healthPool;
    private int currentHealth;
    private int attack;
    private int defence;

    public ActiveGameUnit(char tileSign, Position position, String name, int healthPool, int currentHealth, int attack, int defence) {
        super(tileSign, position);
        this.name = name;
        this.healthPool = healthPool;
        this.currentHealth = currentHealth;
        this.attack = attack;
        this.defence = defence;
    }

    public int attack() {
        RandomGeneratorImpl rnd = new RandomGeneratorImpl(false);
        return rnd.nextInt(attack);
    }

    /**
     * @param attack - the attacking points of monster
     * @return - damage done to unit
     */
    public int defend(int attack) {
        // TODO - implement Units.ActiveGameUnit.defend
        RandomGeneratorImpl rnd = new RandomGeneratorImpl(false);
        int damage = rnd.nextInt(defence) - attack;
        if (damage > 0)
            damage = 0;
        currentHealth = currentHealth + damage;
        return damage;
    }

    public boolean isMovable() {
        return true;
    }
}