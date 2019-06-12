package Units;

import Gameplay.Gameplay;
import Gameplay.Position;
import IO.StringSubject;

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
            int tmp = currentHealth;
            currentHealth = Math.min(currentHealth + (2 * defence), healthPool);
            StringSubject.getInstance().notifyObservers(getName() + " cast Heal, healing for " + (currentHealth - tmp));
        }
    }

    @Override
    public void levelUp(int health, int attack, int defence) {
        remaining = 0;
        healthPool += (5 * level);
        this.defence += level;
        StringSubject.getInstance().notifyObservers("Level up: +" + (health + (5 * level)) + " Health, +" + attack + " Attack, +" + (defence + level) + " Defence");
    }

    public String toString() {
        return name + "\t\tHealth: " + currentHealth + "\t\tAttack damage: " + attack +
                "\t\tDefense: " + defence + "\n\t\tLevel: " + level + "\t\tExperience: " + experience + "/" + level * 50 +
                "\t\tAbility cooldown: " + cooldown + "\t\tRemaining: " + remaining;
    }

    @Override
    public void turn() {
        if (remaining > 0)
            remaining = remaining - 1;
    }
}