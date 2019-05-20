package Units;

import Gameplay.Gameplay;
import Gameplay.Position;
import Gameplay.Tile;
import IO.StringSubject;
import Utils.RandomGeneratorImpl;

public abstract class ActiveGameUnit extends Tile {

    protected String name;
    private int healthPool;
    protected int currentHealth;
    protected int attack;
    protected int defence;

    public ActiveGameUnit(char tileSign, Position position, String name, int healthPool, int attack, int defence) {
        super(tileSign, position);
        this.name = name;
        this.healthPool = healthPool;
        this.currentHealth = healthPool;
        this.attack = attack;
        this.defence = defence;
    }
    public String getName(){
        return name;
    }
    public int attack() {

        int i= RandomGeneratorImpl.getInstance().nextInt(attack);
        StringSubject.getInstance().notifyObservers(this.getName() + " rolled "+i+" attack points");
        return i;
    }

    /**
     * @param attack - the attacking points of monster
     * @return - damage done to unit
     */
    public int defend(int attack) {
        // TODO - implement Units.ActiveGameUnit.defend
        RandomGeneratorImpl rnd = new RandomGeneratorImpl(false);

        int i= RandomGeneratorImpl.getInstance().nextInt(defence);
        StringSubject.getInstance().notifyObservers(this.getName() + " rolled "+i+" defense points");

        int damage = attack-i;
        if (damage < 0)
            damage = 0;
        currentHealth = currentHealth - damage;
        return damage;
    }

    public boolean isMovable() {
        return true;
    }

    //TODO:this
    public abstract boolean checkIfDead(Gameplay gameplay);
}