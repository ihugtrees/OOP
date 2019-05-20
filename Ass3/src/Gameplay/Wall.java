package Gameplay;

import Units.ActiveGameUnit;

public class Wall extends Tile {


    public Wall(char tileSign, Position position) {
        super(tileSign, position);
    }

    @Override
    public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) {
        gameplay.unitToWall(this,unit);
    }

    @Override
    public boolean isMovable() {
        return false;
    }
}