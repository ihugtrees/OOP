package Units;

import Gameplay.Gameplay;
import Gameplay.Position;

public abstract class Player extends ActiveGameUnit {

    int experience = 0;
    protected int level = 1;

    public Player(char tileSign, Position position, String name, int healthPool, int attack, int defence) {
        super(tileSign, position, name, healthPool, attack, defence);
    }

    public abstract void playerAbility(Gameplay gameplay);

    public abstract void levelUp();

    public abstract void turn();

    public void playerLevelUp() {
        experience = 0;
        level += 1;
        healthPool += 10 * level;
        currentHealth = healthPool;
        attack += 5 * level;
        defence += 2 * level;
        levelUp();
    }

    public boolean checkIfDead(Gameplay gameplay) {
        if (currentHealth <= 0) {
            gameplay.playerDied();
            tileSign = 'X';
            return true;
        }
        return false;
    }

    public void addExperience(int exp){
        experience+=exp;
        if(experience>=level*50)
            playerLevelUp();
    }

    @Override
    public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) {
        gameplay.handleCombat(unit, this, unit.attack());
    }

    @Override
    public void unitApproach(Gameplay gameplay, Player unit) {
    }

    public String whatAmI() {
        return "player";
    }
}