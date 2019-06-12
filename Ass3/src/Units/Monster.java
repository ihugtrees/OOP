package Units;

import Gameplay.*;
import Utils.*;

public class Monster extends Enemy {

    private int visionRange;

    public Monster(char tileSign, Position position, String name, int healthPool, int attack, int defence, int visionRange, int experienceVal) {
        super(tileSign, position, name, healthPool, attack, defence, experienceVal);
        this.visionRange = visionRange;
    }

    @Override
    public char getTileSign() {
        return tileSign;
    }

    @Override
    public void turn(Position playerPosition, Gameplay gameplay) {
        if (rangeUtil.isInRange(playerPosition, getPosition(), visionRange)) {
            int dx = getPosition().getX() - playerPosition.getX();
            int dy = getPosition().getY() - playerPosition.getY();
            if (Math.abs(dx) > Math.abs(dy)) {
                if (dx > 0) {
                    gameplay.monsterMove(this, this.getPosition().getX() - 1, this.getPosition().getY());
                } else {
                    gameplay.monsterMove(this, this.getPosition().getX() + 1, this.getPosition().getY());
                }
            } else {
                if (dy > 0) {
                    gameplay.monsterMove(this, this.getPosition().getX(), this.getPosition().getY() - 1);
                } else {
                    gameplay.monsterMove(this, this.getPosition().getX(), this.getPosition().getY() + 1);
                }
            }
        } else {
            switch (RandomGeneratorImpl.getInstance().nextInt(5)) {
                case 0:
                    return;
                case 1:
                    gameplay.monsterMove(this, this.getPosition().getX() - 1, this.getPosition().getY());
                    break;
                case 2:
                    gameplay.monsterMove(this, this.getPosition().getX() + 1, this.getPosition().getY());
                    break;
                case 3:
                    gameplay.monsterMove(this, this.getPosition().getX(), this.getPosition().getY() - 1);
                    break;
                case 4:
                    gameplay.monsterMove(this, this.getPosition().getX(), this.getPosition().getY() + 1);
                    break;
            }
        }
    }
}