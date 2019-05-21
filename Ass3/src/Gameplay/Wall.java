package Gameplay;

import Units.ActiveGameUnit;
import Units.Player;

public class Wall extends Tile {


    public Wall(char tileSign, Position position) {
        super(tileSign, position);
    }

    @Override
    public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) {
        gameplay.unitToWall(this,unit);
    }

    @Override
    public void unitApproach(Gameplay gameplay, Player player) {
        gameplay.unitToWall(this,player);
    }

    @Override
    public boolean isMovable() {
        return false;
    }

    @Override
    public String whatAmI() {
        return "wall";
    }
}