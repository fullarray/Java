import java.util.ArrayList;
import java.util.List;

class 4_Use_generics_including_wildcards{

	// java 11
	
	// using wildcard ?
	public static void delCat(List <? extends Cat> catList, Cat cat){
		catList.remove(cat);
		System.out.println("Cat removed");
	}
	
	// using wildcard ?
	public static void addCat (List <? super RedCat> catList){
		catList.add(new RedCat("Red Cat"));
		System.out.println("Cat Added");
	}
	
	// using wildcard ?
	public static void printAll(List <?> list){
		for (Object item: list)
			System.out.println(item + " ");
	}
	
	public static void main(String[] args){
		List<Animal> animalList1 = new ArrayList<Animal>();
		List<RedCat> redCatList1 = new ArrayList<RedCat>();
		
		addCat(animalList1);
		
		addCat(redCatList1);
		addCat(redCatList1);
		addCat(redCatList1);
		
		printAll(animalList1);
		printAll(redCatList1);
		
		Cat cat1 = redCatList1.get(0);
		
		deleteCat(redCatList1, cat1);
		printAll(redCatList1);
	}
}


class Animal{
	String name;
	Animal(String name){
		this.name = name;
	}
	public String toString(){
		return name;
	}
}

class Cat extends Animal{
	Cat(String name){
		super(name);
	}
}


class RedCat extends Cat{
	RedCat(String name){
		super(name);
	}
}

class Dog extends Animal{
	Dog(string name){
		super (name);
	}
}