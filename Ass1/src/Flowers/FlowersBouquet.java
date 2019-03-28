package Flowers;

public class FlowersBouquet {

    private String flowers;
    private boolean isArranged;

    public FlowersBouquet(String flowers) {
        this.flowers = flowers;
        isArranged = false;
    }

    public void arrangeBouquet() {
        isArranged = true;
    }

    public boolean isArranged(){
        return isArranged;
    }

    public String getFlowers() {
        return flowers;
    }
}