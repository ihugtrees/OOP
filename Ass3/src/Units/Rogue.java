package Units;

import Gameplay.*;
import IO.StringSubject;

import java.util.List;

public class Rogue extends Player {

    private int cost;
    private int currentEnergy = 100;
    private int abilityRange = 2;

    public Rogue(char tileSign, Position position, String name, int healthPool, int attack, int defence, int cost) {
        super(tileSign, position, name, healthPool, attack, defence);
        this.cost = cost;
    }

    @Override
    public void playerAbility(Gameplay gameplay) {
        if (currentEnergy < cost)
            System.out.println("not enough energy");
        else {
            StringSubject.getInstance().notifyObservers(getName() + " cast Fan of Knives.");
            currentEnergy = currentEnergy - cost;
            List<Enemy> monstersInRange = gameplay.enemiesInRange(getPosition(), abilityRange);
            for (Enemy e : monstersInRange)
                e.defend(gameplay, this, attack, true);
        }
    }

    @Override
    public void turn() {
        currentEnergy = Math.min(currentEnergy + 10, 100);
    }

    @Override
    public void levelUp(int health, int attack, int defence) {
        currentEnergy = 100;
        this.attack += 3 * level;
        StringSubject.getInstance().notifyObservers("Level up: +" + health + " Health, +" + (attack + (3 * level)) + " Attack, +" + defence + " Defence");
    }

    public String toString() {
        return name + "\t\tHealth: " + currentHealth + "\t\tAttack damage: " + attack +
                "\t\tDefense: " + defence + "\n\t\tLevel: " + level + "\t\tExperience: " + experience + "/" + level * 50 +
                "\t\tEnergy: " + currentEnergy + "/" + "100";
    }
}