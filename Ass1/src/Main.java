import Humans.*;

public class Main {

    public static void main(String[] args) {

        Person chris = new Person("Chris");
        Florist fred = new Florist("Fred", null, null, null);
        DeliveryPerson delivery = new DeliveryPerson("Delivery Person");
        Arranger arranger = new Arranger("Flower Arranger");
        Gardner gardener = new Gardner("Gardener");
        Grower grower = new Grower("Grower", gardener);
        Wholesaler saler = new Wholesaler("Wholesaler", grower);
        Person robin = new Person("Robin");
        Florist robins = new Florist("Robin's Florist", delivery, arranger, saler);

        chris.setFlorist(fred);
        robin.setFlorist(robins);

        chris.sendFlowers("Roses, Violets, Gladiolus", robin);
    }
}