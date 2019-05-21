package Units;

import Gameplay.Gameplay;
import Gameplay.Position;

public class Warrior extends Player {

    private int cooldown;
    private int remaining = 0;

    public Warrior(char tileSign, Position position, String name, int healthPool, int attack, int defence, int cooldown) {
        super(tileSign, position, name, healthPool, attack, defence);
        this.cooldown = cooldown;
    }

    @Override
    public void playerAbility(Gameplay gameplay) {
        if (remaining > 0)
            System.out.println("Can't use ability yet");
        else {
            remaining = cooldown;
            currentHealth = Math.min(currentHealth + (2 * defence), healthPool);
        }
    }

    @Override
    public void levelUp() {
        remaining = 0;
        healthPool += (5 * level);
        defence += level;
    }

    public String toString() {
        return "" + this.name + "\t\tHealth: " + this.currentHealth + "\tAttack damage: " + this.attack +
                "\tDefense: " + this.defence + "\n\t\tLevel: " + level + "\tExperience: " + experience + "/" + level * 50 +
                "\tAbility cooldown: " + cooldown + "\tRemaining: " + remaining;
    }

    @Override
    public void turn() {
        if (remaining > 0)
            remaining = remaining - 1;
    }
}