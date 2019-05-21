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
        int atk = RandomGeneratorImpl.getInstance().nextInt(attack);
        StringSubject.getInstance().notifyObservers(getName() + " rolled " + atk + " attack points");
        return atk;
    }

    /**
     * @param attack - the attacking points of monster
     */
    void defend(Gameplay gameplay, ActiveGameUnit attacker, int attack, boolean ability) {

        int defendPoints = RandomGeneratorImpl.getInstance().nextInt(defence);
        StringSubject.getInstance().notifyObservers(this.getName() + " rolled " + defendPoints + " defense points.");

        int damage = attack - defendPoints;
        if (damage < 0)
            damage = 0;
        String s = ability ? " ability damage." : " points.";
        StringSubject.getInstance().notifyObservers(attacker.getName() + " hit " + getName() + " for " + damage + s);

        currentHealth = currentHealth - damage;
        checkIfDead(gameplay, attacker);
    }

    public boolean isMovable() {
        return false;
    }

    public abstract void checkIfDead(Gameplay gameplay, ActiveGameUnit attacker);
}