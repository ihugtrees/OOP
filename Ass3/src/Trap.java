import java.util.List;

public class Trap extends Enemy {

	private int relocationRange;
	private int relocationTime;
	private int visibilityTime;
	private int ticksCount;
	private boolean isVisible;

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