
class Arranger extends Person {

    Arranger(String name) {
        super(name);
    }


    void sendFlowers(String flowers) {

    }
    FlowersBouquet arrange(FlowersBouquet flowersBouquet,Person sender){
        System.out.println(getName() + " arranges flowers");
        flowersBouquet.arrangeBouquet();
        System.out.println(getName() + " returns arranged flowers to " + sender.getName());
        return flowersBouquet;

    }
}
