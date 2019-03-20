
class FlowersBouquet {

    private String flowers;
    private boolean isArranged;

    FlowersBouquet(String flowers) {
        this.flowers = flowers;
        isArranged = false;
    }

    public void arrangeBouquet() {
        isArranged = true;
    }

}