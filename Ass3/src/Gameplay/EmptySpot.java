package Gameplay;

import Units.ActiveGameUnit;

public class EmptySpot extends Tile {
    public EmptySpot(char tileSign, Position position) {
        super(tileSign, position);
    }

    @Override
    public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) {
        gameplay.unitToEmpty(this,unit);
    }

    @Override
    public boolean isMovable() {
        return true;
    }
}