
public class Chris extends Person {

    Person fred;

    Chris(String name) {
        super(name);
        fred = new Fred("Fred");
        super.sendFlowers("Roses, Violets, Gladiolus",fred);
    }

}