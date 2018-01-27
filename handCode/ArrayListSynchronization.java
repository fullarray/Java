import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListSynchronization{
	public static void main(String args[]){
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(34);
		numbers.add(54);
		numbers.add(14);
		numbers.add(94);
		numbers.add(11);
		
		numbers = Collections.synchronizedList(numbers);
		
		synchronized(numbers){
			Iterator<Integer> ite = numbers.iterator();
			
			while(ite.hasNext()){
				System.out.println(ite.next());
			}
		}
	}
}