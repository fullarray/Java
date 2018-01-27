import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListIteration{
	
	public static void main(String[] args){
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(45);
		numbers.add(26);
		numbers.add(12);
		numbers.add(95);
		
		System.out.println("Untouched ArrayList: "+ numbers.size());
		
		System.out.println("Iterating through ArrayList using Iterator<>: ");
		Iterator<Integer> ite = numbers.iterator();
		
		while(ite.hasNext()){
			System.out.println("The ArrayList element '"+ ite.next() +"' is being removed.");
			ite.remove();
		}
		
		System.out.println("Final ArrayList: "+ numbers.size());
		
	}
}