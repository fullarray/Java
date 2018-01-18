import java.util.*;
import java.util.List;
import java.util.ListIterator;

public class listIterator{
	public static void main(String[] argv){
		ListIterator<String> iter = null;
		List<String> items = new ArrayList<String>();
		items.add("John");
		items.add("Mark");
		items.add("Paula");
		items.add("Manuel");
		
		iter = names.listIterator();
		
		System.out.println("Traverse list forward:");
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		System.out.println("\nTraverse list backward:");
		while(iter.hasPrevious()){
			System.out.println(iter.previous());
		}
	}
}