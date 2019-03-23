
class FlowersBouquet {

    private String flowers;
    private boolean isArranged;

    FlowersBouquet(String flowers) {
        this.flowers = flowers;
        isArranged = false;
    }

    void arrangeBouquet() {
        isArranged = true;
    }

    boolean isArranged(){
        return isArranged;
    }

    String getFlowers() {
        return flowers;
    }
}