interface Animal{
	public void animalSound();
	public void sleep();
}
class Frog implements Animal{
	public void animalSound(){
		System.out.println("The frog says: we-quwik we-quwik");
	}
}
class Dog implements Animal{
	public void animalSound(){
		System.out.println("The Dog says: bark bark");
	}
}
class 2_Create_and_use_interfaces{
	public void static void main(String[] args){
		Frog frog1 = new Frog();
		frog1.animalSound();
		frog1.sleep();
		
		Dog dog1 = new Dog();
		dog1.animalSound();
		dog1.sleep();
	}
}
