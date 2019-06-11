package Units;

import Gameplay.Gameplay;
import Gameplay.Position;
import IO.StringSubject;

public abstract class Player extends ActiveGameUnit {

    int experience = 0;
    protected int level = 1;

    public Player(char tileSign, Position position, String name, int healthPool, int attack, int defence) {
        super(tileSign, position, name, healthPool, attack, defence);
    }

    public abstract void playerAbility(Gameplay gameplay);

    public abstract void levelUp(int health, int attack, int defence);

    public abstract void turn();

    private void playerLevelUp() {
        experience -= 50 * level;
        level += 1;
        healthPool += 10 * level;
        currentHealth = healthPool;
        attack += 5 * level;
        defence += 2 * level;
        levelUp(10 * level,5 * level,2 * level);
    }

    public void checkIfDead(Gameplay gameplay, ActiveGameUnit attacker) {
        if (currentHealth <= 0) {
            tileSign = 'X';
            gameplay.playerDied();
        }
    }

    public void addExperience(int exp) {
        experience += exp;
        while (experience >= level * 50)
            playerLevelUp();
    }

    @Override
    public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) {
        StringSubject.getInstance().notifyObservers(unit.getName() + " engaged in battle with " + getName() + ":");
        StringSubject.getInstance().notifyObservers(unit.toString());
        StringSubject.getInstance().notifyObservers(toString());
        defend(gameplay, unit, unit.attack(), false);
    }

    @Override
    public void unitApproach(Gameplay gameplay, Player unit) { /*Do nothing*/ }

    @Override
    public char getTileSign() {
        return tileSign;
    }
}