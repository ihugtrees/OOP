
public class Main {

    public static void main(String[] args) {
        Person chris = new Person("Chris");
        Florist fred = new Florist("fred", null, null, null);
        chris.setFlorist(fred);

        DeliveryPerson delivery = new DeliveryPerson("Delivery Person");
        Arranger arranger = new Arranger("Flower Arranger");
        Gardner gardener = new Gardner("Gardner");
        Grower grower = new Grower("grower", gardener);
        Wholesaler saler = new Wholesaler("Wholesaler", grower);

        Person robin = new Person("Robin");

        Florist robins = new Florist("Robin’s Florist", delivery, arranger, saler);
        robin.setFlorist(robins);

        chris.sendFlowers("Roses, Violets, Gladiolus",robin);
    }
}