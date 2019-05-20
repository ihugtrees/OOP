package Units;

import Gameplay.*;
import Utils.*;

public class Monster extends Enemy {

	private int visionRange;

	public Monster(char tileSign, Position position, String name, int healthPool, int currentHealth, int attack, int defence, int visionRange) {
		super(tileSign, position, name, healthPool, currentHealth, attack, defence);
		this.visionRange = visionRange;
	}

	@Override
	public void turn(Position playerPosition, Gameplay gameplay) {
		if(Util.isInRange(playerPosition.getX(),playerPosition.getY()
				,this.getPosition().getX(),this.getPosition().getY(),visionRange)){
			int dx = this.getPosition().getX()-playerPosition.getX();
			int dy = this.getPosition().getY()-playerPosition.getY();
			if(dx>dy){
				if(dx>0){
					gameplay.unitMove(this,this.getPosition().getX()-1,this.getPosition().getY());
				}
				else{
					gameplay.unitMove(this,this.getPosition().getX()+1,this.getPosition().getY());
				}
			}
			else{
				if(dy>0){
					gameplay.unitMove(this,this.getPosition().getX(),this.getPosition().getY()+1);
				}
				else{
					gameplay.unitMove(this,this.getPosition().getX(),this.getPosition().getY()-1);
				}
			}
		}else{
			//TODO: Random move
		}
	}
}