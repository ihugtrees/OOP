import Humans.*;

public class Main {

    public static void main(String[] args) {

        Person chris = new Person("Chris");
        Florist fred = new Florist("Fred", null, null, null);
        DeliveryPerson delivery = new DeliveryPerson("Delivery Humans.Person");
        Arranger arranger = new Arranger("Flower Humans.Arranger");
        Gardner gardener = new Gardner("Humans.Gardner");
        Grower grower = new Grower("Humans.Grower", gardener);
        Wholesaler saler = new Wholesaler("Humans.Wholesaler", grower);
        Person robin = new Person("Robin");
        Florist robins = new Florist("Robin’s Humans.Florist", delivery, arranger, saler);

        chris.setFlorist(fred);
        robin.setFlorist(robins);

        chris.sendFlowers("Roses, Violets, Gladiolus", robin);
    }
}