package Units;

import Gameplay.Gameplay;
import Gameplay.Position;
import Gameplay.Tile;
import IO.StringSubject;
import Utils.RandomGeneratorImpl;

public abstract class ActiveGameUnit extends Tile {

    protected String name;
    int healthPool;
    int currentHealth;
    int attack;
    int defence;

    ActiveGameUnit(char tileSign, Position position, String name, int healthPool, int attack, int defence) {
        super(tileSign, position);
        this.name = name;
        this.healthPool = healthPool;
        this.currentHealth = healthPool;
        this.attack = attack;
        this.defence = defence;
    }

    public String getName() {
        return name;
    }

    public int attack() {
        return RandomGeneratorImpl.getInstance().nextInt(attack);
    }

    /**
     * @param attack - the attacking points of monster
     * @return - damage done to unit
     */
    public int defend(int attack) {
        int defendPoints = RandomGeneratorImpl.getInstance().nextInt(defence);
        StringSubject.getInstance().notifyObservers(this.getName() + " rolled " + defendPoints + " defense points");

        int damage = attack - defendPoints;
        if (damage < 0)
            damage = 0;
        currentHealth = currentHealth - damage;
        return damage;
    }

    public boolean isMovable() {
        return false;
    }

    public abstract void checkIfDead(Gameplay gameplay, ActiveGameUnit attacker);
}