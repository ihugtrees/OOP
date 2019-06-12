package Gameplay;

import Units.ActiveGameUnit;
import Units.Player;

public class Wall extends Tile {


    Wall(char tileSign, Position position) {
        super(tileSign, position);
    }

    @Override
    public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) {

    }

    @Override
    public void unitApproach(Gameplay gameplay, Player player) {

    }

    @Override
    public char getTileSign() {
        return tileSign;
    }

    @Override
    public boolean isMovable() {
        return false;
    }
}