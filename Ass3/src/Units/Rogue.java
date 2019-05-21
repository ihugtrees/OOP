package Units;

import Gameplay.*;

import java.util.List;

public class Rogue extends Player {

    private int cost;
    private int currentEnergy = 100;

    public Rogue(char tileSign, Position position, String name, int healthPool, int attack, int defence, int cost) {
        super(tileSign, position, name, healthPool, attack, defence);
        this.cost = cost;
    }

    @Override
    public void playerAbility(Gameplay gameplay) {
        if (currentEnergy < cost)
            System.out.println("not enough energy");
        else {
            currentEnergy = currentHealth - cost;
            List<Tile> monstersInRange = gameplay.enemiesInRange(getPosition(), 2);
            for (Tile tile : monstersInRange)
               tile.unitApproach(gameplay,this);
        }
    }

    @Override
    public void turn() {
        currentEnergy = Math.min(currentEnergy + 10, 100);
    }

    @Override
    public void levelUp() {
        currentEnergy = 100;
        attack += 3 * level;
    }

    public String toString() {
        return "" + this.name + "\t\tHealth: " + this.currentHealth + "\tAttack damage: " + this.attack +
                "\tDefense: " + this.defence + "\n\t\tLevel: " + level + "\tExperience: " + experience + "/" + level * 50 +
                "\tEnergy: " + currentEnergy;
    }
}