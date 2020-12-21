class Liquid{
	void swirl(boolean clockwise){
		System.out.println("Swirling Liquidw");
	}
}

class Coffee extends Liquid{
	void swirl(boolean clockwise){
		System.out.println("Swirling Coffee");
	}
}

class Milk extends Liquid{
	void swirl(boolean clockwise){
		System.out.println("Swirling Milk");
	}
}

class coffeeCup{
	private Liquid innerLiquid;
	
	void addLiquid(Liquid liq){
		innerLiquid.add(liq);
		innerLiquid.swirl(false);
	}
} 

class 2_Utilize_polymorphism_and_casting_to_call_methods{
	public void static void main(String[] args){
		CoffeeCup cup1 = new CoffeeCup();
		Liquid liquid1 = new Liquid();
		Coffee coffee = new Coffee();
		Milk milk = new Milk();
		
		cup1.addLiquid(liquid1);
		cup1.addLiquid(coffee);
		cup1.addLiquid(milk);
	}
}
