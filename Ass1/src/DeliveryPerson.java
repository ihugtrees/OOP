
class DeliveryPerson extends Person {

	private Person robin;

	DeliveryPerson(String name){
		super(name);
		robin = new Robin("Robin");
	}

	@Override
	void sendFlowers(String flowers) {

	}

	@Override
	void sendBouquet(FlowersBouquet bouquet, Person person) {
		System.out.println(getName()+" delivers flowers to "+robin.getName());
		robin.receiveBouquet(bouquet,this);
	}

	@Override
	void receiveFlowers(String flowers, Person sender) {

	}

	@Override
	void receiveBouquet(FlowersBouquet bouquet, Person sender) {
		sendBouquet(bouquet,robin);
	}

}