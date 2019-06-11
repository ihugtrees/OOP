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

    public abstract void turn(Position playerPosition, Gameplay gameplay);

    @Override
    public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) { /*Do nothing*/ }

    @Override
    public void unitApproach(Gameplay gameplay, Player player) {
        StringSubject.getInstance().notifyObservers(player.getName() + " engaged in battle with " + getName() + ":");
        StringSubject.getInstance().notifyObservers(player.toString());
        StringSubject.getInstance().notifyObservers(toString());
        defend(gameplay,player,player.attack(),false);
    }

    public String toString() {
        return name + "\t\tHealth: " + currentHealth + "\t\tAttack damage: " + attack + "\t\tDefense: " + defence;
    }

    public void checkIfDead(Gameplay gameplay, ActiveGameUnit attacker) {
        if (currentHealth <= 0)
            gameplay.handlePlayerKilledEnemy( attacker,this, experienceValue);
    }
}