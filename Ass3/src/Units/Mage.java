package Units;

import Gameplay.*;
import IO.StringSubject;
import Utils.RandomGeneratorImpl;


import java.util.List;

public class Mage extends Player {

    private int spellPower;
    private int manaPool;
    private int currentMana;
    private int cost;
    private int hitTimes;
    private int range;

    public Mage(char tileSign, Position position, String name, int healthPool, int attack, int defence, int spellPower, int manaPool, int cost, int hitTimes, int range) {
        super(tileSign, position, name, healthPool, attack, defence);
        this.spellPower = spellPower;
        this.manaPool = manaPool;
        this.currentMana = manaPool / 4;
        this.cost = cost;
        this.hitTimes = hitTimes;
        this.range = range;
    }

    @Override
    public void playerAbility(Gameplay gameplay) {
        if (currentMana < cost)
            System.out.println("Not enough mana");
        else {
            StringSubject.getInstance().notifyObservers(getName() + " cast Blizzard.");
            currentMana = currentMana - cost;
            List<Enemy> monstersInRange = gameplay.enemiesInRange(getPosition(), range);
            if (!monstersInRange.isEmpty()) {
                StringSubject.getInstance().notifyObservers(getName() + " cast Blizzard.");
                for (int hits = 0; hits < hitTimes; hits++)
                    monstersInRange.get(RandomGeneratorImpl.getInstance().nextInt(monstersInRange.size())).defend(gameplay, this, spellPower, true);
            }
        }
    }

    @Override
    public void levelUp(int health, int attack, int defence) {
        manaPool += 25 * level;
        currentMana = Math.min(currentMana + (manaPool / 4), manaPool);
        spellPower += 10 * level;
        StringSubject.getInstance().notifyObservers("Level up: +" + health + " Health, +" + attack + " Attack, +" + defence +" Defence\n\t\t+" + (25 * level) + " maximum mana, +" + (10 * level) + " spell power");
    }

    public String toString() {
        return name + "\t\tHealth: " + currentHealth + "\t\tAttack damage: " + attack +
                "\t\tDefense: " + defence + "\n\t\tLevel: " + level + "\t\tExperience: " + experience + "/" + level * 50 +
                "\t\tSpellPower: " + spellPower + "\t\tMana: " + currentMana + "/" + manaPool;
    }

    @Override
    public void turn() {
        currentMana = Math.min(manaPool, currentMana + 1);
    }
}