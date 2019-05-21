package Gameplay;

import Units.ActiveGameUnit;
import Units.Player;

public class EmptySpot extends Tile {
    public EmptySpot(char tileSign, Position position) {
        super(tileSign, position);
    }

    @Override
    public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) {
        gameplay.unitToEmpty(this, unit);
    }

    @Override
    public void unitApproach(Gameplay gameplay, Player player) {
        gameplay.unitToEmpty(this,player);
    }

    @Override
    public boolean isMovable() {
        return true;
    }

    @Override
    public String whatAmI() {
        return "empty";
    }
}