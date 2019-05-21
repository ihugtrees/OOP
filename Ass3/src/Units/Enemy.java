package Units;

import Gameplay.Gameplay;
import Gameplay.Position;
import IO.StringSubject;

public abstract class Enemy extends ActiveGameUnit {
    private int experienceValue;

    Enemy(char tileSign, Position position, String name, int healthPool, int attack, int defence, int experienceVal) {
        super(tileSign, position, name, healthPool, attack, defence);
        this.experienceValue = experienceVal;
    }

    /**
     * @param playerPosition
     * @param gameplay
     */
    public abstract void turn(Position playerPosition, Gameplay gameplay);

    @Override
    public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) {
    }

    @Override
    public void unitApproach(Gameplay gameplay, Player player) {
        StringSubject.getInstance().notifyObservers(player.getName() + " engaged in battle with " + getName() + ":");
        StringSubject.getInstance().notifyObservers(player.toString());
        StringSubject.getInstance().notifyObservers(toString());
        defend(gameplay,player,player.attack(),false);
    }

    public String toString() {
        return name + "\t\tHealth: " + currentHealth + "\tAttack damage: " + attack + "\tDefense: " + defence;
    }

    public void checkIfDead(Gameplay gameplay, ActiveGameUnit attacker) {
        if (currentHealth <= 0)
            gameplay.handlePlayerKilledEnemy( attacker,this, experienceValue);
    }

    public String whatAmI() {
        return "enemy";
    }
}