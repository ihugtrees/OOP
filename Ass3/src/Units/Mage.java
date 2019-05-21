package Units;

import Gameplay.*;
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
            currentMana = currentMana - cost;
            List<Enemy> monstersInRange = gameplay.enemiesInRange(getPosition(), range);
            if (!monstersInRange.isEmpty())
                for (int hits = 0; hits < hitTimes; hits++) {
                    gameplay.handleCombat(this, monstersInRange.get(RandomGeneratorImpl.getInstance().nextInt(monstersInRange.size())), spellPower);
                }
        }
    }

    @Override
    public void levelUp() {
        manaPool+=25*level;
        currentMana = Math.min(currentMana+(manaPool/4),manaPool);
        spellPower+=10*level;
    }

    public String toString() {
        return "" + this.name + "\t\tHealth: " + this.currentHealth + "\tAttack damage: " + this.attack +
                "\tDefense: " + this.defence + "\n\t\tLevel: " + level + "\tExperience: " + experience + "/" + level * 50 +
                "\tSpellPower: " + spellPower + "\tMana: " + currentMana + "/" + manaPool;
    }

    @Override
    public void turn() {
        currentMana = Math.min(manaPool, currentMana + 1);
    }
}