enum PizzaSize{
	SMALL(2), MEDIUM(4), LARGE(8);

	private int serving;

	PizzaSize(int serving){
		this.serving = serving;
	}

	public int getServing(){
		return this.serving;
	}
}

class PizzaShop{
	 // int value;
	void getMenu(){
		// PizzaSize size = PizzaSize.SMALL;

		// System.out.println("Size: " + size);

		// size = PizzaSize.MEDIUM;

		// System.out.println("Size: " + size);

		System.out.println("Dear Customer, we have the below sizes available currently: ");

		// int value;

		// while(true){
		// 	// int value;
		// 	value = 90;
		// 	this.value = value;
		// }

		// PizzaSize []arr = PizzaSize.values();


		for(PizzaSize size: PizzaSize.values()){
			System.out.println(size + " serves " + size.getServing() + " people");
		}

	}
}

class EnumDemo{
	public static void main(String[] args) {
		new PizzaShop().getMenu();
	}
}