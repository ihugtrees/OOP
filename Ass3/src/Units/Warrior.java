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

	}
	public String toString(){
		return ""+this.name+"\t\tHealth: "+this.currentHealth+"\tAttack damage: "+this.attack+
				"\tDefense: "+this.defence+"\n\t\tLevel: "+level+"\tExperience: "+experience+"/"+level*50+
				"\tAbility cooldown: "+cooldown+"\tRemaining: "+remaining;
	}
}