package Units;

import Gameplay.*;

public class Rogue extends Player {

	private int cost;
	private int currentEnergy = 100;

	public Rogue(char tileSign, Position position, String name, int healthPool, int attack, int defence, int cost) {
		super(tileSign, position, name, healthPool,  attack, defence);
		this.cost = cost;
	}

	@Override
	public void playerAbility(Gameplay gameplay) {

	}
	public String toString(){
		return ""+this.name+"\t\tHealth: "+this.currentHealth+"\tAttack damage: "+this.attack+
				"\tDefense: "+this.defence+"\n\t\tLevel: "+level+"\tExperience: "+experience+"/"+level*50+
				"\tEnergy: "+currentEnergy;
	}
}