package Units;

import Gameplay.*;
import Utils.*;
import java.util.List;

public class Trap extends Enemy {

	private int relocationRange;
	private int relocationTime;
	private int visibilityTime;
	private int ticksCount = 0;
	private boolean isVisible;

	public Trap(char tileSign, Position position, String name, int healthPool, int currentHealth, int attack, int defence, int relocationRange, int relocationTime, int visibilityTime, int ticksCount, boolean isVisible) {
		super(tileSign, position, name, healthPool, currentHealth, attack, defence);
		this.relocationRange = relocationRange;
		this.relocationTime = relocationTime;
		this.visibilityTime = visibilityTime;
		this.ticksCount = ticksCount;
		this.isVisible = isVisible;
	}

	@Override
	public void turn(Position playerPosition, Gameplay gameplay) {
		if (ticksCount == relocationTime) {
			ticksCount = 0;
			List<Tile> placesToMove = gameplay.getEmptyTileInRadius(relocationRange, this.getPosition());
			Tile toMove = placesToMove.get(new RandomGeneratorImpl().nextInt(placesToMove.size()));
			gameplay.unitMove(this, toMove.getPosition().getX(), toMove.getPosition().getY());
		} else {
			ticksCount++;
			if (Util.isInRange(this.getPosition().getX(), this.getPosition().getY()
					, playerPosition.getX(), playerPosition.getY(), 2)) {
					gameplay.unitMove(this,playerPosition.getX(),playerPosition.getY());
			}
			if(ticksCount<visibilityTime){
				this.isVisible=true;
			}else {
				this.isVisible=false;
			}
		}

	}
	@Override
	public char getTileSign(){
		if(isVisible){
			return this.tileSign;
		}
		else {
			return '.';
		}
	}
}