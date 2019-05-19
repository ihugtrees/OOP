public class Wall extends Tile {
    @Override
    public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) {

    }

    @Override
    public boolean isMovable() {
        return false;
    }
}