public class EmptySpot extends Tile {
    @Override
    public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) {
        gameplay.unitToEmpty(this,unit);
    }

    @Override
    public boolean isMovable() {
        return false;
    }
}