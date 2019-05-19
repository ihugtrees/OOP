package Gameplay;

import Units.ActiveGameUnit;

public class Wall extends Tile {


    @Override
    public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) {

    }

    @Override
    public boolean isMovable() {
        return false;
    }

    @Override
    public char getTileSign() {
        return '#';
    }
}